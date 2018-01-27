/*
 * Romeo Medoro.
 * Intro to Java
 * 9/23/2017.
 * A simple rock, paper, scissor game. 
 */
package rockpaperscissor;
import java.util.Scanner;

public class RockPaperScissor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Variable declarations.
        int gameResult,             // Holds the system result for the game.
                userResponse;        // Holds the user response. 
        
        // Invite user to play. 
        System.out.println("Lets play rock, paper, scissor!");
        System.out.println("Your selections are: ");
        System.out.println("(0) Scissor");
        System.out.println("(1) Rock");
        System.out.println("(2) Paper");
        System.out.print("Enter your selection: ");
        
        //Get user input and validate it. 
        userResponse = input.nextInt();
        if (userResponse == (int)userResponse && userResponse <= 2 &&
                userResponse >= 0){
            // Generate random number between 0 and 2.
            gameResult = (int)(Math.random()*3);
            
            // Display the user selection and the random value
            System.out.print("You chose " + returnStringValue(userResponse));
            System.out.println(". The computer chose " + returnStringValue(gameResult)
                                                            + ".");
            
            // Check user pick against random number and display the result to 
            // the user. 
            if (userResponse == 0){
                if (gameResult == 0){
                    System.out.println("It's a draw!");
                }
                else if (gameResult == 1){
                    System.out.println("Rock beats Scissor. You lost!");
                }
                else 
                    System.out.println("Scissor beats paper! You won!");
            }
            else if(userResponse == 1){
                if (gameResult == 0){
                        System.out.println("Rock beats scissor! You Won!");
                    }
                else if (gameResult == 1){
                    System.out.println("It's a draw!");
                }
                else
                    System.out.println("Paper beats Rock. You lost!");
            }
            else{
                if (gameResult == 0){
                    System.out.println("Scissor beats paper. You lost!");
                }
                else if (gameResult == 1){
                    System.out.println("Paper beats rock! You won!");
                }
                else
                    System.out.println("It's a draw!");
            }
        }
        // If the response is not valid, exit the alert the user and exit the
        // program. 
        else{
            System.out.println("Invalid input!");
            System.exit(1);
        }
        
    }
    
    /* Checks the user and game responses and returns their string value */
    public static String returnStringValue(int number){
        // Holds the string value. 
        String result = " ";
        
        if (number == 0){
            result = "scissor";
        }
        else if (number == 1){
            result = "rock";
        }
        else 
            result = "paper";
        
       return result;
    }
    
}
