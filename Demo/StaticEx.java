package com.java.Demo;
class Javaclass{
	String name; //instance variable
	void listen() { //instance method
		System.out.println(name+ " is listening the class");
	}
	static String board; //static variable
	static void teaching() {  //static method
		System.out.println("santhosh is listening the concept");
	}
}

public class StaticEx {
	public static void main(String[] args) {
		Javaclass santhosh = new Javaclass();
		santhosh.name = "santhosh Raju";
		santhosh.listen();
		Javaclass.board = "white";
		Javaclass.teaching();
		
	}

}
