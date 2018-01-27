s/*
 * Romeo Medoro.
 * Intro to Java
 * 10/16/2017.
 * Provides different menu options where users can learn and play games based on
 * Harry Houdini. 
 */
package harryhoudini;
import java.util.Scanner;
import java.util.Random;

public class HarryHoudini {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Local variable declarations.
        boolean exit = false;                // Used for the menu.
        char userInput;                      // Used for user input.
        int userNumber = 0;                  // Holds the number input.
        
        // Initiate the menu and prompt user for a selection. 
        while(exit == false){
            System.out.println("Please Select from the following options: ");
            System.out.println("--------------------------------------------");
            System.out.println("(A) Tell me a random fact about Houdini");
            System.out.println("(B) Show me a magic trick");
            System.out.println("(C) Houdini's Birthday and Death");
            System.out.println("(Q) Quit");
            System.out.println("\n");
            System.out.print("Please enter a selection: ");
            
            userInput = input.next().charAt(0);
            // Convert the input to uppercase for easier validation.
            userInput = Character.toUpperCase(userInput);
           
            //Validate the input.
            if(!(Character.toString(userInput).matches("^[ABCQ]*$"))){
                System.out.println("Invalid Entry!");
            }
            else{
                //Find out which character was selected. 
                switch(userInput){
                    case 'A':
                        //Call the randomFact method.
                        randomFact();
                        break;
                    case 'B':
                        boolean flag = true;
                        // Ask for user input.
                        System.out.print("Enter a 3 digit number: ");
                        while(flag = true){
                            userNumber = input.nextInt();
                            //Validate the input. 
                            if(Integer.toString(userNumber).length() > 3){
                                System.out.println("invalid input!");
                                System.out.print("re-enter a 3 digit number: ");
                            }
                            else 
                                flag = false;
                                // Call the magicTrick method
                                 magicTrick(userNumber);
                                 break;
                        }
                             
                    case 'C':
                        // Call the birthdayAndDeath method.
                        birthdayAndDeath();
                        break;
                    case 'Q':
                        System.out.println("Thanks for stopping by! ");
                        exit = true;
                }
            }
        }
        
    }
    /*Generates random facts about Houdini*/
    public static void randomFact(){
        // generate a random number.
        Random rand = new Random();
        int randomNum = rand.nextInt(10) + 1;

        // Possible facts string declarations. 
        String fact1 = "Harry Houdini was born Ehrich Weiss in March 24, 1874\n",
                fact2 = "Houdini named himself after another magician - Robert Houdin\n",
                fact3 = "Houdini first found fame as the King of Handcuffs\n",
                fact4= "His brother, Hardeen, was also a successful magician\n",
                fact5 = "Houdini once staged an escape from inside a sea monster\n",
                fact6 = "He was an aviation pioneer\n",
                fact7 = "Houdini assisted with the American war effort during WWI\n",
                fact8 = "Houdini debunked psychics and the supernatural\n",
                fact9 = "The cause of his death is still a debate\n",
                fact10 = "Houdini seances are still held every Halloween\n";

        // Assign each fact to a number. 
        switch(randomNum){
            case 1:
                System.out.println(fact1);
                break;
            case 2:
                System.out.println(fact2);
                break;
            case 3:
                System.out.println(fact3);
                break;
            case 4:
                System.out.println(fact4);
                break;
            case 5:
                System.out.println(fact5);
                break;
            case 6:
                System.out.println(fact6);
                break;
            case 7:
                System.out.println(fact7);
                break;
            case 8:
                System.out.println(fact8);
                break;
            case 9:
                System.out.println(fact9);
                break;
            case 10:
                System.out.println(fact10);
                break;
        }

    }

    /* performs a magic trick based on the user's input */
    public static void magicTrick(int number){
        int temp = 0,
                temp2;
        System.out.println("You entered: " + number);
        //Add 7 to the number.
        temp = number + 7;
        System.out.println("Add 7 to it: " + temp );
        temp *= 2;
        System.out.println("Multiply it by 2: " + temp);
        temp -= 4;
        System.out.println("Subtract 4 from the result: " + temp);
        temp /= 2;
        System.out.println("Divide by 2: " + temp);
        temp2 = number - temp;
        System.out.println("Subtract it from the original number: " + number + 
                "-" + temp + "= " + Math.abs(temp2));
        System.out.println("The answer is " + Math.abs(temp2));  
    }
/* Determines the day of Houdini's birth and death. */
    public static void birthdayAndDeath(){
        int birthYear = 1874,
                deathYear = 1926,
                birthMonth = 3,
                deathMonth = 10,
                birthDayOfMonth = 24,
                deathDayofMonth = 31;
        double result;

        // Call the zellerAlgorithm method for the birth.
        result = zellerAlgorithm(birthDayOfMonth, birthMonth, birthYear);

        System.out.println("Harry Houdini was born on March 24th, 1874\n");
        //Call the stringValue method to display the results. 
        stringValue((int)(result));

        // Call the zellerAlgorithm method for the death.
        result = zellerAlgorithm(deathDayofMonth, deathMonth, deathYear);

        System.out.println("Harry Houdini died on October 31st, 1926\n");
        // Call the stringValue method to display the results.
        stringValue((int)(result));

    }

    /*Zeller's algorithn*/
    public static double zellerAlgorithm(int dayOfMon, int mon, int year){
        double result;
        // reassign month and year. 
        if (mon == 1){
            mon = 13;
            year = year - 1;
        }
        else if (mon == 2){
            mon = 14;
            year = year - 1;
        }

        // calculate year of century.
        int yearOfCentury = year % 100;

        //calculate year/100.
        int yearDivided = year/100;

        // apply the algorithm.
        result = (dayOfMon + 26*(mon + 1)/10 + yearOfCentury
            + yearOfCentury/4 + yearDivided/4 + 5*yearDivided)%7;

        return result;
    }

     /* Takes the integer result of the calculation and returns a string
    value of the response. 
    */
    public static void stringValue(int number){
        String day = "";

        if (number == 0){
           day = "Saturday";
        }
        else if (number == 1){
            day = "Sunday";
        }
        else if (number == 2){
            day = "Monday";
        }
        else if (number == 3){
            day = "Tuesday";
        }
        else if (number == 4){
            day = "Wednesday";
        }
        else if (number == 3){
            day = "Thursday";
        }
        else {
            day = "Friday";
        }

        System.out.println("Day of the week was " + day );

    }
}
