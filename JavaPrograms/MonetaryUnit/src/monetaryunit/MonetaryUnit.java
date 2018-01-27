/*
 * Romeo Medoro.
 * Intro to Java
 * 9/23/2017.
 * Changes a given amount of money into smaller monetary units.
 */
package monetaryunit;
import java.util.Scanner;

public class MonetaryUnit {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Variable Declarations.
        double amount;                  // Holds user input.
        int remainingAmount,            // Holds the remaining amount.
                numberOfOneDollars,     // Holds the number of dollar bills.
                numberOfQuarters,       // Holds the number of quarters. 
                numberOfDimes,          // Holds the number of dimes.
                numberOfNickels,        // Holds the number of nickles
                numberOfPennies;        // Holds the number of pennies. 
        
        // Ask for user input.
        System.out.print("Enter an amount as a decimal, for Example 11.56: ");
        amount = input.nextDouble();
        
        // If the amount is greater than 0.
        if (amount > 0){
            // Print initial statement to user. 
            System.out.println("Your amount $" + amount + " consists of: ");
            
            // calculate remaining amount. 
            remainingAmount = calculateRemainingAmount(amount);
            
            // Call the calculateRemainder method to check for dollars.
            numberOfOneDollars = calculateRemainder(remainingAmount, 100);
            
            // If the number of one dollars is greater than zero
            if (numberOfOneDollars > 0){
                //call the renderResponse Method.
                renderResponse(numberOfOneDollars, " dollar");
                         
                // Recalculate remainingAmount and call the next method. 
                remainingAmount = remainingAmount % 100;
                numberOfQuarters = calculateRemainder(remainingAmount, 25);
            }
            // If number of one dollars is less than zero call the next method.
            else
                numberOfQuarters = calculateRemainder(remainingAmount, 25);
            
            // Check if numberOfQuarters is greater than 0.
            if (numberOfQuarters > 0){
                //If Condition is ture, call the renderResponse Method.
                renderResponse(numberOfQuarters, " quarter");
                
                //Recalculate remainingAmount and call the next method.
                remainingAmount = remainingAmount % 25;
                numberOfDimes = calculateRemainder(remainingAmount, 10);
            }
            // Otherwise call the next method
            else
                numberOfDimes = calculateRemainder(remainingAmount, 10);
            
            // Check in number of dimes is greater than zero.
            if (numberOfDimes > 0 ){
                // If so, call the renderResponse method.
                renderResponse(numberOfDimes, " dime");
                
                //Recalculate remainingAmount and call the next method. 
                remainingAmount = remainingAmount % 10;
                numberOfNickels = calculateRemainder(remainingAmount, 5);
            }
            // Otherwise call the next method.
            else{
                numberOfNickels = calculateRemainder(remainingAmount, 5);
            }
            
            // Check if number of nickles is greater than zero. 
            if (numberOfNickels > 0){
                //If so, call the renderResponse method. 
                renderResponse(numberOfNickels, " nickel");
                
                //Recalculate remainingAmount and display number of pennies
                remainingAmount = remainingAmount % 5;
                pennyResponse(remainingAmount);
            }
        }
        else {
            System.out.println("The amount should be greater than 0!");
            System.exit(1);
        }
        
    }
     
    /**Calculates the remaining amount.**/
    public static int calculateRemainingAmount(double amt){
        // Holds the result. 
        int result;
        
        // Calculates the remeining amount 
        result = (int)(amt * 100);
        
        return result;
    }
    
    /**Calculates the number of dollars.**/
    public static int calculateRemainder(int remainingAmt, int value){
        // Holds the result
        int result;
        
        // Calculate the number of dollars
        result = remainingAmt / value;
        
        return result;       
    }
    
    /** Prints the results **/
    public static void renderResponse(int moneyValue, String currencyType){
        if (moneyValue >1){
                    
            // if the condition is met print the result as plural. 
            System.out.println(moneyValue + currencyType + "s");
        }
        // Otherwise print it as singular
        else{ 
            System.out.println(moneyValue + currencyType);
        }
    }
    
    /** Prints the results for Penny or pennies **/
    public static void pennyResponse(int moneyValue){
        if (moneyValue > 1){
            System.out.println(moneyValue + " pennies");
        }
        else{
            System.out.println(moneyValue + " penny");
        }
    }
}
