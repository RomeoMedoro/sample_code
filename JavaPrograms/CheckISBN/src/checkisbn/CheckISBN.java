/*
 * Romeo Medoro.
 * Intro to Java
 * 10/6/2017.
 * Prompts user to enter the first 12 digits of an ISBN-13 and retrns the last 
 * digit.
 */
package checkisbn;
import java.util.Scanner;

public class CheckISBN {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Variable declarations.
        String userInput = "",           // Holds the user input.
                regex = "[0-9]+";        // Used for input validation.
        int subTotal = 0,                // Used to calculate the digits in ISBN
                total;                   // Holds the final digit.
        boolean valid = false;           // Used for input validation. 
        
        // Prompt user to enter ISBN.
        System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
        // make sure the input is no more than 12 charcters, blank, 
        //or contains letters. If these contidions aren't met, display an 
        // error and ask for input again.
        do{  
            userInput = input.next();
            if(userInput == "" || !(userInput.length() == 12)){
                System.out.println("Input must be 12 digits long. \n");
                System.out.print("Re-enter the first 12 digits of an ISBN-13: ");
            }
            else if (!(userInput.matches(regex))){
                System.out.println("Input must contain only numbers.");
                System.out.print("Re-enter the first 12 digits of an ISBN-13: ");
            }
            else{
                valid = true;
            }
        }while(valid == false);
        
        // Loop through each character of the string to perform the calculation.
        for(int i = 0; i < userInput.length(); i++){
            char tempNumber;                // used to get the character in the string.
            int temp = 0;                   // Holds the number value of the char.
            
            // Get the character based on the index. 
            tempNumber = userInput.charAt(i);
            // Get the numeric value of the char and cast it as integer.
            temp = (int)(Character.getNumericValue(tempNumber));
            
            // If the current index + 1 is an even number, multiply temp by 3.
            if ((i+1)%2 == 0){
                temp = temp * 3;
            }
            
            // Add temp to the subTotal.
            subTotal += temp;
        }
        
        // Conduct the calculation.
        total = 10 - (subTotal % 10);
       
        // Check if the result is equal to 10, if so replace it with 0
        if (total == 10){
            total = 0;
        }
        
        // Display the result to the user.
        System.out.println("The ISBN-13 number is " + userInput + total);
    }
}
