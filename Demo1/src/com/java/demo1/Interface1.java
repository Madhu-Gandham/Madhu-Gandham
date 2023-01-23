package com.java.demo1;

interface MotorVehicle { //The MotorVehicle interface defines two methods start() and stop()
	    //                    These methods do not have any implementation, they only specify the signature of the method.
    void start();
    void stop();
}

class Carr implements MotorVehicle { //The Car and Motorcycle classes both implement the Vehicle interface.
    // the car two instance variable make and model
    private String make;
    private String model;

    // And then constructor instiliazes these varibles
    public Carr(String make, String model) {
        this.make = make;
        this.model = model;
    }

    // methods from Vehicle interface
    public void start() {
        System.out.println(make + " " + model + " started.");
    }

    public void stop() {
        System.out.println(make + " " + model + " stopped.");
    }
}

class Motorcycle implements MotorVehicle {
    // instance variable
    private String make;
    private String model;

    // constructor
    public Motorcycle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    // methods from Vehicle interface
    public void start() {
        System.out.println(make + " " + model + " started.");
    }

    public void stop() {
        System.out.println(make + " " + model + " stopped.");
    }
}

public class Interface1 {
    public static void main(String[] args) {
    	MotorVehicle car = new Carr("Toyota", "Camry");
        car.start();
        car.stop();

        MotorVehicle motorcycle = new Motorcycle("Harley", "Davidson");
        motorcycle.start();
        motorcycle.stop();
    }
}
