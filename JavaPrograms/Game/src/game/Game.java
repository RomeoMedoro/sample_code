/*
 * Romeo Medoro.
 * Intro to Java
 * 9/18/2017.
 * Generates 3 random numbers and asks the user to enter the sum of the numbers.
 */
package game;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Variable declarations. 
        int randomNumber1 = (int)(Math.random() * 10),   //Random Number 1.
             randomNumber2 = (int)(Math.random() * 10),  //Random Number 2. 
             randomNumber3 = (int)(Math.random()* 10),   //Random Number 3.
             total,                                     // Holds user input.
             actualTotal;                               // Holds the actual total. 
        // Prompt user to calculate random numbers.
        System.out.print("Enter the sum of " + randomNumber1 + ", " + randomNumber2 +
                ", " + randomNumber3 + ": 1");
        total = input.nextInt();
        actualTotal = randomNumber1 + randomNumber2 + randomNumber3;
        if (total == actualTotal){
            System.out.println("Great Job!");
        }
        else{
            System.out.println("Sorry, the correct answer is: " + actualTotal);
        }
        
    }
    
}
