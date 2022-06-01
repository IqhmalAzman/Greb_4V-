/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package greb4v;

/**
 *
 * @author User
 */
public class Calculation {

    private int min;
    private int hr = 0;

    public void Calculation(double distance) {
        int min;
        int hr = 0;

        min = (int) Math.ceil(distance);
        while (min >= 60) {
            hr++;
            min -= 60;
        }
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

     
}
