package com.java.Demo;
class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat() {
        System.out.println("Animal eat food");
    }
}

class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void bark() {
        System.out.println("Dogs can bark");
    }

    @Override
    public void eat() {
        System.out.println("Dogs eat dog food");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Animal animal = new Animal("Lion", 5);
        animal.eat();
        Dog dog = new Dog("Poodle", 2, "Poodle");
        dog.eat();
        dog.bark();
    }
}
