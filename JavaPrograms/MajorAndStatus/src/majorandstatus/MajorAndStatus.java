/*
 * Romeo Medoro.
 * Intro to Java
 * 9/25/2017.
 * Prompts user to enter two characters and displays the major and status 
 * represented by the characters.
 */
package majorandstatus;
import java.util.Scanner;

public class MajorAndStatus {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Variable Declarations. 
        String userInput,            //Holds the user input. 
             program = "",           // holds the program.
                grade = "";          // Holds the grade.
        char major,                  // holds the major.
                status;              // holds the grade level. 
        
        //Prompt user for input. 
        System.out.print("Enter two characters: ");
        userInput = input.nextLine();
        
        //Covert the first character to uppercase. 
        major = Character.toUpperCase(userInput.charAt(0));
        status = userInput.charAt(1);
        
        if (!(major == 'M') || !(major == 'C') || !(major == 'I')){
            System.out.println("Invalid input.");
            System.exit(1);
        }
        //else if(status < 1 || status > 4){
          //  System.out.println("Invalid input.");
            //System.exit(1);
        //}
        else{
            switch(major){
                case 'M':
                    program = "Mathematics";
                    break;
                case 'C':
                    program = "Computer Science";
                    break;
                case 'I':
                    program = "Information Technology";
                    break;
            }
            switch(status){
                case 1:
                    grade = "Freshman";
                    break;
                case 2:
                    grade = "Sophmore";
                    break;
                case 3:
                    grade = "Junior";
                    break;
                case 4:
                    grade = "Senior";
                    break;
            }
            System.out.println(program + " " + grade);
        }
        
    }
    
}
