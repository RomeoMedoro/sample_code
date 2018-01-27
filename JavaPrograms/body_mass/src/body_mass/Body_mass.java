/*
 * Romeo Medoro.
 * Intro to Java.
 * 9/11/17
 * Calculates a person's BMI. 
 */
package body_mass;
import java.util.Scanner;

public class Body_mass {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Constant declarations.
        final double POUND_IN_KILOGRAM = 0.45359237;  // Holds 1 pould in Kg. 
        final double INCH_IN_METERS = 0.0254;          // Holds 1 inch in meters. 
        
        // Variable declarations. 
        double weightInPounds,                     // Holds user weight in pounds.
                heightInInches,                    // Hods user weight in inches.
                convertedWeight,                   // Holds converted weight.
                convertedHeight,                   // Holds converted height. 
                bodyMassIndex;                     // Holds BMI. 
        
        // Get user weight. 
        System.out.print(test);
        System.out.print("Enter your weight in pounds: " );
        weightInPounds = input.nextDouble();
        
        // Call the convertWeight method.
        convertedWeight = convertWeight(weightInPounds, POUND_IN_KILOGRAM);
       
        // Get user height.
        System.out.print("Enter your height in inches: ");
        heightInInches = input.nextDouble();
        
        // Call the convertHeight method.
        convertedHeight = convertHeight(heightInInches, INCH_IN_METERS);
        
        // Calculate BMI and diplay results to the user. 
        bodyMassIndex = calculateBodyMass(convertedWeight, convertedHeight);
        System.out.println("Your BMI is " + bodyMassIndex);
        
    }
    
    /**Returns the weight in kilograms. */
    public static double convertWeight(double weight, final double RATE){
        // Holds the converted weight. 
        double result;
        
        // Calculates the weight. 
        result = weight*RATE;
        
        return result;
    }
    
    /** Returns the height in meters. */
    public static double convertHeight(double height, final double RATE){
        // Holds the converted height. 
        double result;
        
        // Calculates the height. 
        result = height*RATE;
        
        return result;
    }
    
    /** Returns the calculated BMI */
    public static double calculateBodyMass(double kilograms, double meters){
        // Holds the converted weight. 
        double result;
        
        // Calculates the weight. 
        result = kilograms/Math.pow(meters, 2);
        
        return result;
    }
}
