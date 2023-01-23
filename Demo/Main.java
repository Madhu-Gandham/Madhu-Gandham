package com.java.Demo;
//Demontsrate by using interface Example?
interface Payment {
    public void pay(double amount);
    public void refund(double amount);
    public boolean verify();
    
}

class Creditcard implements Payment {

    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public Creditcard(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using Credit Card");
    }

    public void refund(double amount) {
        System.out.println("Refunding $" + amount + " to Credit Card");
    }

    public boolean verify() {
        return true;
    }
}

class PayPal implements Payment {
    private String email;
    private String password;

    public PayPal(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void pay(double amount) {
        System.out.println("Paying $" + amount + " using PayPal");
    }

    public void refund(double amount) {
        System.out.println("Refunding $" + amount + " to PayPal");
    }

    public boolean verify() {
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        Payment cc = new Creditcard("1234567890", "10/22", "123");
        Payment paypal = new PayPal("example@gmail.com", "password");

        cc.pay(100.0);
        cc.refund(50.0);
        System.out.println(cc.verify());

        paypal.pay(100.0);
        paypal.refund(50.0);
        System.out.println(paypal.verify());
    }
}

