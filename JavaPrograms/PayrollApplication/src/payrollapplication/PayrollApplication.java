/*
 * Romeo Medoro.
 * Intro to Java
 * 9/25/2017.
 * Collects a variety of employee input and prints a payroll statement.
 */
package payrollapplication;
import java.util.Scanner;

public class PayrollApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Variable declarations. 
        String name = "";               // Holds the employee's name
        double hoursWorked,             // Holds the week hours worked.
                hourlyPayRate,          // Holds the employee's pay rate. 
                federalTaxRate,         // Holds the federal tax rate.
                stateTaxRate,           // Holds the state tax rate.
                grossPay,               // Holds the gross pay.
                totalFederalTax,        // Holds total federal tax withheld.
                totalStateTax,          // Holds total state tax withheld.
                totalDeductions,        // Holds the total deductions.
                netPay;                 // Holds the employee's net pay.
        
        // Prompt user for input.
        System.out.print("Enter employee's name: ");
        name = input.nextLine();
        
        //Validate the input. 
        if (name.matches("\\d+")){
            System.out.println("Input should be a name!");
            System.exit(1);
        }
        
        // Promt the user for the next input.
        System.out.print("Enter number of hours worked in a week: ");
        hoursWorked = input.nextDouble();
        
        // Call the isValid method to validate the input. 
        isValid(hoursWorked);
        
        // Promt user for next input.
        System.out.print("Enter hourly pay rate: ");
        hourlyPayRate = input.nextDouble();
        
        // Call the isValid method to validate the input. 
        isValid(hourlyPayRate);
        
        // Prompt user for next input. 
        System.out.print("Enter federal tax withholding rate: ");
        federalTaxRate = input.nextDouble();
        
        // Call the isValid method to validate the input. 
        isValid(federalTaxRate);
        
        // Prompt user for next input
        System.out.print("Enter the state tax withholding rate: ");
        stateTaxRate = input.nextDouble();
        
        // Call the isValid method to validate the input. 
        isValid(stateTaxRate);
        
        // Call the calculateGrossPay method.
        grossPay = calculateGrossPay(hoursWorked, hourlyPayRate);
        
        // Call the calculateDeductions method to find out the amounts withheld.
        totalFederalTax = calculateDeductions(grossPay, federalTaxRate);
        totalStateTax = calculateDeductions(grossPay, stateTaxRate);
        
        // Add the federal and state withholdings to find the total withheld.
        totalDeductions = totalFederalTax + totalStateTax;
        
        // Calculate net pay with based on gross pay and total deductions. 
        netPay = grossPay - totalDeductions;
        
        // Call displayData method to display the result.
        displayData(name, hoursWorked, hourlyPayRate, grossPay, federalTaxRate,
                stateTaxRate, totalDeductions, netPay, totalFederalTax, totalStateTax);
        
    }
    
    /* method to validate the user input doubles. Takes in double, if validation
    fails it displays an error message and abourt the app. 
    */
    public static void isValid(double number){    
        if (!(number == (double)(number)) || number <= 0){
            System.out.println("Input must be a number greater than 0!");
            System.exit(1);
        }
    }
    
    /* Method to calculate the gross pay, takes in hours worked and 
    hourly rate and returns the gross pay. 
    */
    public static double calculateGrossPay(double num1, double num2){
        double result;
        
        result = num1 * num2;
        
        return result;
    }
    
    /* Method to calculate deductions. Takes in grossPay, and the withholding
    rates and returns the result. 
    */
    public static double calculateDeductions(double pay, double rate){
        double result;
        
        result = pay * rate;
        
        return result;
    }
    
    /* Method to display the result to the user. Takes in employee name, hours 
    worked, pay rate, gross pay, deductions, and net pay and prints them to the 
    screen.
    */
    public static void displayData(String name, double hours, double payRate,
            double grossPay, double federalTax, double stateTax, double totalDed,
            double netPay, double totalFed, double totalState){
        double tempFedTax, 
                tempStateTax;
        
        tempFedTax = federalTax * 100;
        tempStateTax = stateTax * 100;
        
        String hour = String.format("%.2f", hours), 
                pay = String.format("%.2f", payRate),
                gross = String.format("%.2f", grossPay),
                deduction = String.format("%.2f", totalDed),
                net = String.format("%.2f", netPay),
                fedPercentage = String.format("%.1f", tempFedTax),
                statePercentage = String.format("%.1f", tempStateTax),
                totalFedWithheld = String.format("%.2f", totalFed),
                totalStateWithheld = String.format("%.2f", totalState);
        
        System.out.println("\nEmployee Name: " + name + "\n" + 
                "Hours worked: " + hour + "\n" + 
                "Pay Rate: $" + pay + "\n" +
                "Gross Pay: $" + gross + "\n" +
                "Deductions: " + "\n" +
                "\t Federal Withholdings (" + fedPercentage + "%): $" + totalFedWithheld +
                "\n \t State Withholdings (" + statePercentage + "%): $" + totalStateWithheld +
                "\n\t Total Deduction: $" + deduction +
                "\n Net Pay: $" + net);
        
    }
}
