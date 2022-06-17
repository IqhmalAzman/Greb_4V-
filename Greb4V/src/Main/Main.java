package Main;

import Utils.Time;
import Profile.DriverProfile;
import Driver.Driver;
import Customer.Customer;
import Profile.CustomerProfile;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Customer c = new Customer();
    public static Driver d = new Driver();
    public static Time t = new Time();
    public static ArrayList<CustomerProfile> customer = c.getCustomerArr();
    public static ArrayList<DriverProfile> driver = d.getDriverArr();

    public static void main(String[] args) {

        // TODO code application logic here
        String input;
        boolean start = true; //this may be temp

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("\nwelcome to Greb Application!");
            System.out.println("Options : ");
            System.out.println("(Current time : " + t.time() + " )"); // add time here
            System.out.println("TO EXIT ENTER ANYTHING OTHER THAN OPTIONS AVAILABLE");
            System.out.println("A - View System Dashboard");
            System.out.println("B - enter Customer View");
            System.out.println("C - Add / Remove Driver");

            System.out.print("\n>> ");

            input = scan.nextLine().toUpperCase();

            // add call class for admin, customer, add/remove
            switch (input) {
                case "A": {
                    checkStatus(t.time());
                    manageAdmin();
                    break;
                }
                case "B": {
                    checkStatus(t.time());
                    manageCustomer();

                    break;
                }
                case "C": {
                    checkStatus(t.time());
                    manageDriver();

                    break;
                }
                default: {
                    start = false;
                    break;
                }
            }
        } while (start);

    }

    public static void manageAdmin() {
        System.out.println("\nSystem Dashboard : \n");

        c.display(t.time());

        d.display(t.time());

    }

    public static void manageCustomer() {
        System.out.println("\nYou are in customer view now (Enter \"exit\" to go back to homepage):");
        System.out.println("Options :");
        System.out.println("A - Create customer requests");
        System.out.println("B - Update customer requests");
        System.out.println("C - Rate Driver");
        System.out.print("\n>> ");

        String custInput, chooseDriver;
//        String updateCust; //for later to update

        Scanner scan = new Scanner(System.in);
        custInput = scan.nextLine().toUpperCase();

        switch (custInput) {
            case "A": {
                System.out.println("Enter the details of the customer you want to create (name, Expected arrival time, capacity, starting point, destination)");
                System.out.println("(Enter \"exit\" to go back to homepage):");
                System.out.print("\n>> ");

                try {
                    String customerName = scan.next();
                    if (!customerName.equalsIgnoreCase("exit")) {
                        // this is the soft code/input

//                        String EAT = scan.next();
//                        int cap = scan.nextInt();
//                        String[] iniLatLan = scan.next().split(",");
//                        double iniLat = Double.parseDouble(iniLatLan[0]);
//                        double iniLan = Double.parseDouble(iniLatLan[1]);
//                        String[] finLatLan = scan.next().split(",");
//                        double finLat = Double.parseDouble(finLatLan[0]);
//                        double finLan = Double.parseDouble(finLatLan[1]);
//                        c.add(new CustomerProfile(customerName, EAT, cap, iniLat, iniLan, finLat, finLan),
//                                t.time());
                        c.add(new CustomerProfile(customerName, "0000", 4, 3.1209, 101.6538, 3.1174, 101.6781),
                                t.time());
                        scan.nextLine();

                        c.setDriverProfile(customerName, d.referDriver(), t.time());

                        System.out.println("\nThe request is received, please choose your driver...");

//                        c.displayRatingDriver(c.getCap(customerName), t.time(), customerName);
                        c.displayRatingDriver(1, t.time(), customerName);
                        System.out.println("\nEnter the driver name you want to select (Enter \"exit\" to go back to homepage):");
                        System.out.print("\n>> ");
                        String driverName = scan.nextLine();

                        if (d.findAvailableDriver(driverName)) {
                            d.assignCustomer(driverName, customerName, t.time());
                            c.status(customerName, t.time(), "Waiting");
                            c.asssignDriverTImeToEAT(customerName, driverName);
                            c.setCustomerChosenDriver(customerName, driverName);

                            System.out.println("\n" + driverName + " is on the way to pick you up.");
                        } else {
                            System.out.println("Driver doesn't exist");
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            }

            case "B": {
                //update customer requests - for customers who have given details but exit to homepage

                c.display(t.time());

                System.out.println("\nEnter the customer name you want to update (Enter \"exit\" to go back to homepage):");
                System.out.print("\n>> ");
                String customerName = scan.nextLine();
                System.out.println("");

                if (c.findCustomer(customerName)) {
                    System.out.println("\nThe request is received, please choose your driver...");

                    c.displayRatingDriver(c.getCap(customerName), t.time(), customerName);

                    System.out.println("\nEnter the driver name you want to select (Enter \"exit\" to go back to homepage):");
                    System.out.print("\n>> ");
                    String driverName = scan.nextLine();

                    if (d.findAvailableDriver(driverName)) {
                        System.out.println(driverName);
                        System.out.println(customerName);
                        d.assignCustomer(driverName, customerName, t.time());
                        c.status(customerName, t.time(), "Waiting");
                        c.asssignDriverTImeToEAT(customerName, driverName);
                        c.setCustomerChosenDriver(customerName, driverName);

                        System.out.println("\n" + driverName + " is on the way to pick you up.");
                    } else {
                        System.out.println("*******************");
                        System.out.println("*ERROR WRONG INPUT*");
                        System.out.println("*******************");
                    }

                } else {
                    System.out.println("*******************");
                    System.out.println("*ERROR WRONG INPUT*");
                    System.out.println("*******************");
                }

                break;
            }

            case "C": {
                ArrayList<CustomerProfile> customer = c.getCustomerArr();
                ArrayList<DriverProfile> driver = d.getDriverArr();

                System.out.println("\nRate Your Driver: ");

                for (CustomerProfile customerProfile : customer) {
                    if (customerProfile.getStatus().equals("Reached")) {
                        System.out.print(customerProfile.getName() + " | " + customerProfile.getChosenDriver() + "\n");

                    }
                }

                System.out.println("\nEnter the customer name (Enter \"exit\" to go back to homepage):");
                System.out.print("\n>> ");

                try {
                    String customerName = scan.nextLine();
                    System.out.println("");
                    rateDriver(customerName);

                } catch (Exception e) {
                    System.out.println("*******************");
                    System.out.println("*ERROR WRONG INPUT*");
                    System.out.println("*******************");
                }

                break;
            }
        }
    }

    public static void manageDriver() {

        boolean stop = false;

        do {
            System.out.println("\nAre you trying to add or remove a driver? (Enter \"exit\" to go to home page)");
            System.out.println("A - Add new driver");
            System.out.println("B - Remove driver");
            System.out.print("\n>> ");

            String input;

            Scanner scan = new Scanner(System.in);

            input = scan.next().toUpperCase();

            switch (input) {
                case "A": {
                    System.out.println("Enter the details of the driver you want to create (name, capacity, "
                            + " location): ");
                    System.out.println("(Enter \"exit\" to go back to homepage):");
                    System.out.print("\n>> ");

                    //this is the hard coded
//                    d.add(new DriverProfile("John", 5, 3.1174, 101.6781), t.time());
//                    d.display(t.time());
                    // this is the soft code/input
                    try {
                        String driverName = scan.next();

                        if (!driverName.equalsIgnoreCase("exit")) {
                            int cap = scan.nextInt();
                            String[] iniLatLan = scan.next().split(",");
                            double iniLat = Double.parseDouble(iniLatLan[0]);
                            double iniLan = Double.parseDouble(iniLatLan[1]);

                            d.add(new DriverProfile(driverName, cap, iniLat, iniLan), t.time());

                            d.display(t.time());
                        }
                    } catch (Exception e) {
                        System.out.println("*******************");
                        System.out.println("*ERROR WRONG INPUT*");
                        System.out.println("*******************");
                    }
                    break;
                }
                case "B": {
                    System.out.println("");
                    scan = new Scanner(System.in);

                    d.display(t.time());

                    System.out.println("\nEnter the driver name you want to delete (Enter \"Exit\" to go back to homepage): ");
                    System.out.print(">> ");

                    try {
                        d.remove(scan.nextLine(), t.time());

                        System.out.println("");
                    } catch (Exception e) {
                        System.out.println("*******************");
                        System.out.println("*ERROR WRONG INPUT*");
                        System.out.println("*******************");
                    }

                    d.display(t.time());
                    break;
                }
                case "EXIT": {
                    stop = true;
                    break;
                }
                default: {
                    stop = true;
                }
            }

        } while (stop == false);

    }

    public static void checkStatus(String time) {
        for (CustomerProfile customerProfile : customer) {
            if (time.compareToIgnoreCase(customerProfile.getChosenEAT()) >= 0) {
                System.out.println("checkStatus");
                customerProfile.setStatus("Reached");

                for (DriverProfile driverProfile : driver) {
                    if (driverProfile.getCustomer().equalsIgnoreCase(customerProfile.getName())) {
                        driverProfile.setStatus("Available");
                        driverProfile.setInitialLatitude(customerProfile.getFiLan());
                        driverProfile.setInitialLongitude(customerProfile.getFiLong());
                        driverProfile.setCustomer("");
                        break;
                    }
                }

            } else if (time.compareToIgnoreCase(customerProfile.getChosenEAT()) < 0) {
                System.out.println("picked up");
                customerProfile.setStatus("Picked up");
            }
        }

    }

    public static void rateDriver(String customerName) {
        Scanner scan = new Scanner(System.in);

        if (c.findCustomer(customerName)) { //loop to find the customer
            for (CustomerProfile customerProfile : customer) {
                if (customerProfile.getName().equals(customerName)) {
                    String driverName = customerProfile.getChosenDriver();

                    for (DriverProfile driverProfile : driver) {
                        if (driverProfile.getName().equals(driverName)) {
                            System.out.println("\nEnter the rating for " + driverName + " (Rate 0 to 5):");
                            System.out.print("\n>> ");

                            try {
                                double rating = scan.nextDouble();
                                driverProfile.setRating(rating);
                            } catch (Exception e) {
                                System.out.println("*******************");
                                System.out.println("*ERROR WRONG INPUT*");
                                System.out.println("*******************");
                            }
                        }
                    }
                    break;
                }
            }

            //loop to find the driver to rate
        } else {
            System.out.println("Cannot find Customer");
        }
    }

}
