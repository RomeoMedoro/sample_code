/*
 * Romeo Medoro.
 * Intro to Java
 * 11/17/2017
 * ATM machine simulation program. Displays a menu that allows users to select
 * different ATM options. 
 */
package atmmachine;
import java.util.*;
import java.io.*;

import java.util.Date;

public class ATMMachine {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Local variable declarations
        int selection =0,                    // Holds the menu selection.
                inputID = 0,                 // Holds the ID
                maxAttempt = 4;              // max allowed input attempts. 
        double balance,                     // holds the balance
                amount;                     // holds the withdraw/deposit amount. 
        boolean displayMenu = false;        // Used to validate the ID input. 
        
        // create an array of of account objects. 
        Account[] accounts = new Account[10];
        for (int i = 0; i < accounts.length; i++){
            accounts[i] = new Account(i, 100);
        }
        
        // Ask the user to enter an ID until the correct
        // ID is entered or the maximum number of attempts is reached. 
        System.out.print("Enter an id: ");
        
        while(displayMenu == false){
            // Collect the input 
            inputID = input.nextInt();
            // subtract from the maxAttempts.
            maxAttempt --;
            
            // Loop through the array to check the IDs, return true is 
            // the input matches any of the IDs of the objects in the array.
            for (int i = 0; i < accounts.length; i++){
                if (inputID == accounts[i].getId())
                    displayMenu = true;
            }
            // If there is no match, and we have not exceeded our allowed 
            // number of tries, ask for the user to try again. 
            if (displayMenu != true && maxAttempt != 0){
                System.out.print("\nInvalid ID. Please re-enter your ID: ");
            }
            // otherwise notify the user that the number of attempts have been 
            // exceeded, and exit the program. 
            else if(maxAttempt == 0){
                System.out.println("\nExceeded max number or tries. ");
                System.exit(1);
            }
        }
        
        // ATM Menu
        do{
            System.out.println("\nMain Menu ");
            System.out.println("-----------------");
            System.out.println("1: check balance");
            System.out.println("2: withdraw");
            System.out.println("3: deposit");
            System.out.println("4: exit");
            System.out.print("Enter a choice: ");
            selection = input.nextInt();
            
            // Check the selection, and perform an action based on the selection.
            switch(selection){
                case 1:
                    // get the balance and display it to the user. 
                    balance = accounts[inputID].getBalance();
                    System.out.println("\nYour current balance is:  $" + 
                            String.format("%.2f", balance));
                    break;
                case 2:
                    // ask for the amount to withdraw
                    System.out.print("\nHow much would you like to withdraw? ");
                    amount = input.nextDouble();
                    // Make the withdrawal. 
                    accounts[inputID].withdraw(amount);
                    // display the new balance if it is positive
                    if (accounts[inputID].getBalance() >= 0){
                        System.out.println("Withdrawing $" + amount);
                        System.out.println("Your new balance is: " + 
                                String.format("%.2f", accounts[inputID].getBalance()));
                    }
                    else{
                        System.out.println("Insufficient Funds!");
                    }
                    break;
                case 3: 
                    // ask for the amount to deposit
                    System.out.print("\nHow much do you wish to deposit? ");
                    amount = input.nextDouble();
                    // Make the deposit.
                    accounts[inputID].deposit(amount);
                    // Display the new balance.
                    System.out.println("$" + amount + " has been deposited.");
                    System.out.println("Your new balance is: " + 
                            String.format("%.2f", accounts[inputID].getBalance()));
                    System.out.println(accounts[inputID].getDateCreated());
                    break;
                case 4:
                    System.out.println("\nThanks for stopping by. \nGoodbye!");
            }
        }while(selection != 4);
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
