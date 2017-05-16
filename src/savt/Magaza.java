package savt;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by enes on 07.05.2017.
 */

public class Magaza {

        //Urunler cekilecek (sanallastirilacak) databaseden
        //cekilen urunler arrayList e yazilir

        //Tanimlama try ın disinda yapilmaliymis.
        private HashMap<String, Urun> urunler = null;
        private Muhasebe muhasebe = null;
        private Kasa kasa = null;
        private String id;

        public Magaza(String id)
        {
            //TODO : this.muhasebe = new Muhasebe();
            this.kasa = new Kasa();
            this.id = id;
        }

        public Kasa getKasa() {
            return kasa;
        }

        public HashMap<String, Urun> getUrunler() {
            return urunler;
        }

        public Muhasebe getMuhasebe() {
            return muhasebe;
        }

    public void yeniUrunTablosuOlustur()
        {
            urunler = new HashMap<String, Urun>();
        }

        public void urunEkle()
        {
            Scanner in = new Scanner(System.in);

            System.out.println("Barkod : ");
            String barkod = in.nextLine();
            System.out.println("Isim : ");
            String isim = in.nextLine();
            System.out.println("Fiyat : ");
            int fiyat = in.nextInt();
            System.out.println("Alt Limit : ");
            int altLimit = in.nextInt();
            System.out.println("Stok : ");
            int stok = in.nextInt();

            //in.close();

            Urun urun = new Urun(barkod, isim, fiyat, altLimit, stok);

            urunler.put(barkod, urun);
        }

    public void urunleriOku() throws IOException, ClassNotFoundException
        {
            String dosyaAdi = "urunler.txt";
            ObjectInputStream okuyucu = new ObjectInputStream(new FileInputStream(dosyaAdi));
            //TODO:  SupressWarnings tam olarak ne ise yariyor
            //@SuppressWarnings("unchecked")
            urunler = (HashMap<String, Urun>)okuyucu.readObject();
            okuyucu.close();
        }
        public void urunleriGuncelle() throws IOException//, NullPointerException
        {
            String dosyaAdi = "urunler.txt";
            ObjectOutputStream yazici = new ObjectOutputStream(new FileOutputStream(dosyaAdi));
            //TODO:  SupressWarnings tam olarak ne ise yariyor
            //@SuppressWarnings("unchecked")

            yazici.writeObject(urunler);
            yazici.close();
        }

        public void muhasebeDosyasiOku() throws IOException, ClassNotFoundException
        {
            String dosyaAdi = "muhasebe.txt";
            ObjectInputStream okuyucu = new ObjectInputStream(new FileInputStream(dosyaAdi));
            //TODO:  SupressWarnings tam olarak ne ise yariyor
            //@SuppressWarnings("unchecked")
             muhasebe = (Muhasebe)okuyucu.readObject();
            okuyucu.close();
        }
        public void muhasebeGuncelle() throws IOException
        {
            String dosyaAdi = "muhasebe.txt";
            ObjectOutputStream yazici = new ObjectOutputStream(new FileOutputStream(dosyaAdi));
            //TODO:  SupressWarnings tam olarak ne ise yariyor
            //@SuppressWarnings("unchecked")

            yazici.writeObject(muhasebe);
            yazici.close();
        }
        public void yeniMuhasebeOlustur()
        {
            muhasebe = new Muhasebe();
        }

        public void iade(String barkod) throws IOException
        {
            Urun urun = kasa.barkodAra(urunler, barkod);

            if(urun != null)
            {
                urun.setStok(urun.getStok() + 1);
                kasa.setGunSonuSatisTutari(kasa.getGunSonuSatisTutari() - urun.getFiyat());
                String dosyaAdi = "urunler.txt";
                ObjectOutputStream yazici = new ObjectOutputStream(new FileOutputStream(dosyaAdi));
                //TODO:  SupressWarnings tam olarak ne ise yariyor
                //@SuppressWarnings("unchecked")

                yazici.writeObject(urunler);
                yazici.close();
            }
            else
            {
                System.out.println("Girilen barkoda sahip bir urune sahip degiliz");
            }

        }
    public void fire(String barkod, int adet) throws IOException
    {
        Urun urun = kasa.barkodAra(urunler, barkod);

        if(adet <= urun.getStok())
        {
            if(urun != null)
            {
                urun.setStok(urun.getStok() - adet);
                kasa.setGunSonuSatisTutari(kasa.getGunSonuSatisTutari() - urun.getFiyat());
                String dosyaAdi = "urunler.txt";
                ObjectOutputStream yazici = new ObjectOutputStream(new FileOutputStream(dosyaAdi));
                //TODO:  SupressWarnings tam olarak ne ise yariyor
                //@SuppressWarnings("unchecked")

                yazici.writeObject(urunler);
                yazici.close();
            }
            else
            {
                System.out.println("Girilen barkoda sahip bir urune sahip degiliz");
            }
        }


    }
}
