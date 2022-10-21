package com.infinte.day1;

public class Circle {
	public void calc(double radius){
		double area,Circumference;
		area = 3.14*radius*radius;
		Circumference = 2*3.14*radius;
		System.out.println("Area of circle "  +area);
		System.out.println("circumference  "+Circumference);
	}
	public static void main(String[] args) {
		double radius=8.7;
		Circle obj = new Circle();
		obj.calc(radius);
		
	}

}
