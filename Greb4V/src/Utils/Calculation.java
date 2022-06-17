package Utils;

public class Calculation {

    private int min;
    

    // assuming speed 60km/h
    public void calculation(double distance) {
        this.min = (int) Math.ceil(2.5 * distance); // 4* as additional time because its straight line
    }
    
    public int calculation2(double distance) {
        return (int) Math.ceil(2.5 * distance); // 4* as additional time because its straight line
    }

    public int getMin() {
        return min;
    }

    public double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515* 1.609344;

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
    
//    public String integerToStringTimeTaken(int time){
//        int totalMin = time;
//        
//        String displayHH;
//        String displayMM;
//
//        int hh = totalMin / 60 % 24;
//        int mm = totalMin % 60;
//
//        displayHH = String.valueOf(hh);
//        displayMM = String.valueOf(mm);
//
//        if (hh < 10) {
//            displayHH = "0" + displayHH;
//        }
//
//        if (mm < 10) {
//            displayMM = "0" + displayMM;
//        }
//
//        return displayHH + displayMM;
//    }
    

    // this is for the current time + EAT
    public String currentTimeEAT(int time, String currentTime) {
//        int totalMin = this.min;
        int totalMin = time;
        
        String displayHH = currentTime.substring(0, 2);
        String displayMM = currentTime.substring(2, 4);

        totalMin += Integer.parseInt(displayHH) * 60 + Integer.parseInt(displayMM);

        int hh = totalMin / 60 % 24;
        int mm = totalMin % 60;

        displayHH = String.valueOf(hh);
        displayMM = String.valueOf(mm);

        if (hh < 10) {
            displayHH = "0" + displayHH;
        }

        if (mm < 10) {
            displayMM = "0" + displayMM;
        }

        return displayHH + displayMM;
    }

}
