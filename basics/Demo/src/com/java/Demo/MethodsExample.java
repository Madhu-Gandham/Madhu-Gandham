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
		int i=10;
		int j=25;
		// creating an object of example class
		MethodsExample obj = new MethodsExample();
		//calling the method
		int result = obj.addNumbers(i, j);
		System.out.println("sum of x+y = " +result);
	}

}

  