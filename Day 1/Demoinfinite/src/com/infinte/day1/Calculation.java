package com.infinte.day1;

public class Calculation {
	public void Calculation(int a,int b){
		int c=a+b;
		System.out.println("Sum is   "+c);
	}

	public static void main(String[] args) {
		int a,b;
		a=5;
		b=7;
		Calculation obj = new Calculation();
		obj.Calculation(a, b);

	}

}
