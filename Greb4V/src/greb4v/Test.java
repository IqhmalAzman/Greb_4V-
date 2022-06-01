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
        try {
            long a = getTime();
            System.out.println("Time: " + a);

            Thread.sleep(20000);

            long b = getTime();
            System.out.println("Time: " + b);
            System.out.println("Total time: " + calcTime(a, b));

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static long getTime() {
        Date d1 = new Date();
        return d1.getTime();
    }

    public static String calcTime(long t1, long t2) {
        int time = (int) (t2 - t1);
//        int time = 309000;
        int timeInSec = (time / 1000);

        int mm = (timeInSec / 60);
        int ss = (timeInSec - (mm * 60));

        String displayMM = String.valueOf(mm % 24);
        String displaySS = String.valueOf(ss);

        if (mm % 24 < 10) {
            displayMM = "0" + displayMM;
        }

        if (ss < 10) {
            displaySS = "0" + displaySS;
        }

        return displayMM + displaySS;
    }

}
