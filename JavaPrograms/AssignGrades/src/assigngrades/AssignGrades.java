/*
 * Romeo Medoro.
 * Intro to Java
 * 10/27/2017.
 * Reads student scores, gets the best score, and assigns appropriate grade.
 */
package assigngrades;
import java.util.*;

public class AssignGrades {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Local Variable Declarations.
        int numberOfStudents = 0;           //Holds the number of students.
        boolean valid = false;
        
        do{
            // Prompt user to enter number of students.
            System.out.print("Enter the number of students: ");
            numberOfStudents = input.nextInt();
            
            // Validate the user input
            if(numberOfStudents <= 0){
                System.out.println("Number of students must be greater than 0");
                valid = false;
            }
            else{
                // Set valid to true
                valid = true;
            }
        }while(!(valid));
        
        // Flag for grade input validation
        boolean gradeValid = false;
        
        // Initialize the array.
        int[] gradeList = new int[numberOfStudents];
        
        //Prompt user for grade input
        System.out.print("Enter " + numberOfStudents + " scores: ");

        // Add the grades to the array.
        for (int i = 0; i < gradeList.length; i++){
            gradeList[i] =input.nextInt();        
        }
        
        // Call the show grade method to display the grade.
        showGrade(gradeList);     
    }
    
    /* Reads the student scores, gets the best score and assigns grades
    based on the best score.
    */
    public static void showGrade(int[] array){
        // Temmp variable used for the top score.
        int topScore = 0;
        //Loop through the array to find the top score. 
        for(int i = 0; i < array.length; i++){
            if(topScore < array[i]){
                topScore = array[i];
            }
        }
        // Loop through the array assigning grades this time.
        for (int i = 0; i < array.length; i++){
            if(array[i] >= topScore - 10){
                System.out.println("Student " + i + " score is " + array[i] + " and "
                        + "grade is A");
            }
            else if(array[i] >= topScore - 20 && i < topScore - 10){
                System.out.println("Student " + i + " score is " + array[i] + " and "
                        + "grade is B");
            }
            else if(array[i] >= topScore - 30 && i < topScore - 20){
                System.out.println("Student " + i + " score is " + array[i] + " and "
                        + "grade is C");
            }
            else if(array[i] >= topScore - 40 && i < topScore - 30){
                System.out.println("Student " + i + " score is " + array[i] + " and "
                        + "grade is D");
            }
            else
                System.out.println("Student " + i + " score is " + array[i] + " and "
                        + "grade is F");
        }
    }
    
}
