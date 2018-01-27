/*
 * Romeo Medoro.
 * Intro to Java
 * 11/8/2017
 * Creates three regular polygon objects and displyas their perimeter and 
 * area.
 */
package polygongenerator;
import java.util.*;

public class PolygonGenerator {

    public static void main(String[] args) {
        // Local Variables
        double perimeter,
                area;
        
        // Create a regular polygon using the non argument constructor.
        RegularPolygon polygon1 = new RegularPolygon();
        
        // Create a regular polygon
        RegularPolygon polygon2 = new RegularPolygon(6 , 4);
        
        // Create a regular polygon
        RegularPolygon polygon3 = new RegularPolygon(10 , 4 , 5.6 , 7.8);
        
        // Get the perimeter and area for the polygons and display them. 
        perimeter = polygon1.getPerimeter(polygon1.getSides(), 
                polygon1.getSideLength());
        area = polygon1.getArea(polygon1.getSides(), polygon1.getSideLength());
        
        // Display the resutls for the first object
        System.out.println("The first regual polygon has a perimeter of: " + 
                perimeter + ", and an area of: " + String.format("%.3f",area));
        
        // Get the perimeter and area for the second object
        perimeter = polygon2.getPerimeter(polygon2.getSides(), 
               polygon2.getSideLength());
        area = polygon2.getArea(polygon2.getSides(), polygon2.getSideLength());
        
        // Display the results for the second object
        System.out.println("The second regual polygon has a perimeter of: " + 
                perimeter + ", and an area of: " + String.format("%.3f",area));
        
         // Get the perimeter and area for the third object
        perimeter = polygon3.getPerimeter(polygon3.getSides(), 
               polygon3.getSideLength());
        area = polygon3.getArea(polygon3.getSides(), polygon3.getSideLength());
        
        // Display the results for the second object
        System.out.println("The third regual polygon has a perimeter of: " + 
                perimeter + ", and an area of: " + String.format("%.3f",area));
    }
}   
class RegularPolygon{
    // class attributes
    private int n;
    private double side,
            x,
            y;

    /* Default Constructor */
    RegularPolygon(){
        n = 3;
        side = 1;
        x = 0;
        y = 0;
    }

    /* Constructor that specifies number of sides and length of side */
    RegularPolygon(int newN, double newSide){
        n = newN;
        side = newSide;
        x = 0;
        y = 0;
    }
    /* Constructor that specifies number of sides, lenth of side, and 
    x and y coordinates. 
    */
    RegularPolygon(int newN, double newSide, double newX, double newY){
        n = newN;
        side = newSide;
        x = newX;
        y = newY;
    }

    /* Return the number of sides */
    int getSides(){
        return n;
    }   
    /* Set the number of sides */
    public void setSides(int newSides){
        if (newSides > 0){
            n = newSides;
        }
        else
            n = 0;
    }

    /* Return the side length */
    double getSideLength(){
        return side;
    }
    /* Set the side length */
    public void setSideLength(double newSideLength){
        if (newSideLength > 0){
            side = newSideLength;
        }
        else
            side = 0;
    }

    /* Returns the x-coordinate */
    double getxCoordinate(){
        return x;
    }
    /* Set the x-coordinate */
    public void setxCoordinate(double newxCoord){
        if (newxCoord >= 0){
            x = newxCoord;
        }
        else
            x = 0;
    }

    /* Returns the y-coordinate */
    double getyCoordinate(){
        return y;
    }
    /* Set y-coordinate */
    public void setyCoordinate(double newyCoord){
        if (newyCoord >= 0){
            y = newyCoord;
        }
        else 
            y = 0;
    }

    /* Object method to return the perimeter */
    public double getPerimeter(int n, double side){
        double result;
        result = n * side;

        return result;
    }

    /* Object method to return the area */
    public double getArea(int n, double side){
        double result;
        result = (n * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / n));

        return result;
    }
    
}
