package savt;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by sonerpyci on 07.05.2017.
 */
public class Urun implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private String isim;
    private String barkod;
    private int stok;
    private double fiyat;
    private int altLimit;
    private double siparisTutari;


    public Urun(String barkod, String isim, double fiyat, int altLimit) {
        this.isim = isim;
        this.barkod = barkod;
        this.fiyat = fiyat;
        this.altLimit = altLimit;
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
    //TODO : EXCEPTION ATILABİLİR BELKİ
    public boolean stokKontrol(int adet) {
        if(this.getStok() < adet)
            return false;  //throw new IOException("Stokta yeterli urun yok. Stoktaki urun sayisi : " + this.getStok());
        //TODO : DURUMA GORE MESAJ EKLENEBILIR.
        return true;
    }


    public void gunSonuSiparis() {

        if (this.getStok() <= this.getAltLimit()) {
            this.setStok(this.getStok() + 100);
            this.setSiparisTutari(this.getSiparisTutari() + this.getFiyat() * 100);
        }
    }

    public void stoktanDus(int adet) throws IOException {
        //exception eklenebilir girilmesine karsin
        if (this.getStok() < adet) {
            throw new IOException("Stokta yeterince urun yok");
        }

        this.setStok(this.getStok() - adet);
    }

}

