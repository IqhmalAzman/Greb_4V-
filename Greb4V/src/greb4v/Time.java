package greb4v;

import java.util.Date;

public class Time {
    long startTime;
    long stopTime;

    public Time() {
        Date d = new Date();
        
        startTime = d.getTime();
    }

    public String time() {
        Date d = new Date();
        
        stopTime = d.getTime();

        return calcTime(startTime, stopTime);
    }

    public String calcTime(long t1, long t2) {
        
        int time = (int) (t2 - t1);
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
