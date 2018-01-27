/*
 * Romeo Medoro.
 * Intro to Java
 * 9/18/2017.
 * Collect user input of 3 integers and displays them in increasing order.
 */
package sortintegers;
import java.util.Scanner;
import java.util.Arrays;

public class SortIntegers {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       
       //Variable Declarations.
       int number1,
               number2, 
               number3;
       
       // Prompt user to input numbers. 
       System.out.print("Enter three positive integers separated by a space: ");
       number1 = input.nextInt();
       number2 = input.nextInt();
       number3 = input.nextInt();
       
       if (!(number1 >0 || number2> 0 || number3 > 0)){
           System.out.println("Invalid entry!");
           System.exit(1);
       }
       else{
           int array[] = new int[]{number1, number2, number3};
           Arrays.sort(array);
           System.out.println(Arrays.toString(array));
       }
    }
    
}
