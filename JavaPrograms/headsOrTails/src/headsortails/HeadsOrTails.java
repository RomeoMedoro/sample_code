/*
 * Romeo Medoro.
 * Intro to Java
 * 9/18/2017.
 * Lets the user guess the results of a coin toss.
 */
package headsortails;
import java.util.Scanner;
import java.util.Random;

public class HeadsOrTails {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
       //Variable declarations. 
       int     coinFlip,
               userResponse;
       
        Random rand = new Random();
        coinFlip = rand.nextInt(1);
        
        System.out.print("Enter 1 for Heads, 2 for Tails: ");
        userResponse = input.nextInt();
        System.out.println(coinFlip);
        
        if (userResponse > 1 || userResponse < 0){
            System.out.println("Invalid entry!");
            System.exit(1);
        }
        
        else{
            if (userResponse == coinFlip){
                System.out.println("Great Job the answer was " + coinFlip);
            }
            else{
                System.out.println("Sorry the correct answer was ");
            }
        }
    }
    
}
