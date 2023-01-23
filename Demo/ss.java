package com.java.Demo;
//demonstarte the Encapsulation Real time Example

class BankAccountt {
    private double balance;
    private String accountNumber;
    private String owner;
    private boolean isLocked;

    public BankAccountt(String accountNumber, String owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0.0;
        this.isLocked = false;
    }

    public void deposit(double amount) {
        if (!isLocked) {
            balance += amount;
            System.out.println("Deposited " + amount + " to account " + accountNumber);
        } else {
            System.out.println("Can't deposit, account is locked");
        }
    }

    public void withdraw(double amount) {
        if (!isLocked) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrew " + amount + " from account " + accountNumber);
            } else {
                System.out.println("Insufficient funds");
            }
        } else {
            System.out.println("Can't withdraw, account is locked");
        }
    }

    public void lockAccount() {
        isLocked = true;
    }

    public void unlockAccount() {
        isLocked = false;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public boolean isLocked() {
        return isLocked;
    }
}

public class ss {
    public static void main(String[] args) {
        BankAccountt myAccount = new BankAccountt("123456", "MAdhu");
        System.out.println("Account Number: " + myAccount.getAccountNumber());
        System.out.println("Account Owner: " + myAccount.getOwner());
        System.out.println("Initial Balance: " + myAccount.getBalance());

        myAccount.deposit(100.0);
        System.out.println("Balance after deposit: " + myAccount.getBalance());

        myAccount.withdraw(50.0);
        System.out.println("Balance after withdrawal: " + myAccount.getBalance());

        myAccount.lockAccount();
        myAccount.withdraw(100.0);

        myAccount.unlockAccount();
        myAccount.withdraw(50.0);
    }
    // it just provides the methods to lock and unlock the account, the implementation of how to lock and unlock the 
    //account should be done in a separate class or system.
}
