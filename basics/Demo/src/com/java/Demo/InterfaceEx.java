package com.java.Demo;
interface Shape {
	  double getArea(); //methods
	  double getPerimeter();//methods
	}

	class Rectangle implements Shape {
	  private double width;
	  private double height;

	  public Rectangle(double width, double height) {
		  //the rectangle impliments the Shape interface and provides an implementation 
		  //for the getArea and getPerimeter methods.
	    this.width = width;
	    this.height = height;
	  }

	  public double getArea() {
	    return width * height;
	  }

	  public double getPerimeter() {
	    return 2 * (width + height);
	  }
	}

	public class InterfaceEx {
	    public static void main(String[] args) {
	    Shape rect = new Rectangle(5, 10);
	    System.out.println("Area of rectangle: " + rect.getArea());
	    System.out.println("Perimeter of rectangle: " + rect.getPerimeter());
	    }
	}
