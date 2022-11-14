package com.java.ejb;

import java.sql.SQLException;
import java.util.Scanner;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class SerachUser {
	

		
		
		public static void main(String[] args) throws NamingException, ClassNotFoundException, SQLException {
			int userId;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter UserId  ");
			userId = sc.nextInt();
			   CabBookingRemote service = null;
			    service = (CabBookingRemote)
			    		new InitialContext().lookup("CabBooking/remote");
			User user = service.searchUserBean(userId);
			if (user!=null) {
				System.out.println(user);
			}

	
	}

}