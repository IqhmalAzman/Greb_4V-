/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greb4v;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class HomePage {

    String input;
    
    public HomePage() {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("welcome to Greb Application!");
        System.out.println("Options : ");
        System.out.println("(Current time : " ); // add time here
        System.out.println("A - View System Dashboard");
        System.out.println("B - enter Customer View");
        System.out.println("C - Add / Remove Driver");
        
        input = scan.nextLine().toUpperCase();
        
        // add call class for admin, customer, add/remove
        switch(input){
            case "A" : {
                break;
            }
            case "B" : {
                break;
            }
            case "C" : {
                break;
            }
            default : {
                break;
            }
        }
    }
    
}
