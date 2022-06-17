package Utils;

public class Calculation {
    
    //this function converts decimal degrees to radians             
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    //this function converts radians to decimal degrees             
    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    //this method is to calculate the distance between two places using their coordinates
    public double distance(double sourceLatitude, double sourceLongitude, double destinationLatitude, double destinationLongitude) {
        double theta = sourceLongitude - destinationLongitude;
        double dist = Math.sin(deg2rad(sourceLatitude)) * Math.sin(deg2rad(destinationLatitude)) + Math.cos(deg2rad(sourceLatitude)) * Math.cos(deg2rad(destinationLatitude)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515 * 1.609344;

        return (dist);
    }

    //this is a method to calculate the time taken to travel from one place to another
    public int getTimeTaken(double distance) {
        return (int) Math.ceil(2.5 * distance); //2.5 as additional time multiplier because its straight line
    }

    //this is for the current time + EAT
    public String currentTimeEAT(int time, String currentTime) {
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
