package savt;
import java.util.ArrayList;

/**
 * Created by khan on 07.05.2017.
 */

public class Muhasebe {

    private Date
    private int aylikTutarToplami = 0;
    private int aylikToplamMusteri = 0;
    private double aySonuKasaAcigi = 0;
    private double aylikFireToplami = 0;
    ArrayList<Personel> calisanlar = 0;


    public Muhasebe(){
        calisanlar = new ArrayList<Personel>();
    }

    public void setAylikTutarToplami(int aylikTutarToplami) {
        this.aylikTutarToplami += aylikTutarToplami;
    }

    public void setAylikToplamMusteri(int aylikToplamMusteri) {
        this.aylikToplamMusteri += aylikToplamMusteri;
    }

    public void setAylikFireToplami(double aylikFireToplami) {
        this.aylikFireToplami = aylikFireToplami;
    }

    public void setAySonuKasaAcigi(double aySonuKasaAcigi) {
        this.aySonuKasaAcigi = aySonuKasaAcigi;
    }

    public int getAylikTutarToplami() {
        return aylikTutarToplami;
    }

    public int getAylikToplamMusteri() {
        return aylikToplamMusteri;
    }

    public double getAySonuKasaAcigi() {
        return aySonuKasaAcigi;
    }

    public double getAylikFireToplami() {
        return aylikFireToplami;
    }

    // seviyeye gore calisan rolu belirlenir
    // 0 -> kasiyer , 1->reyon calisani
    public boolean iseAlim(){
        Personel yeniCalisan;

    }

    public boolean istenAtim(){

    }


}