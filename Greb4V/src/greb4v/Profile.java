/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greb4v;

/**
 *
 * @author Admin
 */
public class Profile{
    private String name;
    private int cap;
    private double iniLan, iniLong;

    public Profile(String name, int cap, double iniLan, double iniLong) {
        this.name = name;
        this.cap = cap;
        this.iniLan = iniLan;
        this.iniLong = iniLong;
    }

    public String getName() {
        return name;
    }

    public int getCap() {
        return cap;
    }


    public double getIniLan() {
        return iniLan;
    }

 
    public double getIniLong() {
        return iniLong;
    }


    @Override
    public String toString() {
        return "Profile{" + "name=" + name + ", cap=" + cap + ", iniLan=" + iniLan + ", iniLong=" + iniLong + '}';
    }
}
