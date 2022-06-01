package greb4v;

public class Calculation {

    private int min;
    private int hr = 0;

    // assuming speed 60km/h
    public void Calculation(double distance) {
        int min;
        int hr = 0;

        min = (int) Math.ceil(distance);
        while (min >= 60) {
            hr++;
            min -= 60;
        }
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

     
}
