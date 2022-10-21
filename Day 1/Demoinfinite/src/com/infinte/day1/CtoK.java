package com.infinte.day1;

public class CtoK {
	public void calc(double c){
		double k = c+273;
		System.out.println("Kelvin valve "+k);
	}
	public static void main(String[] args) {
		double c=37;
		CtoK obj = new CtoK();
		obj.calc(c);
		
	}

}
