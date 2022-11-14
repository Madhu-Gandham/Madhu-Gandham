package com.java.ejb;

import java.sql.SQLException;
import java.util.Scanner;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SearchDriver {
	
	public static void main(String[] args) throws NamingException, ClassNotFoundException, SQLException {
		int driverId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter DriverId  ");
		driverId = sc.nextInt();
		   CabBookingRemote service = null;
		    service = (CabBookingRemote)
		    		new InitialContext().lookup("CabBooking/remote");
		Driver driver = service.searchDriverBean(driverId);
		if (driver!=null) {
			System.out.println(driver);
		}
	}
}