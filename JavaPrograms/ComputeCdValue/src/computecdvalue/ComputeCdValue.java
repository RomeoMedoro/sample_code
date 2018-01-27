/*
 * Romeo Medoro.
 * Intro to Java
 * 10/6/2017.
 * Prompts user to enter amount, annual percentage yield, and number of 
 * months and calculates CD value.
 */
package computecdvalue;
import java.util.Scanner;

public class ComputeCdValue {
    
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
        // Variable Declarations. 
        double initialDeposit = 0,               // Holds the deposit amount.
               annualPercentage = 0,            // Holds the annual % yield.
                totalSavings;                   // Holds the resulting answer.
        int maturityPeriod = 0;                 // holds the maturity period.
        boolean isValid = false;                // Used for input validation.
       
        // Prompt user for input until input is greater than zero.
        while (isValid == false){
            System.out.print("Enter the initial deposit amount: ");
            initialDeposit = validateDouble(input.nextDouble());

            if (initialDeposit > 0){
                isValid = true;
            }
        }
        
        // Reset isValid to false;
        isValid = false;
        
        // Prompt user for annual percent yield until input is greater than 0.
        while (isValid == false){
            // Prompt user to enter annual percentage yield.
            System.out.print("Enter annual percentage yield: ");
            annualPercentage = validateDouble(input.nextDouble());
           
            if (annualPercentage > 0){
                isValid = true;
            }
        }
        
        // Reset isValid to false;
        isValid = false;
        
        // Prompt user for maturity period until input is valid. 
        while (isValid == false){
            //Prompt user the enter maturity period.
            System.out.print("Enter maturity period (number of months): ");
            maturityPeriod = validateInteger(input.nextInt());
            
            if (maturityPeriod > 0){
                isValid = true;
            }
        }
        
        // Print the table headers.
        System.out.println("Month \t\t CD Value" );
        System.out.println("--------------------------");
        // declare a temp variable used to reassign the currency used in
        // the calculations.
        double tempSavings = initialDeposit;
        // Loop through the inputs to calculate the CD value.
        for (int i = 1; i < maturityPeriod + 1; i++){
            totalSavings = tempSavings + (tempSavings * annualPercentage)/1200;
            
            //Print the results for each iteration.
            System.out.println(i + "\t\t$" + String.format("%.2f",totalSavings));
            // Assign the result of this calculation to the temp variable. 
            tempSavings = totalSavings;
        }
    }
    
    /* This method collect the user input of "double" value, and validates it.
    If the input does not meet the condition an error message is displayed to the
    user. Otherwise the input is returned.
    */
    public static double validateDouble(double input){
        double result = 0;

       if(input <= 0){
            System.out.println("Input must be greater than 0.\n");
        }
        else{
            result = input;
        }

        return result;
    }
    
    /* This method collect the user input of "integer" value, and validates it.
    If the input does not meet the condition an error message is displayed to the
    user. Otherwise the input is returned.
    */
    public static int validateInteger(int input){
        int result = 0;
        
        if(input <=0){
            System.out.println("Input must be greater than 0.\n");
        }
        else{
            result = input;
        }
        
        return result;
    }
}
