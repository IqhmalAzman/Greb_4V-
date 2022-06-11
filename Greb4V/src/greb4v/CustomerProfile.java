package greb4v;

import java.util.ArrayList;

public class CustomerProfile extends Profile {

    Calculation calc = new Calculation();
    private double fiLan, fiLong;
    private String EAT;
    private String status;

    //experimental
    private int driverToCustomerTime;
    private ArrayList<DriverProfile> driver;
    private ArrayList<String> driverName = new ArrayList<>(); //this is for time calc
    private ArrayList<Integer> driverToCustomerTimeTest = new ArrayList<>();

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

    public void setDriver(ArrayList<DriverProfile> driver) {
        this.driver = driver;
    }

    //until here
//    public void customerToDestination(String currentTime) { //to add time curre
//        Calculation calc = new Calculation();
//
//        double dis = calc.distance(getInitialLatitude(),
//                getInitialLongitude(), getFiLan(), getFiLong());
//
////        calc.calculation(dis);
//        System.out.println("cutomreToDestination" + calc.calculation2(dis));
//
//        setEAT(calc.integerToStringEAT(currentTime));
//    }
    
    public void customerToDestination() { //to add time curre
        Calculation calc = new Calculation();

        double dis = calc.distance(getInitialLatitude(),
                getInitialLongitude(), getFiLan(), getFiLong());

//        calc.calculation(dis);
        System.out.println("cutomreToDestination" + calc.calculation2(dis));
    }

    public void driverToCustomer() {
        for (DriverProfile driverProfile : driver) {
//            System.out.println(driverProfile.getName() + ": " + driverProfile.getInitialLatitude() 
//                    + ", " + driverProfile.getInitialLongitude());
//            
            Integer time = calc.calculation2(calc.distance(driverProfile.getInitialLatitude(),
                    driverProfile.getInitialLongitude(), getInitialLatitude(), getInitialLongitude()));
            driverName.add(driverProfile.getName());
            driverToCustomerTimeTest.add(time);
        }

        
        for (int i = 0; i < driverName.size(); i++) {
            System.out.println(driverName.get(i) + " : " + driverToCustomerTimeTest.get(i));
        }
    }
}
