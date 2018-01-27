/*
 * Romeo Medoro.
 * Intro to Java
 * 9/30/2017.
 * Prompts user to enter the number of sides of a polygon, and their length
 * and displays the area. 
 */
package areaofapolygon;
import java.util.Scanner;

public class AreaOfAPolygon {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Variable declarations.
        int numberOfSides;              //Holds the number of sides. 
        double sideLength,              //Holds the length of the side.
                area;                   //Holds the area of the polygon.
        
        // Prompt user to enter the number of sides.
        System.out.print("Enter the number of sides: ");
        numberOfSides = input.nextInt();
        
        // Validate the side input.
        if(!(numberOfSides == (int)(numberOfSides)) || numberOfSides < 2){
            System.out.println("Input must be an integer greater than 1.");
            System.exit(1);
        }
        
        // Prompt user to enter the length of the side.
        System.out.print("Enter the length of the side as a decimal ex- 1.0: ");
        sideLength = input.nextDouble();
        
        // Validate the input. 
        if (sideLength <= 0){
            System.out.println("Input must be greater than 0.");
            System.exit(2);
        }
        
        // Call the calculatePolygonArea method. 
        area = calculatePolygonArea(numberOfSides, sideLength);
        
        // Display the results to the user.
        System.out.println(String.format("%.2f", area));   
    }
    
    /* Takes in the number of sides and the side length and calculates the 
    area of the polygon.
    */
    public static double calculatePolygonArea(int num1, double num2){
        double result;
        
        double temp1 = num1 * Math.pow(num2, 2);
        double temp2 = 4 * Math.tan(Math.PI/num1);
        
        result = temp1/temp2;
        
        return result;
    }
    
}
