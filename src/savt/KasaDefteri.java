package savt;

import java.io.IOException;
import java.util.*;
/**
 * Created by enes on 07.05.2017.
 */
public class KasaDefteri {

    ArrayList<Urun> alisveris = new ArrayList<Urun>();

    //TODO : IOException da olabilir
    //urun un bulunamadigi dusunulerek  nullPointerException verildi
    public Urun barkodAra(ArrayList<Urun> urunler, String barkod) throws NullPointerException
    {
        for(Urun urun : urunler)
        {
            if(urun.getBarkod().compareTo(barkod))
            {
                return urun;
            }

            throw new NullPointerException("Girilen barkoda sahip bir urun bulunamadi...\n");
        }
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
    public void Satis() throws IOException
    {

        boolean exit = false;

        int selection;

        Scanner in = new Scanner(System.in);

        while(!exit)
        {
            System.out.println(" 1 - Urun gir");
            System.out.println(" 2 - Alisverisi bitir");

            switch(selection )
            {
                case 1 : System.out.println("Alinmak istenen urunun barkodunu giriniz : ");
                         String barkod = in.nextLine();
                         System.out.println("Urun sayisini giriniz : ");
                         int adet = in.nextInt();
                         Urun urun = barkodAra(barkod);
                         for(int i=0; i<adet; i++)
                         {
                             alisveris.add(urun);
                         }
                         urun.stoktanDus(adet);
                break;
                case 2 : System.out.println("Toplam alisveris tutari : "+ toplamFiyatHesapla());
                         System.out.println("Alisverisi bitti...Iyi gunler dileriz \n");
                         exit = true;
                break;
                //TODO : GUI de gerek kalmayacak.Cunku butonlarla secim yapilacak.
                default : System.out.println("Hatali bir secim girdiniz...");
            }
        }
    }

    /* urun.stoktanDus(adet);
        System.out.println("Toplam urun tutari");*/
}
