/*
 * Romeo Medoro.
 * Intro to Java
 * 10/9/2017.
 * prompts user to enter a password and validates input. 
 */
package checkpassword;
import java.util.Scanner;

public class CheckPassword {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your password: ");
    }
    
    public static void validatePassword(String input){
        String regexNum = "[0-9]+",
                regexLet = "[a-zA-Z]+";
        if(input.length() < 8 ){
            System.out.println("Password must be at least 8 characters long. ");
        }
        else if(!(input.matches(regexNum)) && !(input.matches(regexLet))){
            System.out.println("Invalid ");
        }
    }
}
