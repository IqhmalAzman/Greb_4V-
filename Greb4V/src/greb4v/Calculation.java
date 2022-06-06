package greb4v;

public class Calculation {

    private int min;
    private int hr = 0;

    // assuming speed 60km/h
    public void Calculation(double distance) {

        min = (int) (2.5 * (int) Math.ceil(distance)); // 4* as additional time because its straight line
        while (min >= 60) {
            hr++;
            min = min - 60;
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

    public double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

        dist = dist * 1.609344;

        return (dist);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
 /*::  This function converts decimal degrees to radians             :*/
 /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
 /*::  This function converts radians to decimal degrees             :*/
 /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    public String customerDestinationTime(String time) {

        int min = getHr() * 60 + getMin();
        String hh = time.substring(0, time.length() /2);
        String mm = time.substring(time.length()/2, time.length());
//        System.out.println(hh);
//        System.out.println(mm);
        
        min += Integer.parseInt(hh) * 60 + Integer.parseInt(mm);
        
//        System.out.println(min);
        
        hh = "" + min / 60 % 24;
        mm = "" + min % 60;
        
        return hh+mm;
    }

}
