/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greb4v;

/**
 *
 * @author Admin
 */
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
    
    public void headingDisplay(){
        System.out.printf("%s %20s %20s %20s %20s %20s \n", "Customer", "Status", 
                "Expected Arrival Time", "Capacity", "Starting Point", "Destination");
    }

    public void display() {
        System.out.printf("%s %20s %20s %20s %20s,%s %20s,%s \n", this.getName(), status, 
                EAT, this.getCap(), this.getIniLan(), this.getIniLong(), fiLan, fiLong);
    }

}
