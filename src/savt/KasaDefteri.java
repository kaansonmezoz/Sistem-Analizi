package savt;

import java.io.IOException;

/**
 * Created by enes on 07.05.2017.
 */
public class KasaDefteri {

    public void Satis(Urun urun, int adet) throws IOException
    {
        urun.stoktanDus(adet);
    }

}
