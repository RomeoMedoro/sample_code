/*
 * Romeo Medoro.
 * Intro to Java
 * 10/27/2017.
 * Prompts users to enter the number of students, students names, and scored, 
 * and prints names in decreasing order of their scores.
 */
package sortstudents;
import java.util.*;

public class SortStudents {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Local variable declarations. 
        int numberOfStudents = 0;           // Holds the number of students.
        boolean valid = false;              // used for data validation.
        
        while(!(valid)){
            // Prompt user to enter the number of students. 
            System.out.print("Enter the number of students: ");
            
            numberOfStudents = input.nextInt();
            
            //validate the input.
            if(numberOfStudents <= 0){
                System.out.println("Number of students must be greater than 0! \n");
            }
            else 
                valid = true;
        }
        
        // Initialize the multidimentional array.
        String[][] studentList = new String[numberOfStudents][2];
        
        // Variable used for sorting.
        int temp = 0;
        
        for(int row = 0; row < studentList.length; row++){
            System.out.print("Enter the student's name and score: ");
            for (int col = 0; col < studentList[row].length; col++){
                studentList[row][col] = input.next();
            }
        }
        
        // Create a comparator to sort the array.
        Arrays.sort(studentList, Comparator.comparing((String[] entry) -> 
                Integer.parseInt(entry[1])).reversed());
        
        // Print the results.
        for (int row = 0; row < studentList.length; row++){
            for(int col= 0; col < studentList[row].length; col++){
                System.out.print(studentList[row][col] + " ");
            }
            // Start a new line after each name
            System.out.print("\n");
        }
    }
}
