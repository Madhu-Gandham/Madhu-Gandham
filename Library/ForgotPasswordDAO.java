package com.infinite.Library;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.infinite.Library.SessionHelper;

public class ForgotPasswordDAO {

	public static boolean isUserExist(String username) {
		SessionFactory SessionFactory = SessionHelper.getConnection();
		Session session = SessionFactory.openSession();
		long count = (long) session.createQuery("SELECT COUNT(*) FROM LibUsers WHERE userName = :username")
				.setParameter("username", username).uniqueResult();
		session.close();
		return count == 1;
	}

	public static String resetPassword(String username, String password) {
	    try {
	        Session session = SessionHelper.getConnection().openSession();
	        Transaction transaction = session.beginTransaction();

	        LibUsers user = (LibUsers) session.createQuery("FROM LibUsers WHERE userName = :username")
	                .setParameter("username", username).uniqueResult();
	        LibraryDAO dao = new LibraryDAO();
//	        dao.doHasing(password);
	        user.setPassword(dao.doHasing(password));
	        session.update(user);
	        transaction.commit();
	        session.close();
	        return "Changed Successfully";
	    } catch (Exception e) {
	        // Handle the exception
	        e.printStackTrace();
	        return "Error: Failed to reset password";
	    }
	}

	public static boolean isSecurityAnswerCorrect(String username, String securityQuestion, String answers) {
	    try {
	        Session session = SessionHelper.getConnection().openSession();
	        Transaction transaction = session.beginTransaction();

	        LibUsers user = (LibUsers) session.createQuery("FROM LibUsers WHERE userName = :username")
	                .setParameter("username", username)
	                .uniqueResult();

	        boolean isCorrect = user != null && user.getSecurityQuestion().equals(securityQuestion)
	                && user.getAnswers().equals(answers);

	        transaction.commit();
	        session.close();

	        return isCorrect;
	    } catch (Exception e) {
	        e.printStackTrace();                     
	        return false;
	    }
	}
}

