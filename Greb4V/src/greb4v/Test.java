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

        Time t = new Time();

        try {

            Thread.sleep(10000);

            System.out.println(t.time());

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

    }

}
