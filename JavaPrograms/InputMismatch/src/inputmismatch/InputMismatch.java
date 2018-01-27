/*
 * Romeo Medoro.
 * Intro to Java
 * 10/30/2017.
 * Prompts user to input two integers and displays their sum. 
 */
package inputmismatch;
import java.util.*;

public class InputMismatch {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Local Variable declarations. 
        int number1 = 0,
                number2 = 0;
        
        do{
            try{
                System.out.print("Enter two integers separated by a space: ");
                number1 = input.nextInt();
                number2 = input.nextInt();
            }
            catch (InputMismatchException ex){
                System.out.println("Invalid input type!");

            }
            input.nextLine();
        }while (number1 <= 0 || number2 <= 0);
        
        System.out.println("The sum is: " + (number1 + number2));
    }
}
