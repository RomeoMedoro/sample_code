/*
 * Romeo Medoro.
 * Intro to Java
 * 10/6/2017.
 * Displays all numbers from 100 to 200(10 per line) that are divisible
 * by 5 or 6 but not both.
 */
package divisiblebyfiveorsix;

public class DivisibleByFiveOrSix {

    public static void main(String[] args) {
        // Constants declarations.
        final int NUMBERS_PER_LINE = 10;            // Holds the total numbers per line
        
        // Variable declarations 
        int counter = 0;                        // Counter used for the loop.
                 
        
        
        // Our range is 100 to 200, loop through numbers within our range.
        for (int number = 100; number <= 200; number++){
            
            boolean divisibleByFive = false,        // Used for conditional checking.
                        divisibleBySix = false;     // Used for conditional checking.
            
            // if the number is divisible by 5  and not 6 set the flag to true. 
            if ((number % 5 == 0) && !(number % 6 == 0)){
                divisibleByFive = true;
            }
            // Otherwise if it is divisible by 6  and not 5 set the flag to true.
            else if ((number % 6 == 0) && !(number % 5 == 0)){
                divisibleBySix = true;
            }
            
            // If the number is divisible by 5 or 6 but not both.
            if (divisibleByFive || divisibleBySix){
                counter++;
                
                // If the remainder of the counter divided by NUMBERS_PER_LINE
                // is zero print on a new line.
                if(counter % NUMBERS_PER_LINE == 0){
                    System.out.println(number);
                }
                // Otherwise print on the same line leaving one space. 
                else{
                    System.out.print(number + " ");
                }
            }
        }
    }
    
}
