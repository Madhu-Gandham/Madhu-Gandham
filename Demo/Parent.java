package com.java.Demo;

class Type {
    public static void main(String[] args) {
        // Implicit type casting
        int myInt = 5;
        long myLong = myInt; // automatically cast int to long
        System.out.println("Implicit casting from int to long: " + myLong);

        // Explicit type casting
        double myDouble = 5.5;
        int myInt2 = (int) myDouble; // explicitly cast double to int
        System.out.println("Explicit casting from double to int: " + myInt2);

        // Upcasting (Child class to Parent class)
        Child child = new Child();
        Parent parent = child; // upcasting 
        System.out.println("Upcasting from Child to Parent: " + parent.getClass().getName());

        // Downcasting (Parent class to Child class)
        Parent parent2 = new Child();
        if(parent2 instanceof Child){
            Child child2 = (Child) parent2; // downcasting 
            System.out.println("Downcasting from Parent to Child: " + child2.getClass().getName());
        }else{
            System.out.println("Downcasting not possible because parent2 is not an instance of Child class.");
        }
    }
}

class Parent { }

class Child extends Parent { }
