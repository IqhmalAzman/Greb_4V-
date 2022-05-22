/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greb4v;

/**
 *
 * @author Admin
 */
public class CustomerProfile {
    String customer, status;
    int EAT, capacity;
    double[] coorStart, coorEnd = new double[2];

    public CustomerProfile(String cutomer, String status, int EAT, int capacity,
            double[] coorStart, double[] coorEnd) {
        
        this.customer = customer;
        this.status = status;
        this.EAT =EAT;
        this.capacity = capacity;
        this.coorStart = coorStart;
        this.coorEnd = coorEnd;

    }

    @Override
    public String toString() {
        return "CustomerProfile{" + "customer=" + customer + ", status=" + status + ", EAT=" + EAT + ", capacity=" + capacity + ", coorStart=" + coorStart + ", coorEnd=" + coorEnd + '}';
    }
    
    

}
