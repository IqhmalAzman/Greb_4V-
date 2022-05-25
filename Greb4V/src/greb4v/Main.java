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

        Scanner scan = new Scanner(System.in);

        System.out.println("welcome to Greb Application!");
        System.out.println("Options : ");
        
        do{
        System.out.println("(Current time : "); // add time here
        System.out.println("A - View System Dashboard");
        System.out.println("B - enter Customer View");
        System.out.println("C - Add / Remove Driver");

        input = scan.nextLine().toUpperCase();

        // add call class for admin, customer, add/remove
        switch (input) {
            case "A": {
                manageAdmin();
                break;
            }
            case "B": {
                System.out.println("B");
                break;
            }
            case "C": {
                manageDriver();
                break;
            }
            default: {
                break;
            }
        }
        }while(true);

    }

    public static void manageAdmin(){
        System.out.println("System Dashboard : \n");
        
        
        d.display();
        
    }
    
    public static void manageDriver() {

        boolean stop = false;
         
        do {
            System.out.println("Are you trying to add or remove a driver? (Enter \"exit\" to go to home page)");
            System.out.println("A - Add new driver");
            System.out.println("B - Remove driver");

           
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
                case "EXIT" :{
                    stop = true;
                    break;
                }
                default : {
                    stop = true;
                }
            }
            
        } while(stop == false);
        
        
    }

}
