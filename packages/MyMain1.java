package com.java.packages;

import java.util.*;

public class MyMain1 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("Hello");
        myList.add("World");
        System.out.println(myList);
    }
}
//In this example, all the classes and interfaces from the java.util package are imported using the * wildcard. This allows the ArrayList class to be used in the MyMain class without having to specify the full package name or import the class specifically