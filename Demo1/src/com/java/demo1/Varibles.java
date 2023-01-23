package com.java.demo1;
// demonstrates the use of instance variables, local variables, and static variables in a Java program.

class BankAcount {
    // instance variables
    private String accountNumber;
    private double balance;
    private static int bankCode = 123;
    //The bankCode is a static variable that is shared among all objects of the class. 
      //It is used to store the bank code that is common to all accounts.

    // constructor
    public BankAcount(String accountNumber, double balance) { //The accountNumber and balance are instance variables that are unique 
    	                                                       //to each object of the class.
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // instance method
    public void deposit(double amount) {
        balance += amount;
    }

    // instance method
    public void withdraw(double amount) {
        // local variable
        double fee = 0.05;
        if (balance - amount - fee < 0) {
            System.out.println("Insufficient funds!");
            return;
        }
        balance -= amount + fee;
    }

    // static method
    public static void setBankCode(int code) {
        bankCode = code;
    }

    // instance method
    public String getAccountNumber() {
        return accountNumber;
    }

    // instance method
    public double getBalance() {
        return balance;
    }

    // static method
    public static int getBankCode() {
        return bankCode;
    }
}

public class Varibles {
    public static void main(String[] args) {
        BankAcount account1 = new BankAcount("123456", 1000);
        account1.deposit(500);
        account1.withdraw(200);
        System.out.println("Account Number: " + account1.getAccountNumber());
        System.out.println("Balance: " + account1.getBalance());
        System.out.println("Bank Code: " + BankAcount.getBankCode());
    }
}
