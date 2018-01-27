/*
 * Romeo Medoro.
 * Intro to Java
 * 11/8/2017
 * Creates an account object with an account with a designated ID, balance, 
 * and interest rate. Has the ability to withdraw deposit, and print account
 * information. 
 */
package accountprogram;
import java.util.*;

public class AccountProgram {

    public static void main(String[] args) {
        // Local Variables
        int id;
        double balance,
                monthlyInterest;
        Date dateCreated;
        
        // Create an account object 
        Account account1 = new Account(1122, 20000);
        
        // set the iterestRate 
        account1.setAnnualInterestRate(4.5);
        
        // Use the withdraw method to withdraw from the account 
        account1.withdraw(2500);
        
        // Use the deposit method to deposit into the account 
        account1.deposit(3000);
        
        // Get account information
        id = account1.getId();
        balance = account1.getBalance();
        monthlyInterest = account1.getMonthlyInterest();
        dateCreated = account1.getDateCreated();
        
        // Print the account details
        System.out.println("---------------------------------------------------");
        System.out.println("\t    Account Number:  " + id);
        System.out.println("---------------------------------------------------");
        System.out.println("Created:\t\t" + dateCreated);
        System.out.println("Monthly Interest:\t$" + monthlyInterest);
        System.out.println("Balance:\t\t$" + balance);
    }
    
}

class Account{
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated;
    
    /* Construct an Account and assign a date */
    Account(){
        dateCreated = new Date();
    };
    
    /* Construct an Account with a specified id, and initial balance */
    Account(int newID, double newBalance){
        id = newID;
        balance = newBalance;
        dateCreated = new Date();
    }
   
    /* Return the balance */
   double getBalance(){
       return balance;
   }
   
   /* set a new balance */
   public void setBalance(double newBalance){
       balance = newBalance;
   }
   
   /* Get the ID */
   int getId(){
       return id;
   }
   
   /* set the ID */
   public void setID(int newID){
       if (newID > 0){
           id = newID;
       }
       else{
           id = 0;
       }
   }
   
   /* get the interest rate */
   double getAnnualInterestRate(){
       return annualInterestRate;
   }
   
   /* set the interest rate */
   public void setAnnualInterestRate(double newInterestRate){
       if(newInterestRate > 0){
           annualInterestRate = newInterestRate;
       }
       else{
           annualInterestRate = 0;
       }
   }
   
   /* Return the date created */
   Date getDateCreated(){
       return dateCreated;
   }
   
   /* Return the monthly interest rate */
   public double getMonthlyInterestRate(){
       return (annualInterestRate/100)/12;
   }
   
   /* Return monthly interest */
   public double getMonthlyInterest(){
       return balance * getMonthlyInterestRate();
   }
   
   /* Withdraws money from the account */
   public void withdraw(double num){
       balance -= num;
   }
   
   /* Deposits money to the account */
   public void deposit(double num){
       balance += num;
   }
}
