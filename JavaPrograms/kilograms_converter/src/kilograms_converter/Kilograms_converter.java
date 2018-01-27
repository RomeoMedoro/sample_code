/*
 * Romeo Medoro.
 * Intro to Java.
 * 9/11/17
 * Converts pounds to kilograms. 
 */
package kilograms_converter;
import java.util.Scanner;

public class Kilograms_converter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Constant Declaration.
        final double POUND_IN_KILOGRAM = 0.454;      // one pound in Kg.
        // Variable Declarations.
        double poundsToConvert,                     // Holds weight in pounds
                convertedKilos;                    // Holds converted weight.
        
        // Ask user for weight in pounds. 
        System.out.print("Enter the weight in pounds:  ");
        poundsToConvert = input.nextDouble();
        
        // Call the function to convert the weight.
        convertedKilos = convertWeightToKilograms(poundsToConvert, POUND_IN_KILOGRAM);
        
        // Display results to user. 
        System.out.println(poundsToConvert + " pounds is " + convertedKilos + " Kilograms.");
    }
    /**Returns the weight converted to kilograms. */
    public static double convertWeightToKilograms(double weight, final double RATE){
        // Hold the weight after conversion. 
        double result;
        
        result = weight * RATE;
        
        return result;
    }
}
