package savt;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.util.*;
import java.io.*;
/**
 * Created by enes on 07.05.2017.
 */
public class Kasa {


    private double gunSonuSatisTutari = 0;
    private int gunlukMusteri = 0;



    public int getGunlukMusteri() {
        return gunlukMusteri;
    }

    public void setGunlukMusteri(int gunlukMusteri) {
        this.gunlukMusteri = gunlukMusteri;
    }

    public void gunlukMusteriArttir()
    {
        gunlukMusteri++;
    }

    public double getGunSonuSatisTutari() {
        return gunSonuSatisTutari;
    }

    public void setGunSonuSatisTutari(double gunSonuSatisTutari) {
        this.gunSonuSatisTutari = gunSonuSatisTutari;
    }

    public void gunSonunaEkle(double satisTutari)
    {
        gunSonuSatisTutari += satisTutari;
    }

    public boolean urunVarMi(HashMap<String, Urun> urunler, String isim)
    {
        for( HashMap.Entry<String, Urun> entry : urunler.entrySet() )
        {
            if(entry.getValue().getIsim().compareTo(isim) == 0)
            {
                System.out.println("Aranan urun mevcut . Stok miktari : "+ entry.getValue().getStok());
                return true;
            }
        }
        //okuyucu.close();
        System.out.println("Aranan urun bulunamadi...\n");
        return false;

    }
    //TODO : IOException da olabilir
    //urun un bulunamadigi dusunulerek  nullPointerException verildi
    public Urun barkodAra(HashMap<String, Urun> urunler, String barkod) throws NullPointerException
    {
        for( HashMap.Entry<String, Urun> entry : urunler.entrySet() )
        {
            if(entry.getValue().getBarkod().compareTo(barkod) == 0)
            {
                return (entry.getValue());
            }
        }
        throw new NullPointerException("Girilen barkoda sahip bir urun bulunamadi...\n");

    }

    public double toplamFiyatHesapla(ArrayList<Urun> alisveris)
    {
        double toplamFiyat = 0;

        for(Urun urun : alisveris)
        {
            toplamFiyat += urun.getFiyat();
        }

        return toplamFiyat;
    }
    public void Satis(HashMap<String, Urun> urunler)
    {
        ArrayList<Urun> alisveris = new ArrayList<Urun>();
        boolean exit = false;

        Scanner in = new Scanner(System.in);
        //todo : burada da tanimlanabilir emin degiliz.
        //Urun urun;

        while(!exit)
        {
            System.out.println(" 1 - Urun gir");
            System.out.println(" 2 - Alisverisi bitir");
            System.out.println(" Seciminizi giriniz : ");
            int selection = in.nextInt();
            in.nextLine();
            switch(selection)
            {
                case 1 : System.out.println("Alinmak istenen urunun barkodunu giriniz : ");
                         String barkod = in.nextLine();
                         System.out.println("Urun sayisini giriniz : ");
                         int adet = in.nextInt();

                         //TODO : Urun urun yukarida da tanimlanabilir.Emin degiliz
                         Urun urun = barkodAra(urunler, barkod);
                         for(int i=0; i<adet; i++)
                         {
                             alisveris.add(urun);
                         }
                         urun.stoktanDus(adet);

                break;
                case 2 : gunSonunaEkle(toplamFiyatHesapla(alisveris));
                         gunlukMusteriArttir();
                         System.out.println("Toplam alisveris tutari : "+ toplamFiyatHesapla(alisveris));
                         System.out.println("Alisverisi bitti...Iyi gunler dileriz \n");
                         exit = true;
                break;
                //TODO : GUI de gerek kalmayacak.Cunku butonlarla secim yapilacak.
                default : System.out.println("Hatali bir secim girdiniz...");
            }
        }
    }
}
