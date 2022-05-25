/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greb4v;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Admin
 */
public class Test {

    public static void main(String[] args) {
//        Date d1 = new Date();
//        System.out.println("Current date is " + d1);
//        
//        while (true) {
//            try {
//                Thread.sleep(1000);
//
//                System.out.println("hello");
//            } catch (InterruptedException ex) {
//                Thread.currentThread().interrupt();
//            }
//        }
        double[] inCoor = {2.3, 2.3};

        CustomerProfile c1 = new CustomerProfile("Ray", 1450, 5, 2.3, 2.3, 5.5, 5.5);
        CustomerProfile c2 = new CustomerProfile("Ray", 1450, 5, 2.3, 2.3, 5.5, 5.5);
        
        c1.headingDisplay();
        c1.display();
        c2.display();
  
    }
    
    
    
    
}
