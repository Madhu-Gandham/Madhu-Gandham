package com.java.Demo;

public class MethodsExample {
	//creating a method
	//creating a methods
	public int addNumbers(int x , int y) {
		int addition = x + y;
		//returning the value
		return addition;
				
	}
	public static void main(String[] args) {
		int x=10;
		int y=25;
		// creating an object of example class
		MethodsExample obj = new MethodsExample();
		//calling the method
		//int result = obj.addNumbers(x, y);           //user defined methods
		//System.out.println("sum of x+y = " +result);
		System.out.println("max of x&y = " +Math.max(10, 25));//predefined methods
	}

}

  