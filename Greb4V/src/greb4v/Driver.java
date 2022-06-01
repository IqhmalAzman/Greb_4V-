/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greb4v;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Driver {

    ArrayList<DriverProfile> driver = new ArrayList<DriverProfile>();

    public void add(DriverProfile e) {
        driver.add(e);
    }

    public void remove(String name) {
        if (driver.size() == 0) {
            System.out.println("List is empty");
        } else {
            for (DriverProfile driverProfile : driver) {
                int i = 0;
                if (driverProfile.getName().equalsIgnoreCase(name)) {
                    driver.remove(i);
                    break;
                }
                i++;
            }
        }
    }

    public void display() {
//        System.out.println("Driver List (List Last Updated Time : NoTIme)");
//        System.out.println("(Current time : NoTime)");
        System.out.println("=========================================================================================================");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Driver", "Status",
                "Capacity", "Location", "Customer");
        for (DriverProfile driverProfile : driver) {
            System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", driverProfile.getName(), "Status",
                    driverProfile.getCap(), driverProfile.getIniLan() + "," + driverProfile.getIniLong(), "customer");
        }

        System.out.println("=========================================================================================================");
    }
}
