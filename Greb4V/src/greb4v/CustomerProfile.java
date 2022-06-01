/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greb4v;

import java.util.Arrays;

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
}
