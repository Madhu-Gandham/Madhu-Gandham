package com.java.Demo;
public class WrapperClassExample {
    public static void main(String[] args) {
        Integer num1 = 10;//In this example, autoboxing is used when initializing the num1 and num2 
         //variables with primitive int values.
        //The JVM automatically converts these values to the corresponding wrapper class Integer without the need to explicitly
        //use the new keyword
        Integer num2 = 20;

        Integer sum = num1 + num2;
        Integer difference = num1 - num2;
        Integer product = num1 * num2;
        Double quotient = (double) num1 / num2;

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);

        if (sum > difference) {
            System.out.println("Sum is greater than difference.");
        } else {
            System.out.println("Difference is greater than sum.");
        }

        int parsedNum = Integer.parseInt("100");
        System.out.println("Parsed Integer: " + parsedNum);
    }
}
//The JVM automatically converts these values to the corresponding wrapper class Integer without the need to explicitly use
//the new keyword
