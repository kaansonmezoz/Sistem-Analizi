package savt;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;


/**
 * Created by khan on 07.05.2017.
 */

public class Muhasebe implements java.io.Serializable {

    // mantiken program baslandiginda txt'e eklenen dosyalar okunmali mainde
    // ilgili ayin gozune islem yapilir. yil sonuyla ilgli bir islemimiz yok.
    private ArrayList<Double> aylikTutarToplami;
    private ArrayList<Integer> aylikToplamMusteri;
    private ArrayList<Double> aylikKasaAcigi;
    private ArrayList<Double> aylikToplamGider;
    private int ay ;
    private int gun;
    private int yil;
    private ArrayList<Personel> calisanlar;

    // TODO: calisanlar textten cekilip eklenilecek
    public Muhasebe(){
        calisanlar = new ArrayList<Personel>();
        aylikTutarToplami = new ArrayList<Double>(12);
        aylikToplamMusteri = new ArrayList<Integer>(12);
        aylikToplamGider = new ArrayList<Double>(12);
        aylikKasaAcigi = new ArrayList<Double>(12);
        for(int i = 0;i < 12;i++){
            aylikTutarToplami.add((double) 0);
            aylikToplamGider.add((double) 0);
            aylikKasaAcigi.add(0.0);
            aylikToplamMusteri.add(0);
        }
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        ay = cal.get(Calendar.MONTH);
        gun = cal.get(Calendar.DAY_OF_MONTH);
        yil = cal.get(Calendar.YEAR);
    }
    // yıl sonu geldigi zaman yapilacak sey belli degil ona da bakmak gerekecek
    // parametre olarak alinan aylarin yanlis olma durumunda bir handle yapilmasi gerek
    // 0..11 e kadar gidiyor ay sayisi indis olarak
    public void setAylikTutarToplami(double toplamTutar,int ay) {
        aylikTutarToplami.set(ay,toplamTutar);
    }

    public void setAylikToplamMusteri(int toplamMusteri,int ay) {
        aylikToplamMusteri.set(ay,toplamMusteri);
    }

    public void setAylikKasaAcigi(double kasaAcigi,int ay) {
        aylikKasaAcigi.set(ay,kasaAcigi);
    }

    public void setAylikToplamGider(double toplamGider,int ay){
        aylikToplamGider.set(ay,toplamGider);
    }

    public void setAy(int ay){
        this.ay = ay;
    }

    public void setGun(int gun) {
        this.gun = gun;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }

    //  buna bakmam lazim objenin degerini double olarak mi donduruyor yoksa objeyi mi
    public double getAylikTutarToplami(int ay) {
        return aylikTutarToplami.get(ay);
    }

    public int getAylikToplamMusteri(int ay) {
        return aylikToplamMusteri.get(ay);
    }

    public double getAylikKasaAcigi(int ay) {
        return aylikKasaAcigi.get(ay);
    }

    public int getAy(){
        return ay;
    }

    public int getYil() {
        return yil;
    }

    public int getGun() {
        return gun;
    }

    // ilk basta gunumuz date olarak 2 ise 3 gecildiginde 2 nin degerini atar diziye
    // mainde parametre olarak gonderilecek magazadaki arrayList
    public void gunSonu(ArrayList<Urun> urunler,Kasa kasa){
        // yani yeni gun geldigi zaman eklenecek degerler, ve kontrol edilmeli yeni gun ayni zamanda
        // yeni ay mi getiriyor eger ki yeni ay getiriyorsa ayin indisi de degistirilmeli.
        // gunlukTutarToplami gibi digerlerinin degerlerini alinip oraya yazilacak ilk parametre
        // olarak set...() icin
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if(gun != cal.get(Calendar.DAY_OF_MONTH)) {
            double yevmiye = 0;
            double siparisGideri = 0;
            for(Personel personel : calisanlar){
              yevmiye +=  personel.getMaasCarpani() * personel.getWorkHour();
            }
            aylikTutarToplami.set(ay,aylikTutarToplami.get(ay) + kasa.getGunSonuSatisTutari());
            kasa.setGunSonuSatisTutari(0);
            //aylikToplamMusteri[ay] += kasa.getGunlukMusteri();
            aylikToplamMusteri.set(ay,aylikToplamMusteri.get(ay) + kasa.getGunlukMusteri());
            kasa.setGunlukMusteri(0);
            // urun classindaki stok kontrolü mainde yapilacak
            // ve mantiken gunSonuSiparis buradaki gunSonu
            for(Urun urun : urunler){
                urun.gunSonuSiparis();
                siparisGideri += urun.getSiparisTutari();
                urun.setSiparisTutari(0);
            }
            aylikToplamGider.set(ay,aylikToplamGider.get(ay) + yevmiye + siparisGideri);
            gun = cal.get(Calendar.DAY_OF_MONTH);
            if(ay != cal.get(Calendar.MONTH)) {
                ay = cal.get(Calendar.MONTH);
            }
            if(yil != cal.get(Calendar.YEAR)) {
                yil = cal.get(Calendar.YEAR);
                for(int i = 0;i < 12; i++){
                    aylikKasaAcigi.set(i,(double)0);
                    aylikToplamGider.set(i,0.0);
                    aylikToplamMusteri.set(i,0);
                    aylikTutarToplami.set(i,0.0);
                }
            }
            try{
                ObjectOutputStream yaz = new ObjectOutputStream( new FileOutputStream("kasaAcigi") );
                yaz.writeObject(aylikKasaAcigi);
                yaz.close();

            }
            catch(IOException e){
                System.out.println("Aylik kasa acigi kasaAcigi isimli dosyaya yazilamadi.");
            }
            try{
                ObjectOutputStream yaz = new ObjectOutputStream( new FileOutputStream("toplamGider") );
                yaz.writeObject(aylikToplamGider);
                yaz.close();
            }
            catch(IOException e){
                System.out.println("Aylik toplam gider toplamGider isimli dosyaya yazilamadi.");
            }
            try{
                ObjectOutputStream yaz = new ObjectOutputStream( new  FileOutputStream("toplamMusteri") );
                yaz.writeObject(aylikToplamMusteri);
                yaz.close();
            }
            catch(IOException e) {
                System.out.println("Aylik toplam musteri toplamMusteri isimli dosyaya yazilamadi.");
            }
            try{
                ObjectOutputStream yaz = new ObjectOutputStream( new FileOutputStream("tutarToplami") );
                yaz.writeObject(aylikTutarToplami);
                yaz.close();
            }
            catch(IOException e){
                System.out.println("Aylik tutar toplami tutarToplami isimli dosyaya yazilamadi.");
            }
        }
    }
}
