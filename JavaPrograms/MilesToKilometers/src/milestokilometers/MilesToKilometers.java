/*
 * Romeo Medoro.
 * Intro to Java
 * 10/2/2017.
 * Prints a table that converts miles to kilometers. 
 */
package milestokilometers;

public class MilesToKilometers {

    public static void main(String[] args) {
        // Variable declarations. 
        int mile;
        double kilometer = 1.609;
        
        System.out.println("Miles \t\t Kilometers");
        System.out.println("---------------------");
        
        for(mile = 1; mile <= 10; mile ++){
            System.out.println(mile + " \t\t "+ mile * kilometer);
        }
    }
    
}
