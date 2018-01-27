/*
 * Romeo Medoro.
 * Intro to Java
 * 11/3/2017.
 * Create a .txt file, populates the file with 100 randomly generated integers 
 * separated by spaces. Reads the data from the file and displays it in 
 * increasing order. 
 */
package writeandreaddata;
import java.util.*;
import java.io.*;

public class WriteAndReadData {

    public static void main(String[] args)throws Exception {
        Scanner input = new Scanner(System.in);
        // Array declaration/definition.
        int[] numberList = generateArray();
        int[] outputList = new int[100];
        
         // create a file
         File file = new File("Exercise12_15.txt");
        
        // Check to see if the file exists
        if (file.exists()){
            System.out.print("File already exixts.");
            System.exit(1);
        }
        
        // Create the file. 
        try(PrintWriter output = new PrintWriter(file);){
            // Write the array into the file.
            for (int i = 0; i < numberList.length; i++){
                output.print(numberList[i] + " ");
            }
            // Close the output stream. 
            output.close();
            // Notify the user the file was created successfully. 
            System.out.println("The file has been created.\n");
            System.out.println("The contents of the file are: ");
            System.out.println("---------------------------------------------");
            
        }
        
        // create a scanner to read the file.
        Scanner reader = new Scanner(file);
        
        // Read the file. 
        while(reader.hasNext()){
            // Converting each item to an integer, 
            // and adding each item read to an array.
            for (int i = 0; i < outputList.length; i++){
                outputList[i] = Integer.parseInt(reader.next());
            }
        }
        //clost the output stream. 
        reader.close();
        
        // Sort the output array.
        Arrays.sort(outputList);
        
        // Print the results.
        for (int i = 0; i < outputList.length; i++){
            // starting a new line every 10 characters. 
            if (i % 10 == 0){
                System.out.print("\n");
            }
            System.out.print(outputList[i] + " ");
        }
        
    }
    
    /* generates an array of random numbers */
    public static int[] generateArray(){
        int[] result = new int[100];
        
        for (int i = 0; i < result.length; i++){
            result[i] = (int)(Math.random()*1000);
        }
        return result;
    }
    
}
