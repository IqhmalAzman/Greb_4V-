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
    ArrayList<Integer> driverToCustomerTime = new ArrayList<>();
    
    //until here

    public void setDriverProfile(String name, ArrayList<DriverProfile> driver) {
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
                }
            }
        }
    }

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

//    public void customerToDestination(String name, String currentTime) {
//        Calculation calc = new Calculation();
//
//        double dis = 0.0;
//        
//        for (CustomerProfile customerProfile : customer) {
//            if(findCustomer(name)){
//                dis = calc.distance(customerProfile.getInitialLatitude(), 
//                        customerProfile.getInitialLongitude(), customerProfile.getFiLan(), customerProfile.getFiLong());
//                break;
//            }
//        }
//
////        calc.calculation(dis);
//        System.out.println(calc.calculation2(dis));
//
//        for (CustomerProfile customerProfile : customer) {
//            customerProfile.setEAT(calc.customerDestinationTime(currentTime));
//        }
//    }

    public void display(String time) {
        System.out.println("Requests List (List Last Updated Time : " + lastUpdatedTime + ")");
        System.out.println("(Current time : " + time + " )");

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
    
    public void displayRatingDriver(int cap, String time) {
        System.out.println("Requests List (List Last Updated Time : " + lastUpdatedTime + ")");
        System.out.println("(Current time : " + time + " )");

        System.out.println("=============================================================================================================================");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", "Driver", "Status",
                "Capacity", "Location", "Customer", "Rating");
        
        
        
        
        for (DriverProfile driverProfile : driver) {
            if (cap <= driverProfile.getCapacity()) {
                System.out.printf("%-20s %-20s %-20s %-20s\n", driverProfile.getName(),
                        driverProfile.getCapacity(),0000 , driverProfile.getRating());
            }
        }

        System.out.println("=============================================================================================================================");
    }
}
