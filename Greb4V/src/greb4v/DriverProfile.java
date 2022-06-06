package greb4v;

public class DriverProfile extends Profile {

    private String status, customer;
    private double rating;
    private int ratingCount;

    public DriverProfile(String name, int cap, double iniLan, double iniLong) {
        super(name, cap, iniLan, iniLong);
        status = "available";
        rating = 5.00;
        ratingCount++;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating += rating;
        this.rating = this.rating / ratingCount;
        this.rating = round(this.rating, 1);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    private static double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

}
