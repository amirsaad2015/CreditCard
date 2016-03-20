/*
 * Author: Amir Saad
 * This program creates a class for a credit card with various
 * fields associated to customer's private information.
 */

package creditcard;

import java.util.InputMismatchException;
import java.util.Scanner;


public class CreditCard {
   private String name, duedate;
   private int accountnum;
   private int rewardpts;
   private double balance;
   Scanner in;
   //Initialize global fields
    
    public CreditCard() {

        in = new Scanner(System.in);
       
        System.out.print("Enter your first and last name: ");
        
        try {
            name = in.nextLine();
            //Prompt user to enter name, and validate user input
            
        } catch(InputMismatchException e) {
            System.out.println("Please only enter text for your name.");
        }
        
        System.out.print("Enter the due date separated by /: ");
        
        try {
            duedate = in.nextLine();
             //Prompt user to enter the duedate, and validate user input
            
        } catch(InputMismatchException e) {
            System.out.println("Please only enter text for the duedate");
        }
        
        accountnum = (int) Math.floor(Math.random() * 1000);
        //Create account number from 1 - 1000 using random integers
        
        rewardpts = 0;
        balance = 0;
        //Set reward points and balance to zero
        
    }
    
    public String getName() {
        return name;
    }
    
    public String getDueDate() {
        return duedate;
    }
    
    public int getAccountNum() {
        return accountnum;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public int getRewardPts() {
        return rewardpts;
    }
    
    private void setBalance(double amount) {
        balance = amount;
    }
    //Add amount to current balance
    
    public void cashAdvance(double amount) {
        if(amount < 0) {
            System.out.println("Please enter only positive amounts.");
        } else {
        setBalance(getBalance() + amount);
        addInterest(amount, 0.03);
        }
    }
    //add cash advance to current balance
    
    public void creditcardCharge(double amount) {
        if(amount < 0) {
            System.out.println("Please enter only positive amounts.");
        } else {
        setBalance(getBalance() + amount);
        addInterest(amount, 0.05);
        }
    }
    //add credit card charge to balance and interest
    
    public void addInterest(double amount, double rate) {
        setBalance(amount * rate);
    }
    //Add interest to the bank account based on credit charges and cash advances
    
    public void payment (double amount) {
        if(amount < 0) {
            System.out.println("Please enter only positive amounts.");
        } else {
        setBalance(getBalance() - amount);
        rewardpts = getRewardPts() + 50;
        }
    }
    //Subtract payment from balance
    
    @Override
    public String toString() {
        return "the remaining balance for " + getAccountNum() + " " + getName() + " is " + getBalance() + ". Your next due date is " + getDueDate() + " and  your reward points is " + getRewardPts() + ".";
    }
    public static void main(String args[]) {
        CreditCard c = new CreditCard();
        //Create a credit card object
    }
}
