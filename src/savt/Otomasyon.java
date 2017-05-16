package savt;

import java.io.IOException;
<<<<<<< HEAD
import java.util.Scanner;
/**
 * Created by enes on 16.05.2017.
=======

/**
 * Created by ResulSerkan on 16.05.2017.
>>>>>>> c89a991... otomasyon eklendi
 */
@SuppressWarnings("resource")
public class Otomasyon {
    public static void main(String[] args) {

<<<<<<< HEAD
        Magaza magaza = new Magaza("1201");


        try{
            magaza.urunleriOku();

=======
        Magaza magaza1 = new Magaza();


        try{
            magaza1.urunleriOku();
>>>>>>> c89a991... otomasyon eklendi
        }
        catch( IOException e ) {
            System.out.println("Dosya okuma işlemleri sırasında" +
                    " bir hata oluştu.");
<<<<<<< HEAD
            magaza.yeniUrunTablosuOlustur();
            //e.printStackTrace();
        }
        catch( ClassNotFoundException e ) {
            System.out.println("Okunan kayıtları işlerken " +
                    "bir hata oluştu.");
            e.printStackTrace();
        }

        try
        {
            magaza.muhasebeDosyasiOku();
        }
        catch(IOException e)
        {
            System.out.println("Dosya okuma işlemleri sırasında" +
                    " bir hata oluştu.");
            magaza.yeniMuhasebeOlustur();
        }
=======
            magaza1.yeniUrunTablosuOlustur();
            e.printStackTrace();
        }
>>>>>>> c89a991... otomasyon eklendi
        catch( ClassNotFoundException e ) {
            System.out.println("Okunan kayıtları işlerken " +
                    "bir hata oluştu.");
            e.printStackTrace();
        }

<<<<<<< HEAD
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        String id;
        String barkod;

        while(!exit)
        {
            System.out.println(" 1 - Yeni urun ekle");
            System.out.println(" 2 - Kasa islemleri");
            System.out.println(" 3 - Isten cikar");
            System.out.println(" 4 - Kasiyer işe al");
            System.out.println(" 5 - Reyon gorevlisi ise al");
            System.out.println(" 6 - Gun sonu");
            System.out.println(" 7 - Urun iade");
            System.out.println(" 8 - Fire");
            System.out.println(" 9 - Cikis");
            System.out.println(" Seciminizi giriniz : ");
            int selection = in.nextInt();
            in.nextLine();

            switch(selection)
            {
                case 1 :    magaza.urunEkle();
                            try
                            {
                                magaza.urunleriGuncelle();
                            }
                            catch(IOException e)
                            {
                                System.out.println("Dosya okuma işlemleri sırasında" +
                                        " bir hata oluştu.");
                            }

                            /*catch (NullPointerException e){

                                e.printStackTrace();
                            }*/
                break;
                case 2 :    magaza.getKasa().Satis(magaza.getUrunler());

                            try
                            {
                                magaza.urunleriGuncelle();
                            }
                            catch(IOException e)
                            {
                                System.out.println("Dosya yazma işlemleri sırasında" +
                                        " bir hata oluştu.");
                            }
                break;
                case 3 :    System.out.println("id : ");
                            id = in.nextLine();
                            magaza.getMuhasebe().istenCikar(id);
                break;
                case 4 :    System.out.println("id : ");
                            id = in.nextLine();
                            magaza.getMuhasebe().kasiyerIseAl(id);
                break;
                case 5 :    System.out.println("id : ");
                            id = in.nextLine();
                            magaza.getMuhasebe().reyonGorevlisiIseAl(id);
                break;
                case 6 :    magaza.getMuhasebe().gunSonu(magaza.getUrunler(), magaza.getKasa());
                            try{
                                magaza.muhasebeGuncelle();
                            }
                            catch(IOException e)
                            {
                                System.out.println("Dosya yazma işlemleri sırasında" +
                                        " bir hata oluştu.");
                            }
                break;
                case 7 :    System.out.println("barkod : ");
                            barkod = in.nextLine();


                            try
                            {
                                magaza.iade(barkod);
                            }
                            catch(IOException e)
                            {
                                System.out.println("Dosya yazma işlemleri sırasında" +
                                        " bir hata oluştu.");
                            }
                break;
                case 8 :    System.out.println("barkod : ");
                            barkod = in.nextLine();
                            System.out.println("adet : ");
                            int adet = in.nextInt();

                            try
                            {
                                magaza.fire(barkod, adet);
                            }
                            catch(IOException e)
                            {
                                System.out.println("Dosya yazma işlemleri sırasında" +
                                        " bir hata oluştu.");
                            }
                break;
                case 9 :    System.out.println("Programdan cikis yaptiniz");
                            exit = true;
                break;
                default : System.out.println("Hatali bir secim girdiniz...");
            }
        }
        in.close();
=======
>>>>>>> c89a991... otomasyon eklendi

    }
}
