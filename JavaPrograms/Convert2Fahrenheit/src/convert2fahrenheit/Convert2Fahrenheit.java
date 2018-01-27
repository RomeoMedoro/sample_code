/*
 * Romeo Medoro.
 * Intro to Java.
 * 9/6/17
 * Converts temperature in Celsius to Fahrenheit.
 */
package convert2fahrenheit;
import java.util.Scanner;

public class Convert2Fahrenheit {

    public static void main(String[] args) {
        // Create Scanner object.
        Scanner input = new Scanner(System.in);
        // Variable declarations.
        double celsius = 0,         // Holds user input.
               fahrenheit = 0;      // Holds converted temperature.
        
        // collect user input.
        System.out.print("Enter the temperature in Degrees Celsius:  ");
        celsius = input.nextDouble();
        
        // call convertTemperature function and print results.
        fahrenheit = convertTemperature(celsius);
        System.out.println(celsius + " Celsius is " + (int)fahrenheit + " Fahrenheit.");
        
    }
   
    /**Returns the temperature in Fahrenheit. */
    public static double convertTemperature(double double1){
        // Hold the temperature after conversion.
        double result;
        
        result = (9.0/5) * double1 + 32;
        
        return result;
    }
}
