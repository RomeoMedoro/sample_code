/*
 * Romeo Medoro.
 * Intro to Java
 * 10/9/2017.
 * Computes the sum of the digits in an integer. 
 */
package digitsinintegers;
import java.util.Scanner;

public class DigitsInIntegers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Variable declarations. 
        long userInput;         // Holds the user input. 
        int result;         // Holds the result. 
        
        System.out.print("Enter a number greater than 10: ");
        userInput = input.nextLong();
        
        if (!(userInput > 10)){
            System.out.println("Invalid Entry");
            System.exit(1);
        }
        else{
            userInput = sumDigits(userInput);
            System.out.println("The sum is " + userInput);
        }
    }
    
    /* This method takes the user input, and adds the digits that make up the 
    input. 
    */
    public static int sumDigits(long number){
        int result = 0;
        String temp = String.format("%d",number);
        char digit;
        int digitToSum;
        
        for (int i = 0; i < temp.length(); i++){
            digit = temp.charAt(i);
            digitToSum = (int)(Character.getNumericValue(digit));
            
            result += digitToSum;
        }
        return result;
    }
    
}
