package savt;

import java.io.*;
import java.util.HashMap;

/**
 * Created by enes on 07.05.2017.
 */
<<<<<<< HEAD
@SuppressWarnings("resource")
public class Magaza {
=======
public class Magaza implements java.io.Serializable{
>>>>>>> c45036d... hashmap yapısı sonere çekildi
    public static void main(String[] args) {
        private static final long serialVersionUID = 1L;
        //Urunler cekilecek (sanallastirilaca   k) databaseden
        //cekilen urunler arrayList e yazilir

        //Tanimlama try ın disinda yapilmaliymis.
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



        //TODO : urun ekleme sorgusu
        //TODO : eklenen urunler arrayList e eklensin
        Urun urun1 = new Urun("141414e1", "cokonat1", 50, 5, 3);
        Urun urun2 = new Urun("141414e2", "cokonat2", 51, 6, 2);
        Urun urun3 = new Urun("141414e3", "cokonat3", 52, 7, 4);
        Urun urun4 = new Urun("141414e4", "cokonat4", 53, 8, 5);
        Urun urun5 = new Urun("141414e5", "cokonat5", 54, 9, 6);

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
        */
    }
}
