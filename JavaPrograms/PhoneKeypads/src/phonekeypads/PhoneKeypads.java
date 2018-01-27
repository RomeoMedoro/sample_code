/*
 * Romeo Medoro.
 * Intro to Java
 * 10/13/2017.
 * Prompts users to enter phone numbers as strings containing numbers and 
 * letters and converts the letters to digits.
 */
package phonekeypads;
import java.util.Scanner;

public class PhoneKeypads {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Loval variables.
        String phoneNumber,
                convertedNumber = "";
        
        // Prompt user for input.
        System.out.print("Enter a number as a string including prefix and area code: ");
        phoneNumber = input.next();
        
        // Remove unnecessary characters from the string.
        phoneNumber = phoneNumber.replaceAll("[-(.)]","");
        
        // Validate the length of the string.
        if (!(phoneNumber.length() == 11)){
            System.out.println("Number must be 11 characters long!");
            System.exit(1);
        }
        
        // Loop through the String.
        for(int i = 0; i < phoneNumber.length(); i++){
            // Get the value at the current index and convert it to a Char.
            char tempChar = phoneNumber.charAt(i);
            // This will hold the number that will then be added to the 
            //output string. 
            int tempNumber;
            
            // if the current character is a letter
            if(Character.isLetter(tempChar)){
                // Convert it to uppercase.
               tempChar = Character.toUpperCase(tempChar);
               // Call the getNumber method and assign the result to tempNumber.
               tempNumber = getNumber(tempChar);
               // Convert the result to string and add it to the output variable.
               convertedNumber += Integer.toString(tempNumber);
            }
            // if the current character is a number
            else{
                // assign the numeric value of the char to tempNumber.
                tempNumber = Character.getNumericValue(tempChar);
                // convert it to a string and add it to the output string. 
                convertedNumber += Integer.toString(tempNumber);
            }
        }
        //Print the results. 
        System.out.println("The phone number is: " + convertedNumber);
    }
      
    /* Uses the international standard letter/number mapping for telephones
    to convert user input letters to their respective numbers. 
    */
    public static int getNumber(char uppercaseLetter){
        int result = 0;
        
        if(Character.toString(uppercaseLetter).matches("^[ABC]*$")){
            result = 2;
        }
        else if (Character.toString(uppercaseLetter).matches("^[DEF]*$")){
            result = 3;
        }
        else if (Character.toString(uppercaseLetter).matches("^[GHI]*$")){
            result = 4;
        }
        else if (Character.toString(uppercaseLetter).matches("^[JKL]*$")){
            result = 5;
        }
        else if (Character.toString(uppercaseLetter).matches("^[MNO]*$")){
            result = 6;
        }
        else if (Character.toString(uppercaseLetter).matches("^[PQRS]*$")){
            result = 7;
        }
        else if (Character.toString(uppercaseLetter).matches("^[TUV]*$")){
            result = 8;
        }
        else if (Character.toString(uppercaseLetter).matches("^[WXYZ]*$")){
            result = 9;
        }
        return result;
       
    }
    
}
