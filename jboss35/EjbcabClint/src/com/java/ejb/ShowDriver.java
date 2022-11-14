package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ShowDriver {
	
	public static void main(String[] args) throws NamingException, ClassNotFoundException, SQLException {
		CabBookingRemote service = null;

		    // Context compEnv = (Context) new InitialContext().lookup("java:comp/env");

		    // service = (HelloService)new
		    // InitialContext().lookup("java:comp/env/ejb/HelloService");
		    service = (CabBookingRemote)
		    		new InitialContext().lookup("CabBooking/remote");

		    List<Driver> driverlist = service.showDriverBean();
		    for (Driver driver : driverlist) {
		    	System.out.println(driver);
		    	
			}
	}

}