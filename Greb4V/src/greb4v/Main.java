package greb4v;

import java.util.Scanner;

public class Main {

    public static Customer c = new Customer();
    public static Driver d = new Driver();
    public static Time t = new Time();

    public static void main(String[] args) {

        // TODO code application logic here
        String input;
        boolean start = true; //this may be temp

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("\nwelcome to Greb Application!");
            System.out.println("Options : ");
            System.out.println("(Current time : " + t.time() + " )"); // add time here
            System.out.println("A - View System Dashboard");
            System.out.println("B - enter Customer View");
            System.out.println("C - Add / Remove Driver");

            System.out.print("\n>> ");

            input = scan.nextLine().toUpperCase();

            // add call class for admin, customer, add/remove
            switch (input) {
                case "A": {
                    manageAdmin();
                    break;
                }
                case "B": {
                    manageCustomer();
                    break;
                }
                case "C": {
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
        System.out.println("(Current time : " + t.time() + " )");

        System.out.println("Requests List (List Last Updated Time : noTime");
        System.out.println("(Current time : " + t.time() + " )");
        c.display();

        System.out.println("\nRequests List (List Last Updated Time : noTime");
        System.out.println("(Current time : " + t.time() + " )");
        d.display();

    }

    public static void manageCustomer() {
        System.out.println("\nYou are in customer view now (Enter \"exit\" to go back to homepage):");
        System.out.println("Options :");
        System.out.println("A - Create customer requests");
        System.out.println("B - Update customer requests");
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

                try{
                    String customerName = scan.next();
                if (!customerName.equalsIgnoreCase("exit")) {
                    int EAT = scan.nextInt();
                    int cap = scan.nextInt();
                    String[] iniLatLan = scan.next().split(",");
                    double iniLat = Double.parseDouble(iniLatLan[0]);
                    double iniLan = Double.parseDouble(iniLatLan[1]);
                    String[] finLatLan = scan.next().split(",");
                    double finLat = Double.parseDouble(finLatLan[0]);
                    double finLan = Double.parseDouble(finLatLan[1]);

                    c.add(new CustomerProfile(customerName, EAT, cap, iniLat, iniLan, finLat, finLan));
                    scan.nextLine();

//                c.add(new CustomerProfile("John", 1730, 5, 2.3, 2.3, 4.3, 4.3));
                    System.out.println("\nThe request is received, please choose your driver...");

                    System.out.println("Requests List (List Last Updated Time : noTime");
                    System.out.println("(Current time : " + t.time() + " )");
                    d.displayRating(cap);

                    System.out.println("\nEnter the driver name you want to select (Enter \"exit\" to go back to homepage):");
                    System.out.print("\n>> ");
                    String driverName = scan.nextLine();

                    d.assignCustomer(driverName, customerName);
                    c.pending(customerName);

                    System.out.println("\n" + driverName + " is on the way to pick you up.");
                }
                } catch(Exception e){
                    System.out.println("Error wrong input");
                }
                break;
            }

            case "B": {
                //update customer requests - for customers who have given details but exit to homepage
                System.out.println("Driver List (List Last Updated Time : NoTIme)");
                System.out.println("(Current time : " + t.time() + " )");
                c.display();

                System.out.println("\nEnter the customer name you want to update (Enter \"exit\" to go back to homepage):");
                System.out.print("\n>> ");
//                updateCust = scan.nextLine(); for later
                System.out.println("");

                System.out.println("Driver List (List Last Updated Time : NoTIme)");
                System.out.println("(Current time : " + t.time() + " )");
                d.display();

                System.out.println("\nEnter the driver name you want to select (Enter \"exit\" to go back to homepage):");
                System.out.print("\n>> ");
                chooseDriver = scan.nextLine();
                System.out.println("\n" + chooseDriver + " is on the way to pick you up.");
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
                    
                    String driverName = scan.next();
                    int cap = scan.nextInt();
                    String[] iniLatLan = scan.next().split(",");
                    double iniLat = Double.parseDouble(iniLatLan[0]);
                    double iniLan = Double.parseDouble(iniLatLan[1]);
                    
                    
                    // this is hard coded need input later
                    d.add(new DriverProfile(driverName, cap, iniLat, iniLan));

                    System.out.println("Driver List (List Last Updated Time : NoTIme)");
                    System.out.println("(Current time : " + t.time() + " )");
                    d.display();
                    break;
                }
                case "B": {
                    scan = new Scanner(System.in);

                    System.out.println("Driver List (List Last Updated Time : NoTIme)");
                    System.out.println("(Current time : " + t.time() + " )");
                    d.display();
                    d.remove(scan.nextLine());

                    System.out.println("Driver List (List Last Updated Time : NoTIme)");
                    System.out.println("(Current time : " + t.time() + " )");
                    d.display();
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

}
