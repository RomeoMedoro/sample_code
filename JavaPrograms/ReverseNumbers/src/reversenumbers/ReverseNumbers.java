/*
 * Romeo Medoro.
 * Intro to Java
 * 10/23/2017.
 * Reads in 10 integers and displays them in reverse order. 
 */
package reversenumbers;
import java.util.*;

public class ReverseNumbers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Variable declarations. 
        int [] myArray = new int[10];
        
        // Prompt user for number input.
        System.out.print("Enter 10 numbers: ");
        
        // Loop through the length of the array to collect each number. 
        for(int i = 0; i < myArray.length; i++){
            myArray[i] = input.nextInt();
        }
        
        Arrays.reverse(Arrays.asList(myArray));
        // Sort the array
        System.out.println(Arrays.toString(myArray));
    }
    
}
