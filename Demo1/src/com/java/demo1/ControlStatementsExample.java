package com.java.demo1;

public class ControlStatementsExample {
    public static void main(String[] args) {
        // Conditional statement example
        int x = 5;
        if (x > 0) {
            System.out.println("x is positive");
        } else {
            System.out.println("x is not positive");
        }
        
        // Looping statement example
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello");
        }
        
        // Jump statement example
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                break;
            }
            System.out.println("i: " + i);
        }
        
        // Enhanced for loop example
        int[] numbers = {1, 2, 3, 4, 5};
        for (int num : numbers) {
            System.out.println(num);
        }
        
        // Method that uses return statement
        int sum = sum(3, 4);
        System.out.println("The sum is: " + sum);
    }
    
    public static int sum(int a, int b) {
        return a + b;
    }
}
