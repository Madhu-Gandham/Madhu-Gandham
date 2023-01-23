package com.java.demo1;

import java.util.Scanner; //importing the scanner class

public class BitwiseOR {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // creating a new scanner object
        System.out.print("Enter number of queries: ");
        int Q = input.nextInt(); // getting the number of queries
        int[] Quer = new int[Q]; // creating an array to store the queries
        
        System.out.print("Enter the queries: ");
        for (int i = 0; i < Q; i++) {
            Quer[i] = input.nextInt(); // getting the queries
        }
        
        int result = Quer[0]; // initializing the result with the first query
        for (int i = 1; i < Q; i++) {
            result = result | Quer[i]; // performing bitwise OR operation on the result and the current query
        }
        
        System.out.println("Result: " + result);
    }
}
