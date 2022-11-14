package com.java.ejb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class CabDAO {
	
	Connection connection;
	PreparedStatement pst;
	
	
	//searchUser
	public User searchUser(int userId) throws ClassNotFoundException, SQLException{
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from userdetails where userId = ?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, userId);
		ResultSet rs = pst.executeQuery();
		User user = null;
		if(rs.next()){
			user = new User();
			user.setUserId(rs.getInt("userId"));
			user.setUserName(rs.getString("userName"));
			user.setPasscode(rs.getString("passcode"));
			user.setFirstName(rs.getString("firstName"));
			user.setLastName(rs.getString("lastName"));
			user.setCity(rs.getString("city"));
			user.setState(rs.getString("state"));
			user.setMobile(rs.getString("mobile"));
			user.setEmail(rs.getString("email"));
		}
		return user;
	}
	
	//Driver Search 
	
	public Driver searchDriver(int driverId) throws ClassNotFoundException, SQLException{
		 connection = ConnectionHelper.getConnection();
		 String cmd ="select * from driverdetails where driverId=?";
		 pst = connection.prepareStatement(cmd);
		 pst.setInt(1, driverId);
		 ResultSet rs = pst.executeQuery();
		 Driver driver = null;
		 if(rs.next()){
			 driver = new Driver();
				driver.setDriverId(rs.getInt("driverId"));
				driver.setDriverUserName(rs.getString("driverUserName"));
				driver.setDriverPassword(rs.getString("driverPassword"));
				driver.setDriverFirstName(rs.getString("driverFirstName"));
				driver.setDriverLastName(rs.getString("driverLastName"));
				driver.setDriverCity(rs.getString("driverCity"));
				driver.setDriverState(rs.getString("driverState"));
				driver.setDriverMobile(rs.getString("driverMobile"));
				driver.setDriverEmail(rs.getString("driverEmail"));
				driver.setCabType(rs.getString("cabType"));
		 }
		return driver;
	}
	
	
	//ShowDriver
	
	public List<Driver> showDriver() throws ClassNotFoundException, SQLException{
		List<Driver>  driverlist = new ArrayList<Driver>();
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from driverdetails";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		Driver driver = null;
		while(rs.next())
		{
			driver = new Driver();
			driver.setDriverId(rs.getInt("driverId"));
			driver.setDriverUserName(rs.getString("driverUserName"));
			driver.setDriverPassword(rs.getString("driverPassword"));
			driver.setDriverFirstName(rs.getString("driverFirstName"));
			driver.setDriverLastName(rs.getString("driverLastName"));
			driver.setDriverCity(rs.getString("driverCity"));
			driver.setDriverState(rs.getString("driverState"));
			driver.setDriverMobile(rs.getString("driverMobile"));
			driver.setDriverEmail(rs.getString("driverEmail"));
			driver.setCabType(rs.getString("cabType"));
			driverlist.add(driver);
		}
		return driverlist;
		
	}

}