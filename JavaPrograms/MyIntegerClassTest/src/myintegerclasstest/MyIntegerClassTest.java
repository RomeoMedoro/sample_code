/*
 * Romeo Medoro.
 * Intro to Java
 * 11/17/2017
 * Tests all the methods contained in the MyInteger class.
 */
package myintegerclasstest;
import java.util.*;
import java.io.*;

public class MyIntegerClassTest {

    public static void main(String[] args) {
        // Variable Declarations.
        int outputNumber;
        
        // Instanciate 4 MyInteger objects.
        MyInteger integer1 = new MyInteger(14);
        MyInteger integer2 = new MyInteger(2);
        MyInteger integer3 = new MyInteger(31);
        MyInteger integer4 = new MyInteger(57);
        
        // Place the ocject in an object array
        MyInteger[] integerList = {integer1, integer2, integer3, integer4};
        // Declare an array of numeric characters.
        char[] charList = {'2', '1', '5', '9', '4', '7'};
        
        //Loop through the list to test the getter method.
        System.out.println("Testing the Methods");
        System.out.println("-------------------------------------------");
        for (int i = 0; i < integerList.length; i++){
            System.out.println("Object #" + (i+1) + " has a value of: " + 
                    integerList[i].getValue());
            System.out.println("   is it even?    " + integerList[i].isEven());
            System.out.println("   Is it odd?     " + integerList[i].isOdd());
            System.out.println("   Is it prime?   " + integerList[i].isPrime());
        }
        
        // Test the methods with int parameters
        System.out.println("\nNumber: " + 84 );
        System.out.println("   Is it even?    " + MyInteger.isEven(84));
        System.out.println("   Is it odd?     " + MyInteger.isOdd(84));
        System.out.println("   Is it prime?   " + MyInteger.isPrime(84));
        
        //Testing the equals methods
        System.out.println("\nIs " + integerList[0].value + " equal to " + 
                integerList[3].value + "?   " + 
                integerList[0].equals(integerList[3]));
        System.out.println("Is " + 31 + " equal to " + integerList[2].value + 
                "?   " + integerList[2].equals(31));
        
        // Testing the parseInt method
        outputNumber = MyInteger.parseInt(charList);
        System.out.println("The parseInt method converts the follwing char array:");
        System.out.print("\t");
        for (int i = 0; i < charList.length; i++){
            System.out.print("'" + charList[i] + "' ");
        }
        
        System.out.println("\nInto the number: " + outputNumber);
        outputNumber = MyInteger.parseInt("198723");
        System.out.println("It also converts a string of numbers such as \"198723\"");
        System.out.println("Into the number: " + outputNumber);
    }
    
}

/* MyInteger Class */
class MyInteger{
    int value;
    
    // Constructor, takes in a specified value.
    MyInteger(int value){
        this.value = value;
    }
    
    /* Return the Value */
    int getValue(){
        return value;
    }
    
    /* returns true if the value is even */
    public boolean isEven(){
        if(this.value % 2 == 0)
            return true;
        else 
            return false;
    }
    
    /* returns true if the velue is odd */
    public boolean isOdd(){
        if( this.value % 2 != 0)
            return true;
        else
            return false;
    }
    
    /* returns true if the value is prime */
    public boolean isPrime(){
        //check if value is a multiple of 2
        if (this.value % 2 == 0) 
            return false;
        //if not, check the odd numbers
        for(int i = 3; i * i <= this.value; i += 2) {
            if(this.value % i == 0)
                return false;
        }
        return true;
    }
    
    /* returns true if the value is even */
    public static boolean isEven(int v){
        if (v % 2 == 0 )
            return true;
        else 
            return false;
    }
    
    /* returns true if the value is odd */
    public static boolean isOdd(int v){
        if (v % 2 != 0)
            return true;
        else
            return false;
    }
    
    /* returns true if the value is prime */
    public static boolean isPrime(int v){
        //check if value is a multiple of 2
        if (v % 2 == 0) 
            return false;
        //if not, check the odd numbers
        for(int i = 3; i * i <= v; i += 2) {
            if(v % i == 0)
                return false;
        }
        return true;
    }
    
    /* returns true if the value of the class instance is even. */
    public static boolean isEven(MyInteger integer){
        return integer.isEven();
    }
    
    /* returns true if the value of the class instance is odd */
    public static boolean isOdd(MyInteger integer){
        return integer.isOdd();
    }
    
    public static boolean isPrime(MyInteger integer){
        return integer.isPrime();
    }
    
    /* returns true is the value is equal to the specified value */
    public boolean equals(int v){
        if (v == this.value)
            return true;
        else
            return false;
    }
    
    /* returns true if the value of the class instance is prime */
    public boolean equals(MyInteger integer){
        if (integer.value == this.value)
            return true;
        else
            return false;
    }
    
    /* converts an array of numeric chars to an integer */
    public static int parseInt(char[] arr){
        int result = 0;
        String temp = "";
        for (int i = 0; i < arr.length; i ++){
            temp += Character.getNumericValue(arr[i]);
        }
        result = Integer.parseInt(temp);
        return result;
    }
    
    /* converts a string of numbers to an integer */
    public static int parseInt(String s){
        int result = 0;
        try{
            result = Integer.parseInt(s);
            
        }
        catch(NumberFormatException e){
            System.out.println("This is not a number. ");
        }
        return result;
    }
}
