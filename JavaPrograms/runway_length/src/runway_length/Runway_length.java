/*
 * Romeo Medoro.
 * Intro to Java.
 * 9/11/17
 * Calculates the length of a runway give a planes acceleration on takeoff speed. 
 */
package runway_length;
import java.util.Scanner;

public class Runway_length {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Variable declarations.
        double takeOffSpeed,                // Holds the takeoff speed.
                acceleration,               // Holds the acceleration.
                runwayLength;               // Holds the runway length. 
        
        //Prompt user ot enter takeoff speed and acceleration. 
        System.out.print("Enter speed and acceleration separated by a space: ");
        takeOffSpeed = input.nextDouble();
        acceleration = input.nextDouble();
        
        //call the calculateRunwayLength function.
        runwayLength = calculateRunwayLength(takeOffSpeed, acceleration);
        
        // Print the formula results.
        System.out.println(" The minimum runway length for this airplane is " +
        (float)runwayLength);
    }
    
    /**Returns the length of the runway. */
    public static double calculateRunwayLength(double speed, double acceleration){
        // Holds the runway length. 
        double result;
        
        // Calculates the runway length. 
        result = Math.pow(speed, 2)/(2.0*acceleration);
        
        return result;
    }
    
}
