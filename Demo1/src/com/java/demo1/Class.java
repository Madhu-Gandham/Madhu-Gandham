package com.java.demo1;

class Peerson
{                           
    // Instance variables, describes state/properties of object of this class.
    String name;
    int age;
    int height;         
    // methods, describes behaviors of object of this class.
    public void walk() {
         System.out.println("Hi my name is : "+name+", age : "+age+" year,"
         +" height : "+height+" cm. I can Walk");
       }
    public void talk() {
         System.out.println("Hi my name is : "+name+", age : "+age+" year,"
         +" height : "+height+" cm. I can Talk");
       }                    
}
   
class Class
{
public static void main(String [] args)
    {                   
       Peerson p1 = new Peerson(); // Creating object of class Person
       p1.name = "Rahul";
       p1.age = 20;
       p1.height = 170;
       p1.walk();
       p1.talk();          
    }
}