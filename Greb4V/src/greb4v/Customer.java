/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greb4v;

import java.util.ArrayList;

public class Customer {
    ArrayList<CustomerProfile> customer = new ArrayList<CustomerProfile>();
    String lastUpdatedTime;
    
    //experimentation
    ArrayList<DriverProfile> driver; 
    ArrayList<String> allPossibleEAT;
    
    //until here

    public void setDriverProfile(String name, ArrayList<DriverProfile> driver, String currentTime) {
        if (customer.size() == 0) {
            System.out.println("List is empty");
        } else {
            this.lastUpdatedTime = lastUpdatedTime;

            for (CustomerProfile customerProfile : customer) {
                if (findCustomer(name)) {
                    this.driver = driver;
                    customerProfile.setDriver(driver);
                    customerProfile.customerToDestination();
                    customerProfile.driverToCustomer();
                    this.allPossibleEAT = customerProfile.setAllPossibleEAT(currentTime);
                }
            }
        }
    }

    public void add(CustomerProfile e, String lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;

        customer.add(e);
    }

    public void status(String name, String lastUpdatedTime, String status) {
        if (customer.size() == 0) {
            System.out.println("List is empty");
        } else {
            this.lastUpdatedTime = lastUpdatedTime;

            for (CustomerProfile customerProfile : customer) {
                int i = 0;
                if (customerProfile.getName().equalsIgnoreCase(name)) {
                    customerProfile.setStatus(status);
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

    public boolean findCustomer(String name) {
        for (CustomerProfile customerProfile : customer) {
            if (name.equalsIgnoreCase(customerProfile.getName())) {
                return true;
            }
        }
        return false;
    }

    public double finLat(String name) {
        for (CustomerProfile customerProfile : customer) {
            if (findCustomer(name)) {
                return customerProfile.getFiLan();
            }
        }
        return 0.0;
    }

    public double finLong(String name) {
        for (CustomerProfile customerProfile : customer) {
            if (findCustomer(name)) {
                return customerProfile.getFiLong();
            }
        }
        return 0.0;
    }

    public int getCap(String name) {
        for (CustomerProfile customerProfile : customer) {
            if (findCustomer(name)) {
                return customerProfile.getCapacity();
            }
        }
        return -1;
    }
    
    public void asssignDriverTImeToEAT(String customerName, String driverName){
        for (CustomerProfile customerProfile : customer) {
            if (findCustomer(customerName)) {
                for(int i = 0; i < driver.size(); i++){
                    if((driver.get(i).getName()).equalsIgnoreCase(driverName)){
                        customerProfile.setChosenEAT(allPossibleEAT.get(i));
                    }
                    break;
                }
            }
        }

 
    }

    public void display(String time) {
        System.out.println("Requests List (List Last Updated Time : " + lastUpdatedTime + ")");
        System.out.println("(Current time : " + time + " )");

        System.out.println("==================================================================================================================================");
        System.out.printf("%-20s %-20s %-25s %-20s %-20s %-20s\n", "Customer", "Status", "Expected Arrival Time",
                "Capacity", "Starting Point", "Destination");
        for (CustomerProfile customerProfile : customer) {
            System.out.printf("%-20s %-20s %-25s %-20s %-20s %-20s\n", customerProfile.getName(), customerProfile.getStatus(),
                    customerProfile.getChosenEAT(), customerProfile.getCapacity(), customerProfile.getInitialLatitude() + ","
                    + customerProfile.getInitialLongitude(), customerProfile.getFiLan() + "," + customerProfile.getFiLong());
        }

        System.out.println("==================================================================================================================================");
    }
    
    public void displayRatingDriver(int cap, String time) {
        System.out.println("Requests List (List Last Updated Time : " + lastUpdatedTime + ")");
        System.out.println("(Current time : " + time + " )");

        System.out.println("=============================================================================================================================");
        System.out.printf("%-20s %-20s %-20s %-20s\n", "Driver", "Capacity",
                "EAT", "Reputation");
        
        for (int i = 0; i < driver.size(); i++) {
            if(cap <= driver.get(i).getCapacity() && driver.get(i).getStatus().equalsIgnoreCase("Available")){
                System.out.printf("%-20s %-20s %-20s %-20s\n",driver.get(i).getName(), driver.get(i).getCapacity(),
                        allPossibleEAT.get(i), driver.get(i).getRating());
            }
        }

        System.out.println("=============================================================================================================================");
    }
}
