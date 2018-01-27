/*
 * Romeo Medoro.
 * Intro to Java
 * 9/16/2017.
 * Calculates the estimated cost of a trip based on user input.
 */
package costofdriving;
import java.util.Scanner;
import java.text.DecimalFormat;

public class CostOfDriving {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat(".##");
        
        // Varibale Declarations.
        double drivingDistance,             //Holds the driving distance.
                milesPerGallon,             //Holds the miles/gallon.
                pricePerGallon,             //Holds fuel cost per gallon.
                costOfTrip;                 //Holds final cost for trip.
        
        // Get user input. 
        System.out.print("Enter the driving distance: ");
        drivingDistance = input.nextDouble();
        
        System.out.print("Enter miles per gallon: ");
        milesPerGallon = input.nextDouble();
        
        System.out.print("Enter price per gallon: ");
        pricePerGallon = input.nextDouble();
        
        // Call the calculateCost Method to calculate the cost.
        costOfTrip = calculateCost(drivingDistance, milesPerGallon, pricePerGallon);
        
        // Display the calculation to the user.
        System.out.println("The cost of driving is $" + df.format(costOfTrip));
    }
    
    /* This method takes in the user input and calculates the total cost for
    the trip. 
    */
    public static double calculateCost(double distance, double gasMilage, double costPerGal){
        //Holds the calculation result
        double result;
        
        result = (distance/gasMilage)*costPerGal;
        
        return result;
    }
    
}
