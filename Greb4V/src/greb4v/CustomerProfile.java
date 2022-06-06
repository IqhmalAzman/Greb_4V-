package greb4v;

public class CustomerProfile extends Profile {

    private double fiLan, fiLong;
    private int EAT;
    private String status;

    public CustomerProfile(String name, int EAT, int cap, double iniLan, double iniLong, double fiLan, double fiLong) {
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

    public int getEAT() {
        return EAT;
    }

    public String getStatus() {
        return status;
    }

    public void setEAT(int EAT) {
        this.EAT = EAT;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
