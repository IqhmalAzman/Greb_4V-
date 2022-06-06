/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greb4v;

import java.time.LocalTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Admin
 */
public class Test {

    public static void main(String[] args) {

//        Time t = new Time();
//
//        try {
//
//            Thread.sleep(10000);
//
//            System.out.println(t.time());
//
//        } catch (InterruptedException ex) {
//            Thread.currentThread().interrupt();
//        }
//        Distance dist = new Distance();
//        Calculation calc = new Calculation();
//        
//        double dis = dist.distance(3.12, 101.65, 2.9290, 101.7800);
//        System.out.println(dis);

//        calc.Calculation(dis);
//        System.out.println(calc.getHr());
//        System.out.println(calc.getMin());
        
//        int min = calc.getMin() + 60 * calc.getHr();
//        
//        System.out.println(min);
//     
//        String time = "2350";
//        
//        String hh = time.substring(0, time.length() /2);
//        String mm = time.substring(time.length()/2, time.length());
//        System.out.println(hh);
//        System.out.println(mm);
//        
//        min += Integer.parseInt(hh) * 60 + Integer.parseInt(mm);
//        
//        System.out.println(min);
//        
//        hh = "" + min / 60 % 24;
//        mm = "" + min % 60;
//        
//        System.out.println(hh+mm);
//        
        Calculation calc = new Calculation();
//        Time t = new Time();
        
        double dist = calc.distance(3.1209,101.6538, 3.1174,101.6781);
        calc.calculation(dist);

        String time = calc.customerDestinationTime("1300");
        
        System.out.println(time);
        
        //check whether customer has reached destination
        //if yes
        System.out.println("Rate your driver:");
        System.out.print("\n>> ");
        double rating = scan.nextDouble();
        d.rating(driverName, rating); //driverName is inputted earlier when customer chose the driver
    }

}
