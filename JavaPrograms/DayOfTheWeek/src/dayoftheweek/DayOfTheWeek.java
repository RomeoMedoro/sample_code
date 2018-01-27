/*
 * Romeo Medoro.
 * Intro to Java
 * 9/23/2017.
 * Calculates the day of the week. 
 */
package dayoftheweek;
import java.util.Scanner;

public class DayOfTheWeek {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Variable declarations.
        int year,                       //Holds the year.
                month,                  //Holds the month.
                dayOfMonth;             //Holds the day of the month.
        double dayOfWeek;               //Holds the day of the week. 
        
        // Get year from user.
        System.out.print("Enter year: (e.g., 2012): ");
        year = input.nextInt();
        
        // Validate user response.
        if (!(year == (int)(year))){
            System.out.println("Invalid response!");
            System.exit(1);
        }
        
        // Get month from user.
        System.out.print("Enter month: 1-12: ");
        month = input.nextInt();
        
        // Validate user response
        if (!(month == (int)(month)) || month < 1 || month > 12){
            System.out.println("Invalid entry!");
            System.exit(1);
        }
        
        // Get Day of the Month from user. 
        System.out.print("Enter the day of the month: 1-31: ");
        dayOfMonth = input.nextInt();
        
        // Validate user response.
        if (!(dayOfMonth == (int)(dayOfMonth)) || dayOfMonth < 1 || dayOfMonth > 31){
            System.out.println("Invalid entry!");
            System.exit(1);
        }
        
        // reassign the appropriate values to Jan and Feb and the year. 
        if (month == 1){
            month = 13;
            year = year - 1;
        }
        else if (month == 2){
            month = 14;
            year = year - 1;
        }
        
        // Calculate the day of the week. 
        dayOfWeek = (dayOfMonth + 26*(month + 1)/10 + yearOfCentury(year) 
                + yearOfCentury(year)/4 + calculateYear(year)/4
                + 5*calculateYear(year))%7;
        
        //Call the stringValue method to display the results. 
        stringValue((int)(dayOfWeek));
    }
    
    /* Calculates the year/100 */
    public static double calculateYear(int number){
        // Holds the result. 
        double result;
        
        result = number/100;
        
        return result;
    }
    
    /* Calculates the year of century */
    public static int yearOfCentury(int number){
        int result;
        
        result = number % 100;
        
        return result;
    }
    
    /* Takes the integer result of the calculation and returns a string
    value of the response. 
    */
    public static void stringValue(int number){
        String day = "";
        
        if (number == 0){
           day = "Saturday";
        }
        else if (number == 1){
            day = "Sunday";
        }
        else if (number == 2){
            day = "Monday";
        }
        else if (number == 3){
            day = "Tuesday";
        }
        else if (number == 4){
            day = "Wednesday";
        }
        else if (number == 3){
            day = "Thursday";
        }
        else {
            day = "Friday";
        }
        
        System.out.println("Day of the week is " + day);
        
    }
}
