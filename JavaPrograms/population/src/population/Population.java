/*
 * Romeo Medoro.
 * Intro to Java
 * 9/15/2017.
 * Prints the total population after amount of years requested by user. 
 */
package population;
import java.util.Scanner;

public class Population {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Constant Declarations
        final int CURRENT_POPULATION = 312032486;       
        final double BIRTH_RATES = 7.0,
                DEATH_RATES = 13.0,
                IMMIGRATION_RATE = 45.0;
        
        // Application Variables.
        double secondsPerDay = 60*60*24,            //Seconds Per day formula.
               newPopulation,                       //holds the new population
               secondsPerYear;                      //Holds the seconds per year.
        int numberOfYears,                          //Holds user input.
            totalDays;                              //Total days in x years.
        
        //Ask user for number of years. 
        System.out.print("Enter the number of years: ");
        numberOfYears = input.nextInt();
        
        //Call numberOfDays function to convert years to days. 
        totalDays = numberOfDays(numberOfYears);
        secondsPerYear = secondsPerDay * totalDays;
        
        //Calculate the new population.
        newPopulation = ((secondsPerYear/BIRTH_RATES)+(secondsPerYear/IMMIGRATION_RATE)-
                (secondsPerYear/DEATH_RATES))+CURRENT_POPULATION;
        
        //Display resuls to the user. 
        System.out.print("Population after " + numberOfYears + " year(s): ");
        System.out.println((int)newPopulation);      
    }
    
     /**Returns the years in days. */
    public static int numberOfDays(int years){
        // Holds the result. 
        int result;
        
        // Calculates the number of days. 
        result = years*365;
        
        return result;
    }
    
}
