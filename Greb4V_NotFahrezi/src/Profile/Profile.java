package Profile;

public abstract class Profile{
    private String name;
    private int capacity;
    private double initialLatitude, initialLongitude;

    public Profile(String name, int capacity, double initialLatitude, double initialLongitude) {
        this.name = name;
        this.capacity = capacity;
        this.initialLatitude = initialLatitude;
        this.initialLongitude = initialLongitude;
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
