/*
 * Romeo Medoro.
 * Intro to Java
 * 11/3/2017.
 *  Creates an array of 100 integers. Prompts user to enter the index of the 
 *  array and displays the corresponding element value.  
 */
package outofbounds;
import java.util.*;
import java.io.*;

public class OutOfBounds {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Local variables.
        int userIndex,                  // Holds user input index.
                indexValue;             // Holds the value of the index. 
        int[] randomArray = new int[100];  
        boolean valid = false;
        
        // Ask for user input.
        System.out.print("Enter a number: ");
        
        do{
            userIndex = input.nextInt();
        
            // Call the generateArray method to generate our random array
            randomArray = generateArray();
        
            // Call the getIndexValue method to get the index varlue
            indexValue = getIndexValue(userIndex, randomArray);
            
            // Check the return value of the getIndexValue method.
            // if the value is -1 the index was out of bounds; set the flag to
            // false, and prompt the user to input again. 
            if (indexValue == -1){
                System.out.println("Re-enter a number!");
                valid = false;
                
                // Clear the buffer
                input.nextLine();
            }
            else {
                valid = true;
            }
        }while(valid == false);
        
        System.out.println("The value at your index is: " + indexValue);
    }
    
    /* generates an array of random numbers */
    public static int[] generateArray(){
        int[] result = new int[100];
        
        for (int i = 0; i < result.length; i++){
            result[i] = (int)(Math.random()*1000);
        }
        return result;
    }
    
    /* Uses user input as index, and returns the value of that specific index */
    public static int getIndexValue(int num, int[] array){
        int result = 0;
            try{
                result = array[num];
            }
            catch(ArrayIndexOutOfBoundsException ex){
                System.out.println("Out of Bounds.");
                result = -1;
            }
        return result;
    }
}
