package com.java.Demo;
//Demonstarte the concept of overloading and overriding
//methodoverloading
class Calculatorr { //Here Calculator has 3methods samename 
    public int add(int a, int b) {
        return a + b;
    } //No Need Of Inheritance
    public double add(double a, double b) {
        return a + b;
    }
    public float add(float a, float b) {
        return a + b;
    }
}
//Here, we are calling the method of parent class with child  
class AdvancedCalculatorr extends Calculatorr{
    public int add(int a, int b, int c) {     //same name same parameters And logic muust be different
        return a + b + c;
    }
    public double add(double a, double b, double c) {
        return a + b + c;
    }
   
    public float add(float a, float b) {
        return (a + b)*2;
    }
}

public class Overrilo {
    public static void main(String[] args) {
        Calculatorr calculatorr = new Calculatorr();
        System.out.println("Addition of two integers: " + calculatorr.add(5,10));
        System.out.println("Addition of two double: " + calculatorr.add(5.5,10.5));
        System.out.println("Addition of two float: " + calculatorr.add(5.5f,10.5f));

        AdvancedCalculatorr advancedCalculator = new AdvancedCalculatorr();
        System.out.println("Addition of three integers: " + advancedCalculator.add(5,10,15));
        System.out.println("Addition of three double: " + advancedCalculator.add(5.5,10.5,15.5));
        System.out.println("Addition of two float: " + advancedCalculator.add(5.5f,10.5f));
    }
}
