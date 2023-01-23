package com.java.packages;

import java.util.ArrayList;

//In this example, the java.util.ArrayList package is imported using the import keyword. 
//This allows the ArrayList class to be used in the MyMain class without having to specify the full package name.

/*public class MyMain {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Hello");
        myList.add("World");
        System.out.println(myList);
    }
}*/

public class MyMain {
    public static void main(String[] args) {
        java.util.ArrayList<String> myList = new java.util.ArrayList<String>();
        myList.add("Hello");
        myList.add("World");
        System.out.println(myList);
    }
}
//In this example, the ArrayList class is accessed using its fully qualified class name java.util.ArrayList.
//This is useful if you want to use a class from a package that has the same name as a class in another package.

