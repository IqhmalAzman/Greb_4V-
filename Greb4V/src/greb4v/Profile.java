package greb4v;

public class Profile{
    private String name;
    private int capacity;
    private double initialLatitude, initialLongitude;

    public Profile(String name, int cap, double iniLan, double iniLong) {
        this.name = name;
        this.capacity = cap;
        this.initialLatitude = iniLan;
        this.initialLongitude = iniLong;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }


    public double getInitialLatitude() {
        return initialLatitude;
    }

 
    public double getInitialLongitude() {
        return initialLongitude;
    }
    
    public void setInitialLatitude(double initialLatitude) {
        this.initialLatitude = initialLatitude;
    }

    public void setInitialLongitude(double initialLongitude) {
        this.initialLongitude = initialLongitude;
    }
}
