/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package greb4v;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Main {

    public static Driver d = new Driver();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String input;
        boolean start = true; //this may be temp

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("\nwelcome to Greb Application!");
            System.out.println("Options : ");
            System.out.println("(Current time : noTime)"); // add time here
            System.out.println("A - View System Dashboard");
            System.out.println("B - enter Customer View");
            System.out.println("C - Add / Remove Driver");
            System.out.println("");

            System.out.print(">> ");

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

        d.display();

    }
    
    public static void manageCustomer() {
        System.out.println("You are in customer view now (Enter \"exit\" to go back to homepage):");
        System.out.println("Options :");
        System.out.println("A - Create customer requests");
        System.out.println("B - Update customer requests");

        String custInput, chooseDriver = "";

        Scanner scan = new Scanner(System.in);
        custInput = scan.nextLine().toUpperCase();

        Customer c = new Customer();

        switch (custInput) {
            case "A": {
                System.out.println("Enter the details of the customer you want to create (name, Expected arrival time, capacity, starting point, destination)");
                System.out.println("(Enter \"exit\" to go back to homepage):");
                System.out.print(">> ");
                c.add(new CustomerProfile("John", 1730, 5, 2.3, 2.3, 4.3, 4.3));
                
                System.out.println("\nThe request is received, please choose tour driver...");
                
                d.display();
              
                System.out.println("\nEnter the driver name you want to select (Enter \"exit\" to go back to homepage):");
                System.out.print(">> ");
                chooseDriver = scan.nextLine();
                System.out.println("\n" + chooseDriver + " is on the way to pick you up.");
            }
            
            case "B": {
                //update customer requests - for customers who have given details but exit to homepage
            }
        }
    }

    public static void manageDriver() {

        boolean stop = false;

        do {
            System.out.println("\nAre you trying to add or remove a driver? (Enter \"exit\" to go to home page)");
            System.out.println("A - Add new driver");
            System.out.println("B - Remove driver");
            System.out.println("");
            System.out.print(">> ");

            String input;

            Scanner scan = new Scanner(System.in);

            input = scan.next().toUpperCase();

            switch (input) {
                case "A": {
                    d.add(new DriverProfile("Driver 1", 5, 22, 33));
                    d.display();
                    break;
                }
                case "B": {
                    scan = new Scanner(System.in);
                    d.display();
                    d.remove(scan.nextLine());
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
