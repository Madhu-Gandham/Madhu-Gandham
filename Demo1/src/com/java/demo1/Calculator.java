package com.java.demo1;
 //Demostarte the example of operators
public class Calculator {
    public static void main(String[] args) {
        double num1 = 10.5;
        double num2 = 3.2;
        
        // Using the + operator to add two numbers
        double sum = num1 + num2;
        System.out.println("The sum of " + num1 + " and " + num2 + " is " + sum);
        
        // Using the - operator to subtract two numbers
        double difference = num1 - num2;
        System.out.println("The difference between " + num1 + " and " + num2 + " is " + difference);
        
        // Using the * operator to multiply two numbers
        double product = num1 * num2;
        System.out.println("The product of " + num1 + " and " + num2 + " is " + product);
        
        // Using the / operator to divide two numbers
        double quotient = num1 / num2;
        System.out.println("The quotient of " + num1 + " and " + num2 + " is " + quotient);
        
        // Using the % operator to find the remainder
        double remainder = num1 % num2;
        System.out.println("The remainder of " + num1 + " divided by " + num2 + " is " + remainder);
        
        // Using the ++ and -- operators to increment and decrement a variable
        int counter = 0;
        System.out.println("Counter: " + counter);
        counter++;
        System.out.println("Counter: " + counter);
        counter--;
        System.out.println("Counter: " + counter);
        
        // Using the +=, -=, *=, and /= operators to update a variable
        double balance = 100.0;
        balance += 25.0; // balance = balance + 25.0
        System.out.println("New balance: " + balance);
        balance -= 50.0; // balance = balance - 50.0
        System.out.println("New balance: " + balance);
        balance *= 1.1; // balance = balance * 1.1
        System.out.println("New balance: " + balance);
        balance /= 2; // balance = balance / 2
        System.out.println("New balance: " + balance);
    }
}
