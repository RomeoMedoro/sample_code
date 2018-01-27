/*
 * Romeo Medoro.
 * Intro to Java
 * 11/3/2017.
 * Counts the number of words in President Lincoln's Gettysburg address from
 * https://liveexample.pearsonmg.com/data/Lincoln.txt
 */
package countwords;
import java.util.*;
import java.io.*;
import java.net.*;

public class CountWords {

    public static void main(String[] args) {
        // Local Variable declarations. 
        String urlInput = "https://liveexample.pearsoncmg.com/data/Lincoln.txt";
        
        // Create a url object.
        try{
            URL url = new URL(urlInput);
            int counter = 0;                // Used to count the words. 
            // Scanner input object.
            Scanner reader = new Scanner(url.openStream());
            // Start reading the page.
            while(reader.hasNext()){
                String line = reader.next();
                counter++;
            }
            System.out.println("Lincoln's Gettysburg address contains " +
                    counter + " words!");
        }
        catch(MalformedURLException ex){
            System.out.println("Invalid URL");
        }
        catch(IOException ex){
            System.out.println("I/O Errors: no such file.");
        }
    }
    
}
