package com.infinte.day1;

public class  CaseExample {
	public void show(int n){
	switch(n){
	case 1 :
		System.out.println("hi i am madhu");
		break;
	case 2:
		System.out.println("hi i am pradeep");
		break;
	case 3:
		System.out.println("hi i am vardhil");
		break;
	case 4:
		System.out.println("hi i am ramul");
		break;
	case 5:
		System.out.println("hi i am maruti");
		break;
	case 6:
		System.out.println("hi i am pandu");
		break;
	default :
		System.out.println("Invalid Choice");
	}
	}
	public static void main(String[] args) {
		int n=4;
		CaseExample obj = new CaseExample();
		obj.show(n);
	}

}
