/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greb4v;

import java.util.ArrayList;

public class Customer {

    ArrayList<CustomerProfile> customer = new ArrayList<CustomerProfile>();
    String lastUpdatedTime;

    public void add(CustomerProfile e, String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
        
        customer.add(e);
    }

    public void pending(String name, String lastUpdatedTime) {
        if (customer.size() == 0) {
            System.out.println("List is empty");
        } else {
            this.lastUpdatedTime = lastUpdatedTime;
            
            for (CustomerProfile customerProfile : customer) {
                int i = 0;
                if (customerProfile.getName().equalsIgnoreCase(name)) {
                    customerProfile.setStatus("Pending");
                    break;
                }
                i++;
            }
        }
    }

    public void remove(String name, String lastUpdatedTime) {
        if (customer.size() == 0) {
            System.out.println("List is empty");
        } else {
            this.lastUpdatedTime = lastUpdatedTime;
            
            for (CustomerProfile customerProfile : customer) {
                int i = 0;
                if (customerProfile.getName().equalsIgnoreCase(name)) {
                    customer.remove(i);
                    break;
                }
                i++;
            }
        }
    }
    
    public boolean findCustomer(String name){
        for (CustomerProfile customerProfile : customer) {
            if(name.equalsIgnoreCase(customerProfile.getName())){
                return true;
            }
        }
        return false;
    }
    
    public double finLat(String name){
        for (CustomerProfile customerProfile : customer) {
            if(findCustomer(name)){
                return customerProfile.getFiLan();
            }
        }
        return 0.0;
    }
    
    public double finLong(String name){
        for (CustomerProfile customerProfile : customer) {
            if(findCustomer(name)){
                return customerProfile.getFiLong();
            }
        }
        return 0.0;
    }
    
    public int getCap(String name){
        for (CustomerProfile customerProfile : customer) {
            if(findCustomer(name)){
                return customerProfile.getCapacity();
            }
        }
        return -1;
    }
    
    public double[] coordinate(String name){
        double[] arr = new double[4];
        
        for (CustomerProfile customerProfile : customer) {
            if(findCustomer(name)){
                arr[0] = customerProfile.getInitialLatitude();
                arr[1] = customerProfile.getInitialLongitude();
                arr[2] = customerProfile.getFiLan();
                arr[3] = customerProfile.getFiLong();
            }
        }
        
        return arr;
    }
    
    public void driverToCustomer(String customerName, String driverName,String driverCoordinate, String currentTime){
    }
    
    public void customerToDestination(String name, String currentTime){
        Calculation calc = new Calculation();
        
        double[] arr = coordinate(name);
        double dis = calc.distance(arr[0],arr[1], arr[2],arr[3]);

        calc.calculation(dis);
        
        for (CustomerProfile customerProfile : customer) {
            customerProfile.setEAT(calc.customerDestinationTime(currentTime));
        }
        
    }

    public void display(String time) {
        System.out.println("Requests List (List Last Updated Time : " + lastUpdatedTime + ")");
        System.out.println("(Current time : " + time  + " )");
        
        System.out.println("==================================================================================================================================");
        System.out.printf("%-20s %-20s %-25s %-20s %-20s %-20s\n", "Customer", "Status", "Expected Arrival Time",
                "Capacity", "Starting Point", "Destination");
        for (CustomerProfile customerProfile : customer) {
            System.out.printf("%-20s %-20s %-25s %-20s %-20s %-20s\n", customerProfile.getName(), customerProfile.getStatus(),
                    customerProfile.getEAT(), customerProfile.getCapacity(), customerProfile.getInitialLatitude() + ","
                    + customerProfile.getInitialLongitude(), customerProfile.getFiLan() + "," + customerProfile.getFiLong());
        }

        System.out.println("==================================================================================================================================");
    }
}
