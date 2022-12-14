package com.infinite.can;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
@ManagedBean(name="vendorDAO")
@SessionScoped
public class VendorDAO {
	SessionFactory sessionFactory;
	Session session;

	public String generateVendorID() {

		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Vendor.class);
		List<Vendor> vendorlist = cr.list();
		session.close();

		if (vendorlist.size() == 0) {
			return "V001";
		} else {
			String id = vendorlist.get(vendorlist.size() - 1).getVend_id();
			int id1 = Integer.parseInt(id.substring(1));
			id1++;
			String id2 = String.format("V%03d", id1);
			return id2;
		}
	}

	public void validatePhnNo(FacesContext context, UIComponent comp,
			Object value) {

		System.out.println("inside validate method");

		String mno = (String) value;
		boolean flag=false;
		if (mno.matches("\\d{10}"))  
		{ flag=true;}
		
	      if(flag==false) {
	    	  ((UIInput) comp).setValid(false);

				FacesMessage message = new FacesMessage(
						"invalid PhnNo");
				context.addMessage(comp.getClientId(context), message); 
	      }
		
	

	}
	
	public void validatePassword(FacesContext context, UIComponent comp,
			Object value) {

		System.out.println("inside validate method");

		String mno = (String) value;
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
	      boolean result=mno.matches(pattern);
	      if(result==false) {
	    	  ((UIInput) comp).setValid(false);

				FacesMessage message = new FacesMessage(
						"invalid Password");
				context.addMessage(comp.getClientId(context), message); 
	      }
		
	

	}
	public void validateEmail(FacesContext context, UIComponent comp,
			Object value) {

		System.out.println("inside validate method");

		String mno = (String) value;
		if (mno.indexOf('@')==-1) {
			((UIInput) comp).setValid(false);

			FacesMessage message = new FacesMessage(
					"invalid Email");
			context.addMessage(comp.getClientId(context), message);
		}
		if (mno.length() < 6) {
			((UIInput) comp).setValid(false);

			FacesMessage message = new FacesMessage(
					"Minimum length of model number is 6");
			context.addMessage(comp.getClientId(context), message);

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

	public List<Vendor> showVendor() {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Vendor.class);
		cr.setProjection(Projections.property("vend_id"));
		List<Vendor> vendorlist = cr.list();
		return vendorlist;

	}

	public String addVendor(Vendor vendor) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		String vendId = generateVendorID();
		vendor.setVend_id(vendId);
		Criteria cr = session.createCriteria(Vendor.class);
		Transaction tran = session.beginTransaction();
		session.save(vendor);
		tran.commit();
		return "vendor Added successfully";

	}

	public String validate(Vendor vendor) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Vendor.class);
		cr.add(Restrictions.eq("vend_userName", vendor.getVend_userName()));
		cr.add(Restrictions.eq("vend_password", vendor.getVend_password()));
		List<Vendor> vendorlist = cr.list();
		 FacesContext context=FacesContext.getCurrentInstance();
	        ExternalContext externalContext=context.getExternalContext();
        if(vendorlist.size()==1) {
        	externalContext.getSessionMap().put("vend_userName",vendor.getVend_userName());
            return "VDashboard.jsp";
        }else {
            return "Login.xhtml?faces-redirect=true";
        }
	}

	public Vendor searchByName(String userName) {

		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Vendor.class);
		cr.add(Restrictions.eq("vend_userName", userName));
		List<Vendor> vendorlist = cr.list();
		return vendorlist.get(0);
	}

	public List<OrderDetails> searchVendorId(String vendorId) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery(
						"from OrderDetails where vendorId=:vendorId AND status=:status " + "AND address is NOT NULL")
				.setParameter("vendorId", vendorId).setParameter("status", Status.ACCEPTED);
		List<OrderDetails> orderList = query.list();
		return orderList;
	}

	public List<OrderDetails> searchVendorPendingOrder(String vendorId) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery("from OrderDetails where vendorId=:vendorId AND status=:status OR status=:status1 "
						+ "AND address is NOT NULL")
				.setParameter("vendorId", vendorId).setParameter("status", Status.OUTFORPICKUP)
				.setParameter("status1", Status.OUTFORDELIVERY);
		List<OrderDetails> orderList = query.list();
		return orderList;
	}

	public List<OrderDetails> searchVendorHistoryOrder(String vendorId) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery(
						"from OrderDetails where vendorId=:vendorId AND status=:status " + "AND address is NOT NULL")
				.setParameter("vendorId", vendorId).setParameter("status", Status.DELIVERED);
		List<OrderDetails> orderList = query.list();
		return orderList;
	}

	public OrderDetails searchOrderId(String orderId) {
		sessionFactory = SessionHelper.getConnection();
		session = sessionFactory.openSession();
//		 Criteria cr=session.createCriteria(OrderDetails.class);
//		 Criterion criterion1=Restrictions.eq("orderId", orderId);
//		 Criterion criterion2=Restrictions.eq("status", Status.ACCEPTED);
//		 cr.add(Restrictions.and(criterion1, criterion2));
		Query query = session.createQuery(
				"from OrderDetails where orderId=:orderId AND status=:status OR status=:status1 OR status=:status2 "
						+ "AND address is NOT NULL")
				.setParameter("orderId", orderId).setParameter("status", Status.ACCEPTED)
				.setParameter("status1", Status.OUTFORPICKUP).setParameter("status2", Status.OUTFORDELIVERY);
		List<OrderDetails> orderList = query.list();

		return orderList.get(0);
	}
}