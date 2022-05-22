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
        Date d1 = new Date();
        System.out.println("Current date is " + d1);
        
        while (true) {
            try {
                Thread.sleep(1000);

                System.out.println("hello");
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
