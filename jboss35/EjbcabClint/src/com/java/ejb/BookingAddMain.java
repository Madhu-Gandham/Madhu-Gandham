package com.java.ejb;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class BookingAddMain {
	
	public static void main(String[] args) throws NamingException, ClassNotFoundException, SQLException {
		Scanner sc  = new Scanner(System.in);
		Booking book = new Booking();
		 System.out.println("Enter Booking Date(yyyy-MM-dd)");
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
				Date bookDate;
				try {
					bookDate = sdf.parse(sc.next());
					java.sql.Date date = new java.sql.Date(bookDate.getTime());
					book.setBookingDate(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		System.out.println("Enter DriverId ");
		book.setDriverId(sc.nextInt());
		System.out.println("Enter UserId ");
		book.setUserId(sc.nextInt());
		System.out.println("enter Startinglocation  ");
		book.setStartingLocation(sc.next());
		System.out.println("Enter Endinglocation ");
		book.setEndingLocation(sc.next());
		System.out.println("Enter kilometers");
		book.setKilometers(sc.nextDouble());
	    System.out.println("Enter BookingStatus ");
		book.setBookingStatus(Status.valueOf(sc.next()));
	//	System.out.println("Enter Billing Amount");
		
		double b=book.getKilometers();
		final double c= 60.0;
		double billamount=b*c;
		book.setBillAmount(billamount);

		
		CabBookingRemote service = null;
	    service = (CabBookingRemote)
	    		new InitialContext().lookup("CabBooking/remote");
	    System.out.println(service.addBooking(book));
	   // System.out.println(service.addBookingBean(book));
		
		
	}

}