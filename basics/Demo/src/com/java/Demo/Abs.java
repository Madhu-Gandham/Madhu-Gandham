package com.java.Demo;
//Demonstarte the example of Abstraction with real time example

abstract class Shapes { //In this example, the Shape class is an abstract class that contains 
	//an abstract method draw().
    public abstract void draw();
}
//The Circle and Square classes extend the Shape class and provide an
//implementation for the draw() method.
class Circles extends Shapes {
    public void draw() { //draw method on each shape, without knowing the implementation details:


        System.out.println("Drawing a Circle");
    }
}

class Square extends Shapes {
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

class Rectangles extends Shapes {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

public class Abs {
    public static void main(String[] args) {
        Shapes[] shapes = new Shapes[3];
        shapes[0] = new Circles();
        shapes[1] = new Square();
        shapes[2] = new Rectangles();
        
        for (Shapes shape : shapes) {
            shape.draw();
        }
    }
}
// The Circle and Square classes extend the Shape class and provide an
//implementation for the draw() method.
//the main method doesn't need to know the implementation of the draw() method of each shape, it 
//just calls the method on each object, and the object takes care of the implementation. This is an 

//example of abstraction in Java, where the main method is abstracted away from the implementation
//details of the draw() method.