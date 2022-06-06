package greb4v;

import java.util.ArrayList;

public class CustomerProfile extends Profile {

    private double fiLan, fiLong;
    private String EAT;
    private String status;
    private int driverToCustomerTime;
    
    //experimental
    private ArrayList<DriverProfile> driver;
    
    public void setDriver(ArrayList<DriverProfile> driver){
        this.driver = driver;
    }
    
    public void printDriver(){
        for (DriverProfile driverProfile : driver) {
            System.out.println(driverProfile.getInitialLatitude());
            System.out.println(driverProfile.getInitialLongitude());
        }
    }
    
    public double [][] getAllCoor(){
        double[][] coorArr= new double[driver.size()][2];
        
        for (DriverProfile driverProfile : driver) {
            for (double[] ds : coorArr) {
                ds[0] = driverProfile.getInitialLatitude();
                ds[1] = driverProfile.getInitialLongitude();
            }
            
        }
        
        return coorArr;
    }

    public CustomerProfile(String name, String EAT, int cap, double iniLan, double iniLong, double fiLan, double fiLong) {
        super(name, cap, iniLan, iniLong);
        this.fiLan = fiLan;
        this.fiLong = fiLong;
        this.EAT = EAT;
        this.status = "Pending";
    }

    public double getFiLan() {
        return fiLan;
    }

    public double getFiLong() {
        return fiLong;
    }

    public String getEAT() {
        return EAT;
    }

    public String getStatus() {
        return status;
    }

    public void setEAT(String EAT) {
        this.EAT = EAT;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
