package com.java.Demo;
//Demonstrate by using the Constructor example

public class Test {
    private String accountNumber;
    private double balance;

    public Test(String number, double initialDeposit) {
        this.accountNumber = number;
        this.balance = initialDeposit;
    }

    public void deposit(double amount) {
        balance += amount; // balance=balance+amount
    }

    public void withdraw(double amount) {
        if (amount <= balance) { //Comparision operator
            balance -= amount; // balance = balance-amount
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
     Test account = new Test("123456", 1000);
        System.out.println("Initial balance: " + account.getBalance());

        account.deposit(500);
        System.out.println("Balance after deposit: " + account.getBalance());

        account.withdraw(200);
        System.out.println("Balance after withdrawal: " + account.getBalance());
    }
}
