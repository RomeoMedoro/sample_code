/*
 * Romeo Medoro.
 * Intro to Java
 * 10/30/2017.
 *  
 */
package illegalargument;
import java.util.*; 
import java.io.*;

public class IllegalArgument {

    public static void main(String[] args) {
        // Variable declarations
        Scanner input = new Scanner(System.in);
        
       System.out.print("Enter annual interest rate: ");
       double annualInterestRate = getDouble();
       
       System.out.print("Enter number of years as an integer: ");
       int numberOfYears = getInteger();
       
       System.out.print("Enter loan amount: ");
       double loanAmount = getDouble();
       
       Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);
       
       System.out.printf("The loan amount was created on %s\n" +
               "The monthly payment is %.2f\nThe total payment is %.2f\n", 
               loan.getLoanDate().toString(), loan.getMonthlyPayment(), 
               loan.getTotalPayment());
       
    }
    
    public static double getDouble(){
        Scanner input = new Scanner(System.in);
        double result = 0;
        do{
            try{
                
                result = input.nextDouble();    
            }
            catch(IllegalArgumentException ex){
                System.out.println("Invalid entry. ");
                System.out.println("Re-enter you number: ");
            }
            input.nextLine();
        }while(result <= 0);
        return result;
    }
    
     public static int getInteger(){
        Scanner input = new Scanner(System.in);
        int result = 0;
        do{
            try{
                System.out.print("Enter annual interest rate: ");
                result = input.nextInt();    
            }
            catch(IllegalArgumentException ex){
                System.out.println("Invalid entry. ");
            }
            input.nextLine();
        }while(result <= 0);
        return result;
    }
    
    
public static class Loan{
    public double annualInterestRate;
    public int numberOfYears;
    public double loanAmount;
    public java.util.Date loanDate;
    
    /*Default constructor 
    */
    public Loan(){
        this(2.5, 1, 1000);
    }
    
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount){
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
    }
    
    /* Return annualInterest Rate */
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    
    /* Set a new annualInterestRate */
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }
    
    /* Return numberOfYears */
    public int getNumberOfYears(){
        return numberOfYears;
    }
    
    /* Set a new numberOfYears */
    public void setNumberOfYears(int numberOfYears){
        this.numberOfYears = numberOfYears;
    }
    
    /* Return loanAmount */
    public double getLoanAmount(){
        return loanAmount;
    }
    
    /* Set a new loanAmount */
    public void setLoanAmount(double loanAmount){
        this.loanAmount = loanAmount;
    }
    
    /* Find monthly payment */
    public double getMonthlyPayment(){
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 - (1 / 
                Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }
    
    /* Find total payment */
    public double getTotalPayment(){
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }
    /* Return loan date */
    public java.util.Date getLoanDate(){
        return loanDate;
    }
}
}
