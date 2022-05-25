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
    
    public DriverProfile(String name, int cap, double iniLan, double iniLong) {
        super(name, cap, iniLan, iniLong);
        status = "available";
    }
    
}
