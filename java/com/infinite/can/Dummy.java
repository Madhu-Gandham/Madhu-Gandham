package com.infinite.can;


public class Dummy {

	public static void main(String[] args) {
		OrderDeatilsDAO dao=new OrderDeatilsDAO();
		OrderDetails order=new OrderDetails();
	//	WalletDAO dao=new WalletDAO();
		System.out.println(dao.walletAmount("C002",Type.PAYTM));
	}

}
