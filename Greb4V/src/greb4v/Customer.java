/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greb4v;

import java.util.ArrayList;

public class Customer {

    ArrayList<CustomerProfile> customer = new ArrayList<CustomerProfile>();

    public void add(CustomerProfile e) {
        customer.add(e);
    }

    public void pending(String name) {
        if (customer.size() == 0) {
            System.out.println("List is empty");
        } else {
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

    public void remove(String name) {
        if (customer.size() == 0) {
            System.out.println("List is empty");
        } else {
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

    public void display() {
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
