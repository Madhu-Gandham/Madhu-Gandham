package com.java.Demo;

class Rectagle {
    // instance variables
    private double length;
    private double width;

    // parameterized constructor
    public Rectagle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // default constructor
    public Rectagle() {
        this(1.0, 1.0);
    }

    // other methods
    public double getArea() {
        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }
}

public class Constructor {
    public static void main(String[] args) {
        Rectagle rect1 = new Rectagle(5.0, 6.0);
        System.out.println("Area of rect1: " + rect1.getArea());
        System.out.println("Perimeter of rect1: " + rect1.getPerimeter());

        Rectagle rect2 = new Rectagle();
        System.out.println("Area of rect2: " + rect2.getArea());
        System.out.println("Perimeter of rect2: " + rect2.getPerimeter());
    }
}
