package greb4v;

public class CustomerProfile extends Profile {

    private double fiLan, fiLong;
    private String EAT;
    private String status;
    private int driverToCustomerTime;

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
