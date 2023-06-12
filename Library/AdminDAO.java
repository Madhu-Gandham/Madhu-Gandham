package com.infinite.Library;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Date;
import java.time.LocalDate;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name="AdminDAO")
@SessionScoped
@RequestScoped

public class AdminDAO {
	SessionFactory sessionFactory;
	private static Logger logger=LogManager.getLogger(AdminDAO.class);
	public String addadmin(String firstname, String phn_num, String username,String password,java.util.Date dob,String email
			) {
	
	    try {
	        sessionFactory = SessionHelper.getConnection();
	        Session session = sessionFactory.openSession();
	        FacesContext context = FacesContext.getCurrentInstance();
	        boolean validUser = AdminDAO.isUserExist(username);
	        if (validUser) {
	           
	            context.addMessage("cregfrm:username", new FacesMessage("Username already exists."));
	            return "success";
	        } else {
	            Admin user = new Admin();
	            user.setfirstname(firstname);
	            user.setPhn_num(phn_num);
	            user.setUsername(username);
	            user.setPassword(password);
	            user.setDob(dob);
	            user.setEmail(email);
	            user.setPassword(doHasing(password));
	            org.hibernate.Transaction tran = session.beginTransaction();
	            session.save(user);
	            tran.commit();
	            logger.info("User details saved successfully: " + username);
	            context.addMessage("cregfrm", new FacesMessage("Details saved successfully"));
	            ExternalContext externalContext = context.getExternalContext();
	            externalContext.redirect(externalContext.getRequestContextPath() + "/login1.jsp");
	            return "Details Saved Successfully";
	        }
	    } catch (NoSuchAlgorithmException e) {
//	        logger.severe("NoSuchAlgorithmException occurred: " + e.getMessage());
	    	logger.error("Error",e);
	        e.printStackTrace();
	        return "Error: NoSuchAlgorithmException";
	    } catch (IOException e) {
//	        logger.severe("IOException occurred: " + e.getMessage());
	        e.printStackTrace();
	        return "Error: IOException";
	    }
	}
	

	public int loginCheck(String username, String password) {
	    try {
	        sessionFactory = SessionHelper.getConnection();
	        Session session = sessionFactory.openSession();
	        Criteria criteria = session.createCriteria(Admin.class);
	        criteria.add(Restrictions.eq("username", username));
	        criteria.add(Restrictions.eq("password", doHasing(password)));
	        List<Admin> listUsers = criteria.list();
	        session.close();
	        return listUsers.size();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}


	
	public String doHasing(String Password) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(Password.getBytes());
		byte[] npss = messageDigest.digest();
		StringBuilder sb = new StringBuilder();
		for (byte b : npss) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}
	public static String resetPassword(String username, String password) throws NoSuchAlgorithmException {
		Session session = SessionHelper.getConnection().openSession();
		Transaction transaction = session.beginTransaction();

		Admin user = (Admin) session.createQuery("FROM Admin WHERE username = :username")
				.setParameter("username", username).uniqueResult();
		AdminDAO dao = new AdminDAO();
		user.setPassword(dao.doHasing(password));

		session.update(user);
		transaction.commit();
		session.close();
		return "Changed Succesfully";
	}
	public static boolean isUserExist(String username) {
		SessionFactory SessionFactory = SessionHelper.getConnection();
		Session session = SessionFactory.openSession();
		long count = (long) session.createQuery("SELECT COUNT(*) FROM Admin WHERE username = :username")
				.setParameter("username", username).uniqueResult();
		session.close();
		return count == 1;
	}
	public void validateEmail(FacesContext context, UIComponent comp, Object value) {
	    String email = (String) value;
	    Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{6,}@(gmail|yahoo)\\.(com|org|cc)$"
	    		+ "");
	    Matcher matcher = pattern.matcher(email);
	    if (!matcher.matches()) {
	        ((UIInput) comp).setValid(false);
	        FacesMessage message = new FacesMessage("It contains at least 7 Charcters long and It will be accept gmail and yahoo, @Symbol extension with .com,.org,.cc");
	        context.addMessage(comp.getClientId(context), message);
	    } 
	}
}

