package com.java.Demo;

class Animl { //its a super class of all classes that has common weight and name
    private String name;//instance variables
    private double weight;//instance variables
    public Animl(String name, double weight) { //constructor has name and weight
        this.name = name;
        this.weight = weight;
    }
    public String getName() {
        return name;  //two public methods get name and get weight
    }
    public double getWeight() {
        return weight;
    }
}

class Lion extends Animl {
    private String maneColor;
    public Lion(String name, double weight, String maneColor) {
        super(name, weight); //super() method to call the superclass constructor and initialize the name and 
                                //weight inherited from the Animals class.
        this.maneColor = maneColor;
    }
    public String getManeColor() {
        return maneColor;
    }
}

class Elephant extends Animl {
    private double trunkLength;
    public Elephant(String name, double weight, double trunkLength) {
        super(name, weight);
        this.trunkLength = trunkLength;
    }
    public double getTrunkLength() {
        return trunkLength;
    }
}

class Monkey extends Animl {
    private double tailLength;
    public Monkey(String name, double weight, double tailLength) {
        super(name, weight);
        this.tailLength = tailLength;
    }
    public double getTailLength() {
        return tailLength;
    }
}

public class pillar { //main method creates a lion elephant and monkey
    public static void main(String[] args) {
        Lion lion = new Lion("Simba", 200, "Gold");
        Elephant elephant = new Elephant("Dumbo", 1000, 10);
        Monkey monkey = new Monkey("George", 50, 20);
        System.out.println("Lion's Name: " + lion.getName());
        System.out.println("Lion's Weight: " + lion.getWeight());
        System.out.println("Lion's Mane Color: " + lion.getManeColor());
        System.out.println("Elephant's Name: " + elephant.getName());
        System.out.println("Elephant's Weight: " + elephant.getWeight());
        System.out.println("Elephant's Trunk Length: " + elephant.getTrunkLength());
        System.out.println("Monkey's Name: " + monkey.getName());
        
    }
}

//Each class has its own private instance variable and public method to retrieve the value of this variable.   
