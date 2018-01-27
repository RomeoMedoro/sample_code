/*
 * Romeo Medoro.
 * Intro to Java
 * 9/30/2017.
 * Prompts user to enter a letter and checks whether the letter is a vowel
 * or consonant.
 */
package vowelorconsonant;
import java.util.Scanner;

public class VowelOrConsonant {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Variable Declarations. 
        char userLetter;            // Holds user letter input.
        String letterType;          // Holds the binary value in string format.
        
        // Prompt user for letter input. 
        System.out.print("Enter a letter A through Z: ");
        userLetter = input.next().charAt(0);
        
        // Validate the input
        if (!(Character.toString(userLetter).matches("^[a-zA-Z]*$"))){
            System.out.println("Input must be a letter A through Z!");
            System.exit(1);
        }
        
        // Convert the letter to uppercase. 
        userLetter = Character.toUpperCase(userLetter);
        
        // Call the consonantOrVowel method.
        letterType = consonantOrVowel(userLetter);
        
        //Display the result.
        System.out.println(Character.toString(userLetter) + " is a " + letterType);
    }
    
    /* Takes in the user input letter and returns whether it is a consonant
    of a vowel. */
    public static String consonantOrVowel(char letter){
        String result;
        
        if (Character.toString(letter).matches("^[AEIOU]*$")){
            result = "vowel";
        }
        else{
            result = "consonant";
        }
        
        return result;
    }
    
}
