/*
 * Romeo Medoro.
 * Intro to Java
 * 9/25/2017.
 * Takes user input and calculates the area of a hexagon.
 */
package areaofhexagon;
import java.util.Scanner;

public class AreaOfHexagon {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Variable declarations.
        double sideLength,          //Holds user input.
                area;               // Holds the area.
        
        // Ask user to enter side legth.
        System.out.print("Enter the length of the side: ");
        sideLength = input.nextDouble();
        
        //Validate user input
        if(!(sideLength == (double)sideLength) || sideLength <= 0){
            System.out.println("Invalid input");
            System.exit(1);
        }
        else{
            // Call the calculate area method.
            area = calculateArea(sideLength);
            
            // Print the results.
            System.out.println("The area of the hexagon is " + String.format("%.2f", area));
        }
        
    }
    
    /* Calculates the area of the hexagon */
    public static double calculateArea(double side){
        // holds the result.
        double result;
        
        result = (6*Math.pow(side, 2))/(4*Math.tan(Math.PI/6));
        
        return result;
    }
    
}
