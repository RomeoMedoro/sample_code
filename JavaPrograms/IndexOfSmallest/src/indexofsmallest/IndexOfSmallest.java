/*
 * Romeo Medoro.
 * Intro to Java
 * 10/23/2017.
 * Finds the index of the smallest element. 
 */
package indexofsmallest;
import java.util.*;

public class IndexOfSmallest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int index;
        
        double myArray[] = new double[10];
        
        System.out.print("Enter 10 numbers: ");
        
        for (int i = 0; i < myArray.length; i++){
            myArray[i] = input.nextInt();
        }
        
        index = indexOfSmallestElement(myArray);
        System.out.println(index);
    }
    
    /* Returns the index of the smallest element in an array of integers.
    If the number of the element is greater than 1, it returns the smallest index
    */
    public static int indexOfSmallestElement(double[] array){
        int result = 0;
        double min = array[0];
            for (int i = 0; i < array.length; i++){
                if(array[i] > 1){
                    if(array[i] < min){
                        min = array[i];
                        result = i;
                    }
                }
            }
        return result;
    }
}
