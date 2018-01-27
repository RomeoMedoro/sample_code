/*
 * Romeo Medoro.
 * Intro to Java
 * 10/13/2017.
 * Prompts users to enter an investment amount, and interest rate, and prints
 * a table that displays the future value for the years 1 to 30.
 */
package futureinvestmentvalue;
import java.util.Scanner;

public class FutureInvestmentValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Local variables
        double investmentAmount = 0,        
                interestRate = 0,
                totalAmount;
        
        // Prompt user for input. 
        System.out.print("Enter the investment amount: ");
  
        //validate input.
        boolean flag = false;
        while(!(flag)){
            investmentAmount = input.nextDouble();
            flag = isValid(investmentAmount);
            if (flag == false){
                System.out.println("Amount must be greater than zero!");
                System.out.print("Re-enter the investment amount: ");
            }
        }
        
        // Reset the flag
        flag = false;
        
        //Prompt user for interest rate.
        System.out.print("Enter the interest rate (ex: 9): ");
        
        // Validate the input
        while(!(flag)){
            interestRate = input.nextDouble();
            flag = isValid(interestRate);
            if (flag == false){
                System.out.println("Interest rate must be greater than zero!");
                System.out.print("Re-renter the interest rate: ");
            }
        }
        interestRate /= 1200;
        
        // Start printing the information. 
        System.out.println("The amount invested: " + investmentAmount);
        System.out.println("Annual interest rate: " + interestRate);
        System.out.println("Years \t\t Future Value");
        System.out.println("--------------------------------");
        
        //Loop through years to fill the table data. 
        for (int years = 1; years <= 30; years++){
            totalAmount = calculateFutureInvestment(investmentAmount, 
                    interestRate, years); 
            System.out.println("  " + years + "\t\t" + "  $" + 
                    String.format("%.2f", totalAmount));
        }
    }
    /*Computes the future investment value at a given interest rate for a specified
    number of years. 
    */
    public static double calculateFutureInvestment(double investmentAmt,
            double interestRate, int years){
        double result;
        
        result = investmentAmt * (Math.pow((1 + interestRate), years*12));
        return result;
    }
    
    /* Validates user input */
    public static boolean isValid(double input){
        
        if (input > 0 ){
            return true;
        }
        else 
            return false;
    }
}
