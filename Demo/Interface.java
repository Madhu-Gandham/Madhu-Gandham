package com.java.Demo;

interface Vehicle {
	  void start();
	  void stop();
	}

	class Car implements Vehicle {
	  private boolean running;

	  public void start() {
	    running = true;
	    System.out.println("Car started");
	  }

	  public void stop() {
	    running = false;
	    System.out.println("Car stopped");
	  }
	}

	public class Interface {
	    public static void main(String[] args) {
	    Vehicle car = new Car();
	    car.start();
	    car.stop();
	    }
	}
	
	
	

	
	
