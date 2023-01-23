package com.java.Demo;
//Demponstarte the example of Widening of Automatic conversion
public class TypeCating {
	public static void main(String[] args) {
		int i = 100;
		//automatic type conversion
		long l = i;
		//automatic type conversion
		float f = l;
		System.out.println("Int value " +i);
		System.out.println("Long value "+l);
		System.out.println("Float value "+f);
	}

}
