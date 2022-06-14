package greb4v;

import java.util.ArrayList;

public class CustomerProfile extends Profile {

    Calculation calc = new Calculation();
    private double fiLan, fiLong;
    private String chosenEAT;
    private String status;

    //experimental
    private int customerToDestinationTime;
    private ArrayList<DriverProfile> driver;
    private ArrayList<String> driverName = new ArrayList<>(); //this is for time calc && you can just driver.get(i).getName()
    private ArrayList<Integer> driverToCustomerTime = new ArrayList<>();
    private ArrayList<String> allPossibleEAT = new ArrayList<>(); //from driver point of view

    public CustomerProfile(String name, String EAT, int cap, double iniLan, double iniLong, double fiLan, double fiLong) {
        super(name, cap, iniLan, iniLong);
        this.fiLan = fiLan;
        this.fiLong = fiLong;
        this.chosenEAT = EAT;
        this.status = "Pending";
    }

    public double getFiLan() {
        return fiLan;
    }

    public double getFiLong() {
        return fiLong;
    }

    public String getChosenEAT() {
        return chosenEAT;
    }

    public String getStatus() {
        return status;
    }

    public void setChosenEAT(String chosenEAT) {
        this.chosenEAT = chosenEAT;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDriver(ArrayList<DriverProfile> driver) {
        this.driver = driver;
    }

    public void customerToDestination() { //to add time curre
        Calculation calc = new Calculation();

        double dis = calc.distance(getInitialLatitude(),
                getInitialLongitude(), getFiLan(), getFiLong());

        this.customerToDestinationTime = calc.calculation2(dis);
//        System.out.println("Customer to Dest: " + calc.calculation2(dis));
    }

    public void driverToCustomer() {
        for (DriverProfile driverProfile : driver) {
            Integer time = calc.calculation2(calc.distance(driverProfile.getInitialLatitude(),
                    driverProfile.getInitialLongitude(), getInitialLatitude(), getInitialLongitude()));
            driverName.add(driverProfile.getName());
            driverToCustomerTime.add(time);
        }

//        for (int i = 0; i < driverName.size(); i++) {
//            System.out.println("\n All Driver to Customer: ");
//            System.out.println(driverName.get(i) + " : " + driverToCustomerTime.get(i));
//        }
    }

//    public ArrayList<String> setAllPossibleEAT(String currentTime){
//        for (int i = 0; i < driverToCustomerTime.size(); i++) {
//            allPossibleEAT.add(calc.currentTimeEAT((this.customerToDestinationTime +  this.driverToCustomerTime.get(i)), currentTime));
//        }
//        
////        System.out.println("\n All Possible EAT: ");
//        
////        for (String string : allPossibleEAT) {
////            System.out.println(string);
////        }
//        
//        return this.allPossibleEAT;
//    }
    public void setAllPossibleEAT(String currentTime) {
        for (int i = 0; i < driverToCustomerTime.size(); i++) {
            allPossibleEAT.add(calc.currentTimeEAT((this.customerToDestinationTime + this.driverToCustomerTime.get(i)), currentTime));
        }
    }

    public String getDriverEATBasedOnName(String driverName) {
        for (int i = 0; i < driver.size(); i++) {
            if (driver.get(i).getName().equals(driverName)) {
                return allPossibleEAT.get(i);
            }
        }
        return "error";
    }

    public String getDriverEATBasedOnIndex(int index) {
        System.out.println(allPossibleEAT.size());
        
        return allPossibleEAT.get(index);
    }

}
