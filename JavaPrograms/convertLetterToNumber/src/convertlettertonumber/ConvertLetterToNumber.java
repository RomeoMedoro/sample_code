/*
 * Romeo Medoro.
 * Intro to Java
 * 9/25/2017.
 * Converts user input letter grade to numeric values 0-4. 
 */
package convertlettertonumber;
import java.util.Scanner;

public class ConvertLetterToNumber {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Variable declarations. 
        char letterGrade;             // holds user input
        int numberValue;                // Holds numeric value of grade. 
        
        // Prompt user to input a letter grade. 
        System.out.print("Enter a letter grade: ");
        letterGrade = input.next().charAt(0);
        
        //Convert character to uppercase. 
        letterGrade = Character.toUpperCase(letterGrade);
        
        if (letterGrade < 'A' || letterGrade > 'F' || letterGrade == 'E'){
            System.out.println("Invalid input.");
            System.exit(1);
        }
        else{
            switch(letterGrade){
                case 'A':
                    numberValue= 4;
                    break;
                case 'B':
                    numberValue= 3;
                    break;
                case 'C':
                    numberValue= 2;
                    break;
                case 'D':
                    numberValue= 1;
                    break;
                case 'F':
                    numberValue= 0;
                    break;
                default:
                    numberValue = 0;
            }
        // Print the reuslt.'
            System.out.println("The numeric value for grade " + letterGrade + 
                    " is " + numberValue);
           
        }
        
    }
    
}
