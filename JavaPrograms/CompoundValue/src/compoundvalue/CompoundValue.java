/*
 * Romeo Medoro.
 * Intro to Java
 * 10/2/2017.
 * Prompts user to enter an amount, interest rate, and number of months
 * and displays the amount in savings account after the given month. 
 */
package compoundvalue;
import java.util.Scanner;

public class CompoundValue {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double amount,
                interestRate,
                totalSavings = 0,
                savings = 0;
        int numberOfMonths;
        
        System.out.print("Enter the amount (ex- 100.00): ");
        amount = input.nextDouble();
        
        System.out.print("Enter the annual interest rate: ");
        interestRate = input.nextDouble()/12;
        
        System.out.print("Enter the number of months: ");
        numberOfMonths = input.nextInt();
        
        int counter = 1;
        double total = 0;
        
        while(counter < numberOfMonths){
            if(counter == 1){
                total = amount * (1+interestRate);
            }
             
            savings = total + amount;
            totalSavings = savings * (1 + interestRate);
            total = totalSavings;
           
         counter++;   
        }
        
        System.out.println("After " + numberOfMonths + " your savings will be: $" +
                String.format("%.3f", totalSavings));
    }
    
}
