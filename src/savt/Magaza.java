package savt;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

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

        //Tanimlama try ın disinda yapilmaliymis.
        private HashMap<String, Urun> urunler = null;
        private Muhasebe muhasebe = null;
        private Kasa kasa = null;
        private String id;

        public Magaza(String id)
        {
            this.muhasebe = new Muhasebe();
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

}
