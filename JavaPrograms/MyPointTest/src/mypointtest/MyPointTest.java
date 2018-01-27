/*
 * Romeo Medoro.
 * Intro to Java
 * 11/8/2017
 * Creates an account object with an account with a designated ID, balance, 
 * and interest rate. Has the ability to withdraw deposit, and print account
 * information. 
 */
package mypointtest;
import java.util.*;

public class MyPointTest {

    public static void main(String[] args) {
        MyPoint point1 = new MyPoint(0,0);
        MyPoint point2 = new MyPoint(10, 30.5);
        
        System.out.println(" The distance is " +
                String.format("%.4f", MyPoint.distance(point1, point2)));
        
        System.out.println(" The distance is " +
                String.format("%.4f", point1.distance(1.1, 2.2)));
        
        System.out.println(" The distance is " +
                String.format("%.4f", point2.distance(point1)));
    }
    
}

class MyPoint{
    private double x,
            y;
    
    MyPoint(){
        x = 0;
        y = 0;
    }
    
    MyPoint(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    double getX(){
        return x;
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    double getY(){
        return y;
    }
    
    public void getY(double y){
        this.y = y;
    }
    
    public double distance(double x, double y){
        return Math.sqrt(
            Math.pow((x - this.x),2) +
            Math.pow((y - this.y), 2));
    }
    
    public double distance(MyPoint z) {
        return z.distance(this.x, this.y);
    }
    
    public static double distance(MyPoint t, MyPoint z) {
         double result;
        result = Math.sqrt(Math.pow((z.x - t.x),2) + Math.pow((z.y - t.y),2));
        return result;
    }
    
}