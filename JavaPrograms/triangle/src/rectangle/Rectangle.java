/*
 * Romeo Medoro.
 * Intro to Java
 * 8/28/2017.
 * Calculates and prints the area and Perimeter of a rectangle. 
 */
package rectangle;

public class Rectangle {
    public static void main(String[] args) {
        // local variable declarations.
        double width = 4.5;                //triangle width.
        double height= 7.9;                //triangle heightr
        double perimeter;                  // holds perimeter of rectable. 
        double area;                       // holds area of the rectangle.
        
        perimeter = 2*(width + height);
        area = width*height;
        
        System.out.println("The area is: ");
        System.out.print(width + " x " + height + " = ");
        System.out.println(String.format("%.2f", area));
        System.out.println("The perimeter is:");
        System.out.print("2(" + width + " + " + height + ") = " );
        System.out.println(String.format("%.2f", perimeter));
    }
    
}
