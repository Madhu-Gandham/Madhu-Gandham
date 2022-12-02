package com.java.ejb;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class CabBooking
 */
@Stateless
@Remote(CabBookingRemote.class)
public class CabBooking implements CabBookingRemote {

	
	static CabDAO edao;
	static {
		edao = new CabDAO();
	}
    /**
     * Default constructor. 
     */
    public CabBooking() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public User searchUserBean(int userId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return edao.serachUser(userId);
	}

	@Override
	public List<Driver> showDriverBean() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return edao.showDriver();
	}

	@Override
	public Driver searchDriverBean(int driverId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return edao.searchDriver(driverId);
	}

	@Override
	public String addBooking(Booking booking) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return edao.addBooking(booking);
	}

}