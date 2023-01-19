package com.java.Demo;
 class Test12 {
	String cardName;
	long cardNumber;
	int cvv;
	String name,expDate;
	double balance;
	void swipe() {
		System.out.println("Swipe the card");
	}

}
class CreditCard extends Test12{
	int creditLimit;
	void payBill() {
		System.out.println("pay credit card bill");
	}
	
}
class debitCard extends Test1{
	int balance;
	
}
class Test1{    
	public static void main(String[] args) {
		CreditCard cc = new CreditCard();
		cc.creditLimit=657654754;
	
		cc.balance=876876;
		cc.cardName="Madhu Narasimha Gandham";
		cc.creditLimit=1000000;
		cc.cvv=272;
		cc.expDate="12/23";
		cc.cardNumber=520101259830671L;
		
		cc.swipe();
		cc.payBill();
		
		
		
	}
}


