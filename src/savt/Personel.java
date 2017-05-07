package savt;

/**
 * Created by enes on 07.05.2017.
 */

public abstract class Personel {

    private String ID;
    private int workHour;
    private double maasCarpani;

    public Personel(String ID)
    {
        this.ID = ID;
        this.workHour = workHour;
        this.maasCarpani = maasCarpani;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getWorkHour() {

        return workHour;
    }

    public void setWorkHour(int workHour) {
        this.workHour = workHour;
    }

    public double getMaasCarpani() {

        return maasCarpani;
    }
    public void setMaasCarpani(double maasCarpani) {
        this.maasCarpani = maasCarpani;
    }
}
