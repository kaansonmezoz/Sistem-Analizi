package savt;

<<<<<<< HEAD
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
=======
import java.util.ArrayList;
import java.util.HashMap;
>>>>>>> dd726d8... HashMap yapisi main de tanimlandi

/**
 * Created by enes on 07.05.2017.
 */
<<<<<<< HEAD
<<<<<<< HEAD
@SuppressWarnings("resource")
public class Magaza {
=======
public class Magaza implements java.io.Serializable{
>>>>>>> c45036d... hashmap yapısı sonere çekildi
    public static void main(String[] args) {
        private static final long serialVersionUID = 1L;
        //Urunler cekilecek (sanallastirilaca   k) databaseden
=======

public class Magaza {

        //Urunler cekilecek (sanallastirilacak) databaseden
>>>>>>> c89a991... otomasyon eklendi
        //cekilen urunler arrayList e yazilir

<<<<<<< HEAD
<<<<<<< HEAD
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
        else
        {
            System.out.println(adet + " urun yok. Fire girisi basarisiz oldu");
        }


=======
=======
        HashMap urunler = new HashMap();

        //TODO : urun ekleme sorgusu
        //TODO : eklenen urunler arrayList e eklensin
>>>>>>> dd726d8... HashMap yapisi main de tanimlandi
        Urun urun1 = new Urun("141414e1", "cokonat1", 50, 5);
        Urun urun2 = new Urun("141414e2", "cokonat2", 51, 6);
        Urun urun3 = new Urun("141414e3", "cokonat3", 52, 7);
        Urun urun4 = new Urun("141414e4", "cokonat4", 53, 8);
        Urun urun5 = new Urun("141414e5", "cokonat5", 54, 9);

        urunler.put(urun1.getBarkod(), urun1);
        urunler.put(urun2.getBarkod(), urun2);
        urunler.put(urun3.getBarkod(), urun3);
        urunler.put(urun4.getBarkod(), urun4);
        urunler.put(urun5.getBarkod(), urun5);


        /*
        ArrayList<Urun> urunler = new ArrayList<Urun>();

        urunler.add(urun1);
        urunler.add(urun2);
        urunler.add(urun3);
        urunler.add(urun4);
        urunler.add(urun5);
<<<<<<< HEAD
>>>>>>> 8101031... class step4
=======
        */
>>>>>>> dd726d8... HashMap yapisi main de tanimlandi
    }
}
