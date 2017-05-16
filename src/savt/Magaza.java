package savt;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import java.io.*;
import java.util.HashMap;
<<<<<<< HEAD
import java.util.Scanner;
=======
import java.util.ArrayList;
=======
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
>>>>>>> 3255bd1... HashMap yapisi main e alindi. Oradan okundu. Kasa icerisindeki fonskiyonlara hashmap verildi
=======
import java.io.*;
>>>>>>> c20291d... Main calisiyor
import java.util.HashMap;
>>>>>>> dd726d8... HashMap yapisi main de tanimlandi

/**
 * Created by enes on 07.05.2017.
 */
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 3255bd1... HashMap yapisi main e alindi. Oradan okundu. Kasa icerisindeki fonskiyonlara hashmap verildi
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
=======
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
=======
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
=======
import java.io.*;
>>>>>>> 6bdc319... otomasyon duzenlendi2
import java.util.HashMap;
import java.util.Scanner;

>>>>>>> 7e400b3... otomasyon duzenlendi
/**
 * Created by enes on 07.05.2017.
 */

public class Magaza {
<<<<<<< HEAD
    /*public static void main(String[] args) {
>>>>>>> c89a991... otomasyon eklendi
=======
>>>>>>> 6bdc319... otomasyon duzenlendi2

        //Urunler cekilecek (sanallastirilacak) databaseden
>>>>>>> c89a991... otomasyon eklendi
=======
public class Magaza implements java.io.Serializable{
    public static void main(String[] args) {
        private static final long serialVersionUID = 1L;
        //Urunler cekilecek (sanallastirilaca   k) databaseden
>>>>>>> c45036d... hashmap yapısı sonere çekildi
        //cekilen urunler arrayList e yazilir

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
        HashMap urunler<String, Urun> = new HashMap<String, Urun>();
>>>>>>> 3d28790... HashMap tanımı degisiklik <String, Integer>
=======
        HashMap<String, Urun> urunler = new HashMap<String, Urun>();
>>>>>>> 3bb5a09... HashMap tanımı degisiklik <String, Integer> 2
=======
        //Tanimlama try ın disinda yapilmaliymis.
<<<<<<< HEAD
        HashMap<String, Urun> urunler = null;

        try{
            String dosyaAdi = "urunler.txt";
            ObjectInputStream okuyucu = new ObjectInputStream(new FileInputStream(dosyaAdi));
            //TODO:  SupressWarnings tam olarak ne ise yariyor
            //@SuppressWarnings("unchecked")
                    urunler = (HashMap<String, Urun>)okuyucu.readObject();
                    okuyucu.close();
        }
        catch( IOException e ) {
            System.out.println("Dosya okuma işlemleri sırasında" +
                    " bir hata oluştu.");
            urunler = new HashMap<String, Urun>();
            e.printStackTrace();
        }
        catch( ClassNotFoundException e ) {
            System.out.println("Okunan kayıtları işlerken " +
                    "bir hata oluştu.");
            e.printStackTrace();
        }
>>>>>>> 3255bd1... HashMap yapisi main e alindi. Oradan okundu. Kasa icerisindeki fonskiyonlara hashmap verildi

    //buraya kadar yazdik

        //TODO : urun ekleme sorgusu
        //TODO : eklenen urunler arrayList e eklensin
<<<<<<< HEAD
>>>>>>> dd726d8... HashMap yapisi main de tanimlandi
        Urun urun1 = new Urun("141414e1", "cokonat1", 50, 5);
        Urun urun2 = new Urun("141414e2", "cokonat2", 51, 6);
        Urun urun3 = new Urun("141414e3", "cokonat3", 52, 7);
        Urun urun4 = new Urun("141414e4", "cokonat4", 53, 8);
        Urun urun5 = new Urun("141414e5", "cokonat5", 54, 9);
=======
        Urun urun1 = new Urun("141414e1", "cokonat1", 50, 5, 3);
        Urun urun2 = new Urun("141414e2", "cokonat2", 51, 6, 2);
        Urun urun3 = new Urun("141414e3", "cokonat3", 52, 7, 4);
        Urun urun4 = new Urun("141414e4", "cokonat4", 53, 8, 5);
        Urun urun5 = new Urun("141414e5", "cokonat5", 54, 9, 6);
>>>>>>> c20291d... Main calisiyor

        urunler.put(urun1.getBarkod(), urun1);
        urunler.put(urun2.getBarkod(), urun2);
        urunler.put(urun3.getBarkod(), urun3);
        urunler.put(urun4.getBarkod(), urun4);
        urunler.put(urun5.getBarkod(), urun5);

        try{
            String dosyaAdi = "urunler.txt";
            ObjectOutputStream yazici = new ObjectOutputStream(new FileOutputStream(dosyaAdi));
            //TODO:  SupressWarnings tam olarak ne ise yariyor
            //@SuppressWarnings("unchecked")

            yazici.writeObject(urunler);
            yazici.close();
        }
        catch( IOException e ) {
            System.out.println("Dosya okuma işlemleri sırasında" +
                    " bir hata oluştu.");
            e.printStackTrace();
        }
        catch (NullPointerException e){

            e.printStackTrace();
        }

        Kasa kasa = new Kasa();


            kasa.Satis(urunler);






        /*
        ArrayList<Urun> urunler = new ArrayList<Urun>();

        urunler.add(urun1);
        urunler.add(urun2);
        urunler.add(urun3);
        urunler.add(urun4);
        urunler.add(urun5);
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 8101031... class step4
=======
        */
>>>>>>> dd726d8... HashMap yapisi main de tanimlandi
    }
=======

    }*/
        //Urunler cekilecek (sanallastirilacak) databaseden
        //cekilen urunler arrayList e yazilir

        //Tanimlama try ın disinda yapilmaliymis.
=======
>>>>>>> 6bdc319... otomasyon duzenlendi2
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

<<<<<<< HEAD
>>>>>>> c89a991... otomasyon eklendi
=======
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


    }
>>>>>>> 7a1b904... fire mire
}
