/*
 * Romeo Medoro.
 * Intro to Java
 * 9/16/2017.
 * Calculates the value of future investments 
 */
package financialcalculator;
import java.util.Scanner;
import java.text.DecimalFormat;

public class FinancialCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Varibale Declarations.
        double investmentAmount,            //Holds the amount invested.
                interestRate,               //Holds the interest Rate. 
                futureValue;                //Holds the final calculation.
        int numberOfYears;                  //Holds the number of years. 
        
        //Ask for user input.
        System.out.print("Enter investment amount: ");
        investmentAmount = input.nextDouble();
        
        System.out.print("Enter annual interest rate in percentage: ");
        interestRate = input.nextDouble();
        interestRate /= 1200;
                
        System.out.print("Enter number of years: ");
        numberOfYears = input.nextInt();
        
        //Call the calculateValue method to calculate the future value.
        futureValue = calculateValue(investmentAmount, interestRate, numberOfYears);
        DecimalFormat df = new DecimalFormat(".##");
        
        //Display the result.
        System.out.println("Future value is $" + df.format(futureValue));
    }
    
    /* This method takes in the user input and calculates the future value
    of the investment. 
    */
    public static double calculateValue(double amount, double rate, int years){
        //Holds the result. 
        double result;
        
        result = amount*(Math.pow((1 + rate),years*12));
        return result;
    }
}
