package com.java.Demo;

abstract class BankAccount {
    protected double balance;
    public BankAccount(double balance) {
        this.balance = balance;
    }
    public abstract String getBalance();
}

class CheckingAccount extends BankAccount {
    public CheckingAccount(double balance) {
        super(balance);
    }
    public String getBalance() {
        return "Checking account balance: " + balance;
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(double balance) {
        super(balance);
    }
    public String getBalance() {
        return "Savings account balance: " + balance;
    }
}

class CreditAccount extends BankAccount {
    public CreditAccount(double balance) {
        super(balance);
    }
    public String getBalance() {
        return "Credit account balance: " + balance;
    }
}

public class Poly {
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[3];
        accounts[0] = new CheckingAccount(1000);
        accounts[1] = new SavingsAccount(2000);
        accounts[2] = new CreditAccount(3000);

        for (BankAccount account : accounts) {
            System.out.println(account.getBalance());
        }
    }
}
