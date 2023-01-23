package com.java.Demo;
//Demonstarte the example of type casting in java(upcasting and downcasting)

class Robot { //Main Method Creating a objects like WheeledRobot flyingRobot SwimmingRobot and these objects passing them to move method
    public void move() {
        System.out.println("Robot moving...");
    }
}    //The WheeledRobot, FlyingRobot, and SwimmingRobot classes all inherit from the Robot class, so we can assign them to a Robot variable.
                         //This process of assigning a subclass object to a superclass variable is known as upcasting.
class WheeledRobot extends Robot {
    @Override
    public void move() {
        System.out.println("Wheeled robot moving on wheels...");
    }
    public void specialMove(){
        System.out.println("Wheeled robot doing special move...");
    }
}

class FlyingRobot extends Robot {
    @Override
    public void move() {
        System.out.println("Flying robot moving in the air...");
    }
}

class SwimmingRobot extends Robot {
    @Override
    public void move() {
        System.out.println("Swimming robot moving in the water...");
    }
}

class casting {
    public static void main(String[] args) {
        move(new WheeledRobot());
        move(new FlyingRobot()); //the move() method is being called on objects of the WheeledRobot, 
                                   //FlyingRobot, and SwimmingRobot classes. 
                  // upcasting, where objects of a subclass are being passed to a method that expects a superclass object.
        move(new SwimmingRobot());
        Robot robot = new WheeledRobot(); //the wheeled object is calling because specialmove() is only in Wheeledrobot
        specialMove(robot);
    }
    public static void move(Robot robot) {
        robot.move();
    }
    public static void specialMove(Robot robot){
        if(robot instanceof WheeledRobot){
            ((WheeledRobot) robot).specialMove();
        }else{
            System.out.println("Special move not possible, robot is not an instance");
        }
    }
}
//In the above example, the Robot object is being assigned to a WheeledRobot object by using casting operator (WheeledRobot) . 
//This process of converting a superclass object to a subclass object is known as downcasting.
//The line Robot robot = new WheeledRobot(); is a downcast because we are creating an object of type WheeledRobot and assign it to a
//variable of type Robot.

//However, It's not guaranteed that the Robot object is actually an instance of the WheeledRobot class, so the code uses an instanceof
//operator to check if the robot is of type WheeledRobot before calling the specialMove() method.