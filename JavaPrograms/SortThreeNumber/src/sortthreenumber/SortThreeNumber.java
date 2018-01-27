/*
 * Romeo Medoro.
 * Intro to Java
 * 10/13/2017.
 * Prompts user to enter three numbers and displays them in increasing order. 
 */
package sortthreenumber;
import java.util.Scanner;
import java.util.Arrays;

public class SortThreeNumber {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Variable Declarations. 
        double number1 = 0,
                number2 = 0,
                number3 = 0;
        boolean valid = false;
        
        // Prompt user to input his numbers.
        System.out.print("Enter three numbers separated by a space: ");
        // Validate the input.
        while (!(valid)){
            number1 = input.nextDouble();
            number2 = input.nextDouble();
            number3 = input.nextDouble();
            if (number1 <= 0 || number2 <= 0 || number3 <= 0){
                valid = false;
                System.out.println("All numbers must be greater than zero");
                System.out.print("Reenter three numbers separated by a space: ");
            }
            else
                valid = true;
        }
        
        // call the displaySorterNumbers method.
        displaySortedNumbers(number1, number2, number3);
        
    }
    /* Takes user input as parameters and returns the numbers n increasing 
    order.
    */
    public static void displaySortedNumbers(double num1, double num2, double num3){
        double array[] = new double[]{num1, num2, num3};
           Arrays.sort(array);
           System.out.println("Your numbers sorted are: " + Arrays.toString(array));
    }
    
}
