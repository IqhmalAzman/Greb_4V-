package greb4v;

import java.util.ArrayList;

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
        System.out.println("=========================================================================================================");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "Driver", "Status",
                "Capacity", "Location", "Customer");
        for (DriverProfile driverProfile : driver) {
            System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", driverProfile.getName(), "Status",
                    driverProfile.getCapacity(), driverProfile.getInitialLatitude() + "," + driverProfile.getInitialLongitude(), "customer");
        }

        System.out.println("=========================================================================================================");
    }
    
    public void displayRating() {
        System.out.println("=========================================================================================================");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", "Driver", "Status",
                "Capacity", "Location", "Customer", "Rating");
        for (DriverProfile driverProfile : driver) {
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s\n", driverProfile.getName(), "Status",
                    driverProfile.getCapacity(), driverProfile.getInitialLatitude() + "," + driverProfile.getInitialLongitude(), "customer", driverProfile.getRating());
        }

        System.out.println("=========================================================================================================");
    }
}
