/*
 * Romeo Medoro.
 * Intro to Java.
 * 9/11/17
 * Calculates energy needed to heat water from an initial temperature. 
 */
package calculate_energy;
import java.util.Scanner;
public class Calculate_energy {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Constant declaration.
        final int ENERGY_RATE = 4184;
        
        // Variable Declarations.
        double waterWeight,                 // Holds the water weight. 
                initialTemperature,         // Holds the initial temperature.
                finalTemperature,           // Holds the final temperature. 
                energyUsed;                 // Holds the energy used. 
        
        // Ask user for water amount.
        System.out.print("Enter the amount of water in Kilograms: ");
        waterWeight = input.nextDouble();
        
        // Ask user for initial temperature.
        System.out.print("Enter the initial temperature in Celsius: ");
        initialTemperature = input.nextDouble();
        
        // Ask user for final temperature. 
        System.out.print("Enter the final temperature in Celsius: ");
        finalTemperature = input.nextDouble();
        
        // Call the calculateEnergy function.
        energyUsed = calculateEnergy(waterWeight, finalTemperature, 
                initialTemperature, ENERGY_RATE);
        
        // Display result to user. 
        System.out.println("The energy needed is: " + energyUsed + " joules");
    }
    
    /**Returns the energy needed to heat water. */
    public static double calculateEnergy(double weight, double finalTemp, 
            double initialTemp, final int RATE){
        // Holds the energy after calculation. 
        double result;
        
        // Calculates the energy. 
        result = weight*(finalTemp - initialTemp)*RATE;
        
        return result;
    }
    
}
