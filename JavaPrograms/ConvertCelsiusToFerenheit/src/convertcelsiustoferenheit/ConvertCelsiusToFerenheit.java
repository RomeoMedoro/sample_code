/*
 * Romeo Medoro.
 * Intro to Java
 * 10/9/2017.
 * Computes the sum of the digits in an integer. 
 */
package convertcelsiustoferenheit;
import java.util.Scanner;

public class ConvertCelsiusToFerenheit {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double celsius = 40,
                fahrenheit = 120;
        
        System.out.println("Celsius \t Fahrenheit \t\t Fahrenheit \t Celsius");
        System.out.println("------------------------------------------------------------------");
        
        int i = 40;
        int j = 120;
        
        while (i != 30 && j != 29){
            System.out.println(i + "\t\t  " + String.format("%.1f", celsiusToFahrenheit(
            (double)(i))) + "\t\t\t   " + j + "\t\t " + String.format("%.2f", fahrenheitToCelsius(
            (double)(j))));
            
            i --;
            j-= 10;
        }
        
        
    }
    
    /* this method converts celsius to fahrenheit */
    public static double celsiusToFahrenheit(double celsius){
        double result;
        
        result = (9.0 / 5) * celsius + 32;
        
        return result;
    }
    
    /* This method converts fahrenheit to celsius */
    public static double fahrenheitToCelsius(double fahrenheit){
        double result;
        
        result = (5.0 / 9) * (fahrenheit - 32);
        
        return result;
    }
}

