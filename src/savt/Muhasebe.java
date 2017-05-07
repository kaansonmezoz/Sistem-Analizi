package savt;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

/**
 * Created by khan on 07.05.2017.
 */

public class Muhasebe {

    // ilgili ayin gozune islem yapilir. yil sonuyla ilgli bir islemimiz yok.
    private double[] aylikTutarToplami;
    private int[] aylikToplamMusteri;
    private double[] aylikKasaAcigi;
    private double[] aylikFireToplami;
    private double[] aylikToplamGider;
    private int ay ;
    private int gun;
    ArrayList<Personel> calisanlar;

    public Muhasebe(){
        calisanlar = new ArrayList<Personel>();
        aylikTutarToplami = new double[12];
        aylikToplamMusteri = new int[12];
        aylikKasaAcigi = new double[12];
        aylikFireToplami = new double[12];
        aylikToplamGider = new double[12];
        for(int i = 0;i < 12;i++){
            aylikTutarToplami[i] = 0;
            aylikToplamMusteri[i] = 0;
            aylikKasaAcigi[i] = 0;
            aylikFireToplami[i] = 0;
            aylikToplamGider[i] = 0;
        }
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        ay = cal.get(Calendar.MONTH);
        gun = cal.get(Calendar.DAY_OF_MONTH);
    }
    // yıl sonu geldigi zaman yapilacak sey belli degil ona da bakmak gerekecek
    // parametre olarak alinan aylarin yanlis olma durumunda bir handle yapilmasi gerek
    // 0..11 e kadar gidiyor ay sayisi indis olarak
    public void setAylikTutarToplami(double toplamTutar,int ay) {
        aylikTutarToplami[ay] = toplamTutar;
    }

    public void setAylikToplamMusteri(int toplamMusteri,int ay) {
        aylikToplamMusteri[ay] = toplamMusteri;
    }

    public void setAylikFireToplami(double toplamFire,int ay) {
        aylikFireToplami[ay] = toplamFire;
    }

    public void setAylikKasaAcigi(double kasaAcigi,int ay) {
        aylikKasaAcigi[ay] = kasaAcigi;
    }

    public void setAylikToplamGider(double toplamGider,int ay){
        aylikToplamGider[ay] = toplamGider;
    }

    public void setAy(int ay){
        this.ay = ay;
    }

    public double getAylikTutarToplami(int ay) {
        return aylikTutarToplami[ay];
    }

    public int getAylikToplamMusteri(int ay) {
        return aylikToplamMusteri[ay];
    }

    public double getAylikKasaAcigi(int ay) {
        return aylikKasaAcigi[ay];
    }

    public double getAylikFireToplami(int ay) {
        return aylikFireToplami[ay];
    }

    public int getAy(){
        return ay;
    }

/*
    public boolean iseAlim(){
        Personel yeniCalisan;
        int secim;
        System.out.print("Ise alinacak personel kasiyer ise 0, reyon gorevlisi ise 1 giriniz");
        secim =

    }

    public boolean istenAtim(){

    }
*/

/*  buna gerek kalmadi nihayetinde ay sonu gelmesi icin once gun sonu gelmesi gerekir.
    ay sonu gelmesinden kasit ise ayin degismesi
    public boolean aySonu(){
        // ay sonu gelmesinin kontrolu yapilir

    }
*/
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
            aylikTutarToplami[ay] += kasa.getGunSonuSatisTutari();
            kasa.setGunSonuSatisTutari(0);
            aylikToplamMusteri[ay] += kasa.getGunlukMusteri();
            kasa.setGunlukMusteri(0);
            // urun classindaki stok kontrolü mainde yapilacak
            // ve mantiken gunSonuSiparis buradaki gunSonu
            for(Urun urun : urunler){
                urun.gunSonuSiparis();
                siparisGideri += urun.getSiparisTutari();
                urun.setSiparisTutari(0);
            }
            aylikFireToplami[ay] += ;
            aylikToplamGider[ay] += yevmiye + siparisGideri;
            gun = cal.get(Calendar.DAY_OF_MONTH);
            if (ay != cal.get(Calendar.DAY_OF_MONTH)) {
                ay = cal.get(Calendar.DAY_OF_MONTH);
            }
        }
    }
}
