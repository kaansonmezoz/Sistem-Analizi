package savt;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by enes on 07.05.2017.
 */
public class Magaza {
    public static void main(String[] args) {

        //Urunler cekilecek (sanallastirilacak) databaseden
        //cekilen urunler arrayList e yazilir

        HashMap urunler = new HashMap();

        //TODO : urun ekleme sorgusu
        //TODO : eklenen urunler arrayList e eklensin
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
        */
    }
}
