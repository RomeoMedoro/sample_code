/*
 * Romeo Medoro.
 * Intro to Java
 * 10/30/2017.
 *  
 */
package readtextfile;
import java.util.*;
import java.io.*;

public class ReadTextFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        
        System.out.print("Enter the file path: ");
        String fileName = input.nextLine();
        do{
            try{
                java.io.File file = new java.io.File(fileName);
                Scanner reader = new Scanner(file);
                while(reader.hasNext()){
                    String firstName = input.next();
                    String mi = input.next();
                    String lastName = input.next();
                    int score = input.nextByte();
                    System.out.println(firstName + " " + mi + " " + lastName + " " +
                            score);
                }
                input.close();
                valid = true;
            }
            catch(FileNotFoundException ex){
                System.out.println("No File Found.");
            }
        }while (valid = false);
        
    }
    
}
