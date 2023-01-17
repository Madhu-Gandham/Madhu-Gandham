package com.java.Demo;

class human{
	
	//instance variables
	String name;
	int age;
	
	//instance methods
	void talk() {
		System.out.println(name+ " is talking");
		
	}
	
	void walk() {
		System.out.println(name+ "is walking");
	}
}

//driver class

class ObjEx1{
	public static void main(String[] args) {
		
		//creating a santhosh object
		human santhosh = new human();
		
		santhosh.name="santhosh raju";
		santhosh.age=35;
		
		santhosh.talk();
		santhosh.walk();
		
		human madhu = new human();
		madhu.name="madhu narasimha";
		 madhu.age=21;
		 madhu.talk();
		 madhu.walk();
		
		
		
	}
}