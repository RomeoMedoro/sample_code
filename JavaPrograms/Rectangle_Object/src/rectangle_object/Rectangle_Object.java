/*
 * Romeo Medoro.
 * Intro to Java
 * 11/8/2017
 * Creates 2 instances of a recangle object and displays the height, width, 
 * area, and perimeter. 
 */
package rectangle_object;
import java.util.*;

public class Rectangle_Object {

    public static void main(String[] args) {
        // Local variables declarations. 
        double area,
                perimeter,
                width,
                height;
        
        // Create a new rectangle object.
        Rectangle rectangle1 = new Rectangle(3.5, 35.9);
        // Display the attributes of the new rectangle by calling the object
        // methods.
        area = rectangle1.getArea();
        perimeter = rectangle1.getPerimeter();
        width = rectangle1.getWidth();
        height = rectangle1.getHeight();
        
        // Call the displayAttributes method
        displayAttributes(width, height, perimeter, area);
        
        // Create a new rectangle object.
        Rectangle rectangle2 = new Rectangle(4, 40);
        // Display the attributes of the new rectangle by calling the object
        // methods.
        area = rectangle2.getArea();
        perimeter = rectangle2.getPerimeter();
        width = rectangle2.getWidth();
        height = rectangle2.getHeight();
        
        // Call the displayAttributes method.
        displayAttributes(width, height, perimeter, area);
        
    }
    
    /* This method prints the attributes of the rectangle class */
    public static void displayAttributes(double num1, double num2, double num3,
            double num4){
        System.out.println("Rectangle Measuraments: ");
        System.out.println("-----------------------------------");
        System.out.println("Width:\t\t" + String.format("%.2f",num1));
        System.out.println("Height:\t\t" + String.format("%.2f",num2));
        System.out.println("Perimeter:\t" + String.format("%.2f",num3));
        System.out.println("Area:\t\t" + String.format("%.2f",num4) + "\n");
    }
    
}
class Rectangle{
    double width = 1,
            height = 1;
    
    /** construct the rectangle object **/
    Rectangle(){
    }
    /** Rectangle Constructor **/
    Rectangle(double newWidth, double newHeight){
        width = newWidth;
        height = newHeight;
    }
    
    /** Return the Area of the circle **/
    double getArea(){
        return width * height;
    }
    
    /** Return the perimeter **/
    double getPerimeter(){
        return 2 * (height + width);
    }
    
    /** Returns the he width **/
    double getWidth(){
        return width;
    }
    
    /** Returns the height **/
    double getHeight(){
        return height;
    }
    
    /** Set the height **/
    void setHeight(double newHeight){
        height = newHeight;
    }
    
    /** Set new width **/
    void setWidth(double newWidth){
        width = newWidth;
    }
}