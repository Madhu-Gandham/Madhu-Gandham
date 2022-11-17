package com.infinite.can;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class VendorDAO {
	SessionFactory sessionFactory;
	Session session;
public String generateVendorID() {
		
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Vendor.class);
		List<Vendor> vendorlist = cr.list();
		session.close();
		
		if(vendorlist.size()==0) {
			return "V001";
	  	}
		else {
		String id = vendorlist.get(vendorlist.size()-1).getVend_id();
		int id1 = Integer.parseInt(id.substring(1));
		id1++;
		String id2 = String.format("V%03d", id1);
		return id2;
		}
	}

    public Vendor searchVendor(String vend_id) {
	sessionFactory = SessionHelper.getConnection();
	Session session = sessionFactory.openSession();
	Criteria cr = session.createCriteria(Vendor.class);
	cr.add(Restrictions.eq("vend_id", vend_id));
	List<Vendor> vendorlist = cr.list();
	return vendorlist.get(0);
}
    public List<Vendor> showVendor(){
    	sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Vendor.class);
		Projection projection=Projections.property("vend_id");
		cr.setProjection(projection);
		List<Vendor> vendorlist= cr.list();
		return vendorlist;
    	
    }

    public String addVendor(Vendor vendor) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		String vendId=generateVendorID();
		vendor.setVend_id(vendId);
		Criteria cr = session.createCriteria(Vendor.class);
		Transaction tran = session.beginTransaction();
		session.save(vendor);
		tran.commit();
		return "vendor Added successfully";
		
	}

        
    public int validate(String userName, String password) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
	    Criteria cr = session.createCriteria(Vendor.class);
	    cr.add(Restrictions.eq("vend_userName", userName));
	    cr.add(Restrictions.eq("vend_password", password));
	    List<Restaurant> listres = cr.list();
	    return listres.size();
	}
}