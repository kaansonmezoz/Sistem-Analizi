package savt;

<<<<<<< HEAD
<<<<<<< HEAD
import java.io.IOException;
<<<<<<< HEAD
=======
import java.io.Serializable;
import java.util.ArrayList;
>>>>>>> c45036d... hashmap yapısı sonere çekildi

=======
>>>>>>> 6bdc319... otomasyon duzenlendi2
=======
import java.io.IOException;

>>>>>>> 3a82351... class step2
/**
 * Created by sonerpyci on 07.05.2017.
 */
public class Urun implements java.io.Serializable{

    private String isim;
    private String barkod;
    private int stok;
    private double fiyat;
    private int altLimit;
    private double siparisTutari;


    public Urun(String barkod, String isim, double fiyat, int altLimit, int stok) {
        this.isim = isim;
        this.barkod = barkod;
        this.fiyat = fiyat;
        this.altLimit = altLimit;
        this.stok = stok;
    }

    public String getIsim() {
        return isim;
    }

    public String getBarkod() {
        return barkod;
    }

    public int getStok() {
        return stok;
    }

    public double getFiyat() {
        return fiyat;
    }

    public int getAltLimit() {
        return altLimit;
    }

    public double getSiparisTutari() {
        return siparisTutari;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public void setBarkod(String barkod) {
        this.barkod = barkod;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    public void setAltLimit(int altLimit) {
        this.altLimit = altLimit;
    }

    public void setSiparisTutari(double siparisTutari) {
        this.siparisTutari = siparisTutari;
    }


    public void stokKontrolu() {

        if (this.getStok() <= this.getAltLimit()) {
            this.setStok(this.getStok() + 100);
<<<<<<< HEAD
            this.setSiparisTutari( this.getSiparisTutari() + this.getFiyat()*100 );

=======
            this.setSiparisTutari(this.getSiparisTutari() + this.getFiyat() * 100);
>>>>>>> 5d4969e... Merge branch 'master' of https://github.com/oykuzeynep/Sistem-Analizi
        }
    }

<<<<<<< HEAD
    public boolean stoktanDus(int adet) {
        //exception eklenebilir girilmesine karsin
        if (this.getStok() < adet) {
            System.out.println("Yeterince urun stokta yok");
            return false;
        }
        else
        {
            this.setStok(this.getStok() - adet);
            return true;
        }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
        this.setStok(this.getStok()-adet);
    }


>>>>>>> 3a82351... class step2
}
=======
        this.setStok(this.getStok() - adet);
=======

>>>>>>> c20291d... Main calisiyor
=======
    public void stoktanDus(int adet) throws IOException
    {
        //exception eklenebilir girilmesine karsin
        if(this.getStok() < adet)
        {
            throw new IOException("Stokta yeterince urun yok");
        }

        this.setStok(this.getStok()-adet);
>>>>>>> 3a82351... class step2
    }


<<<<<<< HEAD
>>>>>>> 5d4969e... Merge branch 'master' of https://github.com/oykuzeynep/Sistem-Analizi
=======
}
>>>>>>> 3a82351... class step2
