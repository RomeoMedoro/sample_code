/*
 * Romeo Medoro.
 * Intro to Java
 * 10/23/2017.
 * Prompts user to enter a string and sorts the characters. 
 */
package sortcharacters;
import java.util.*;

public class SortCharacters {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String userInput,
                output;
        
        System.out.print("Enter a single String: ");
        userInput = input.next();
        
        output = sort(userInput);
        System.out.println("The sorted string: " + output);
        
    }
    public static String sort(String s){
        char[] string1 = s.toCharArray();
        Arrays.sort(string1);
        String result = "";
        for (int i = 0; i < string1.length; i++){
             result += Character.toString(string1[i]);
        }
        return result;
    }
}
