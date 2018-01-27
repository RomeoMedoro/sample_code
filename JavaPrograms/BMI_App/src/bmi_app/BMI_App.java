/*
 * Romeo Medoro.
 * Intro to Java
 * 11/8/2017
 * Creates an account object with an account with a designated ID, balance, 
 * and interest rate. Has the ability to withdraw deposit, and print account
 * information. 
 */
package bmi_app;
import java.util.*;

public class BMI_App {

    public static void main(String[] args) {
        // TODO code application logic here
        BMI bmi1 = new BMI("Kim Yang", 18, 145, 5, 10);
        System.out.println("The BMI for " + bmi1.getName() + " is " + 
                bmi1.getBMI() + " " + bmi1.getStatus());
    }
    
}

class BMI{
    private String name;
    private int age;
    private double weight;
    private double height;
    public static final double KILOGRAMS_PER_POUND = 0.45359237;
    public static final double METERS_PER_INCH = 0.0254;
    
    public BMI(String name, int age, double weight, double height){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }
    
    public BMI(String name, double weight, double height){
        this(name, 20, weight, height);
    }
    
    public BMI(String name, int age, double weight, double feet, double inches){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = (feet * 12) + inches;
    }
    public double getBMI(){
        double bmi = weight * KILOGRAMS_PER_POUND / ((height * METERS_PER_INCH) *
                (height * METERS_PER_INCH));
        return Math.round(bmi * 100) / 100.0;
    }
    public String getStatus(){
        double bmi = getBMI();
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi < 25)
            return "Normal";
        else if (bmi < 30)
            return "Overweight";
        else 
            return "Obese";
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public double getWeight(){
        return weight;
    }
    
    public double getHeight(){
        return height;
    }
}