/*
 * Romeo Medoro.
 * Intro to Java
 * 10/2/2017.
 * Prompts user to enter the number of students and their scores, and displays
 * the hightest score
 */
package highestscore;
import java.util.Scanner;

public class HighestScore {
    
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
       // variable declarations. 
       String name;
       int score, 
               numberOfStudents;
       
       System.out.print("How many students do you want to input? ");
       numberOfStudents = input.nextInt();
       
       int loop = 0;
       int highestScore = 0;
       String student= "";
       
       while(loop < numberOfStudents){
           System.out.print("Enter the sudent's name and score separated by a space: ");
           name = input.next();
           score = input.nextInt();
           
           if(score > highestScore){
               highestScore = score;
               student = name;
           }
           
        loop++;   
       }
       
       System.out.println(student + " had the highest score of: " + highestScore);
    }
    
}
