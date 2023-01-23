package com.java.packages;


 class Car {             //make model year price they can access only within the methods are declared as private.Within the car class
    private String make;
    private String model;
    private int year;
    protected double price; //The price field is declared as protected, this means that it can be accessed by classes within the
                             //same package, and by subclasses in other packages.
    public int speed; //The speed field is declared as public, this means that it can be accessed by any class.

    public Car(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.speed = 0;
    }

    public void start() {
        System.out.println("Car started.");
    }

    public void stop() {
        System.out.println("Car stopped.");
    }
    
    protected void setPrice(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return this.price;
    }
    public String getMake() {
        return this.make;
    }
    public String getModel() {
        return this.model;
    }
    public int getYear() {
        return this.year;
    }
}

public class Modifiers {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry", 2020, 30000);
        car.start();
        car.speed = 55;
        System.out.println("Car Make: " + car.getMake());
        System.out.println("Car Model: " + car.getModel());
        System.out.println("Car Year: " + car.getYear());
        System.out.println("Car Price: " + car.getPrice());
        car.stop();
    }
}

//By using access modifiers in this way, we can ensure that the internal state of the Car class is protected and can
  //only be accessed or modified in a controlled manner.



