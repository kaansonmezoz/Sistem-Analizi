package savt;

import java.io.IOException;
import java.util.*;
/**
 * Created by enes on 07.05.2017.
 */
public class Kasa {

    ArrayList<Urun> alisveris = new ArrayList<Urun>();
    private double gunSonuSatisTutari = 0;
    private int gunlukMusteri = 0;
    //TODO : IOException da olabilir
    //urun un bulunamadigi dusunulerek  nullPointerException verildi


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

    //TODO : urunAra

    public Urun barkodAra(ArrayList<Urun> urunler, String barkod) throws NullPointerException
    {
        for(Urun urun : urunler)
        {
            if((urun.getBarkod()).compareTo(barkod) == 0)
            {
                return urun;
            }
        }
        throw new NullPointerException("Girilen barkoda sahip bir urun bulunamadi...\n");

    }

    public double toplamFiyatHesapla()
    {
        double toplamFiyat = 0;

        for(Urun urun : alisveris)
        {
            toplamFiyat += urun.getFiyat();
        }

        return toplamFiyat;
    }
    public void Satis(ArrayList<Urun> urunler) throws IOException
    {

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
                case 2 : gunSonunaEkle(toplamFiyatHesapla());
                         gunlukMusteriArttir();
                         System.out.println("Toplam alisveris tutari : "+ toplamFiyatHesapla());
                         System.out.println("Alisverisi bitti...Iyi gunler dileriz \n");
                         exit = true;
                break;
                //TODO : GUI de gerek kalmayacak.Cunku butonlarla secim yapilacak.
                default : System.out.println("Hatali bir secim girdiniz...");
            }
        }
    }
}
