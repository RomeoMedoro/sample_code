/*
 * Romeo Medoro.
 * Intro to Java
 * 10/27/2017.
 * Reads a 3x4 matrix and sums each column.
 */
package sumbycolumn;
import java.util.*;

public class SumByColumn {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Local variables. 
        double[][] matrix = new double[3][4];
        double sum;
        
        // Prompt user to enter the matrix values.
        System.out.println("Enter a 3-by-4 matrix row by row:");
        
        // Get user input by row and column. 
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[row].length; col++){
                matrix[row][col] = input.nextDouble();
            }
        }
        
        // Loop through the matrix to add each column.
        for (int col = 0; col < 4; col++){
            sum = sumColumn(matrix, col);
            
            // Print the sum.
            System.out.println("Sum of the elements at column " + col +" = " + sum);
        }
    }
    /* Returns the sum of all elements in a specified column of a matrix.*/
    public static double sumColumn(double[][] m, int columnIndex){
        double result = 0;
            for (int row = 0; row < m.length; row++){
                result += m[row][columnIndex];
            }
        return result;
    }
}
