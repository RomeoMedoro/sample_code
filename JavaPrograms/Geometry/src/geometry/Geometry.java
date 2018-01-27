/*
 * Romeo Medoro.
 * Intro to Java
 * 9/16/2017.
 * Calculates the distance between two points entered by the user. 
 */
package geometry;
import java.util.Scanner;

public class Geometry {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Variable Declarations.
        double pointX1,             //Holds the first x coordinate.
                pointY1,            //Holds the first y coordinate.
                pointX2,            //Holds the second x coordinate.
                pointY2,            //Holds the second y coordinate.
                distance;           //Holds the distance. 
        
        //Ask user to input first set of coordinates. 
        System.out.print("Enter x1 and y1 separated by a space: ");
        pointX1 = input.nextDouble();
        pointY1 = input.nextDouble();
        
        //Ask user to input second set of coordinates.
        System.out.print("Enter x2 and y2 separated by a space: ");
        pointX2 = input.nextDouble();
        pointY2 = input.nextDouble();
        
        //Call the total distance method.
        distance = totalDistance(pointX1, pointY1, pointX2, pointY2);
        
        //Display the asnwer to the user.
        System.out.println("The distance between the points is " + distance);
    }
    
    
    /* Calculates and returns the distance between two sets of x, y coordinates */
    public static double totalDistance(double x1,double y1, double x2, double y2){
        //Holds the result.
        double result,
                subResult;
        
        subResult = (Math.pow((x2 - x1),2)+ Math.pow((y2 - y1),2));
        result = Math.pow(subResult, 0.5);
                
        return result;
    }
    
}
