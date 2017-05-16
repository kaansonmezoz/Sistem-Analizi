package savt;

import java.io.IOException;

/**
 * Created by ResulSerkan on 16.05.2017.
 */
@SuppressWarnings("resource")
public class Otomasyon {
    public static void main(String[] args) {

        Magaza magaza1 = new Magaza();


        try{
            magaza1.urunleriOku();
        }
        catch( IOException e ) {
            System.out.println("Dosya okuma işlemleri sırasında" +
                    " bir hata oluştu.");
            magaza1.yeniUrunTablosuOlustur();
            e.printStackTrace();
        }
        catch( ClassNotFoundException e ) {
            System.out.println("Okunan kayıtları işlerken " +
                    "bir hata oluştu.");
            e.printStackTrace();
        }


    }
}
