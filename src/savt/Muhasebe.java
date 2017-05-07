package savt;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

/**
 * Created by khan on 07.05.2017.
 */

public class Muhasebe {

    // ilgili ayin gozune islem yapilir.
    private int aylikTutarToplami[12];
    private int aylikToplamMusteri[12];
    private double aylikKasaAcigi[12];
    private double aylikFireToplami[12];
    private double aylikToplamGider[12];
    private int ay ;
    private int gun;
    ArrayList<Personel> calisanlar;

    public Muhasebe(){
        calisanlar = new ArrayList<Personel>();
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
    public void setAylikTutarToplami(int gunlukTutarToplami,int ay) {
        aylikTutarToplami[ay] += gunlukTutarToplami;
    }

    public void setAylikToplamMusteri(int gunlukToplamMusteri,int ay) {
        aylikToplamMusteri[ay] += gunlukToplamMusteri;
    }

    public void setAylikFireToplami(double gunlukFireToplami,int ay) {
        aylikFireToplami[ay] += gunlukFireToplami;
    }

    public void setAylikKasaAcigi(double gunSonuKasaAcigi,int ay) {
        aylikKasaAcigi[ay] += gunSonuKasaAcigi;
    }

    public void setAylikToplamGider(double gunToplamGider,int ay){
        aylikToplamGider[ay] += gunToplamGider;
    }

    public void setAy(int ay){
        this.ay = ay
    }

    public int getAylikTutarToplami() {
        return aylikTutarToplami;
    }

    public int getAylikToplamMusteri() {
        return aylikToplamMusteri;
    }

    public double getAylikKasaAcigi() {
        return aylikKasaAcigi;
    }

    public double getAylikFireToplami() {
        return aylikFireToplami;
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
    public void gunSonu(){
        // yani yeni gun geldigi zaman eklenecek degerler, ve kontrol edilmeli yeni gun ayni zamanda
        // yeni ay mi getiriyor eger ki yeni ay getiriyorsa ayin indisi de degistirilmeli.
        // gunlukTutarToplami gibi digerlerinin degerlerini alinip oraya yazilacak ilk parametre
        // olarak set...() icin
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if(gun != cal.get(Calendar.DAY_OF_MONTH)) {
            setAylikTutarToplami(, ay);
            setAylikToplamMusteri(, ay);
            setAylikKasaAcigi(, ay);
            setAylikFireToplami(, ay);
            setAylikToplamGider(, ay);
            gun = cal.get(Calendar.DAY_OF_MONTH);
            if (ay != cal.get(Calendar.DAY_OF_MONTH)) {
                ay = cal.get(Calendar.DAY_OF_MONTH);
            }
        }
    }

}
