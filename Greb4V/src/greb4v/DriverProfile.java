/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greb4v;

/**
 *
 * @author Admin
 */
public class DriverProfile extends Profile{
    
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
        this.rating = this.rating/ratingCount;
        this.rating = round(this.rating, 1);
    }
    
    private static double round (double value, int precision) {
    int scale = (int) Math.pow(10, precision);
    return (double) Math.round(value * scale) / scale;
}
    
}
