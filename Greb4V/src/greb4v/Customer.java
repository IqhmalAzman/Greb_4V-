/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greb4v;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Customer {
    ArrayList<CustomerProfile> customer = new ArrayList<CustomerProfile>();

    public void add(CustomerProfile e) {
        customer.add(e);
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

    public void display() {
        System.out.println("==============");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", "Customer", "Status", "Expected Arrival Time",
                "Capacity", "Starting Point", "Destination");
        for (CustomerProfile customerProfile : customer) {
            System.out.printf("%-20s %-20s %-20s %-20s %-20s, %-20s\n", customerProfile.getName(), "Status", 
                customerProfile.getEAT(), customerProfile.getCap(), customerProfile.getIniLan() + "," + 
                    customerProfile.getIniLong(), customerProfile.getFiLan() + "," + customerProfile.getFiLong());
        }

        System.out.println("==============");
    }
}
