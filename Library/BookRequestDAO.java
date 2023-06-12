package com.infinite.Library;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;

@ManagedBean(name="BookRequestDAO")
@SessionScoped
@RequestScoped
public class BookRequestDAO {
	
    SessionFactory sessionFactory;
	private static Logger logger=LogManager.getLogger(BookRequestDAO.class);
    
	public String addUser(String teacherName, String bookTitle, String reason) throws NoSuchAlgorithmException, IOException {
	    sessionFactory = SessionHelper.getConnection();
	    Session session = sessionFactory.openSession();
	    FacesContext context = FacesContext.getCurrentInstance();
	    boolean validUser = ForgotPasswordDAO.isUserExist(teacherName);
	    
	    if (validUser) {
	        context.addMessage("cregfrm:userName", new FacesMessage("Teacher name already exists."));
	        return null;
	    } else {
	        BookRequest tt = new BookRequest();
	        tt.setTeacher_name(teacherName);
	        tt.setReason(reason);
	        tt.setBook_title(bookTitle);
	        org.hibernate.Transaction tran = session.beginTransaction();
	        session.save(tt);
	        tran.commit();
	        logger.info("User details saved successfully: " + teacherName);
	        
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Details saved successfully", null);
	        context.addMessage(null, message);
	        
	        // Redirect to another page after 30 seconds
	        String redirectScript = "setTimeout(function() { window.location.href = 'login1.jsp'; }, 30000);";
	        context.getExternalContext().getSessionMap().put("redirectScript", redirectScript);
	        
	        return null;
	    }
	}
	public static boolean isUserExist(String teacher_name) {
		SessionFactory SessionFactory = SessionHelper.getConnection();
		Session session = SessionFactory.openSession();
		long count = (long) session.createQuery("SELECT COUNT(*) FROM BookRequest WHERE teacher_name = :teacher_name")
				.setParameter("teacher_name", teacher_name).uniqueResult();
		session.close();
		return count == 1;
	}

    
    public void updateStatus(int id, String status) {
        try {
            sessionFactory = SessionHelper.getConnection();
            Session session = sessionFactory.openSession();

            // Retrieve the book request by ID
            BookRequest bookRequest = (BookRequest) session.get(BookRequest.class, id);

            if (bookRequest != null) {
                // Update the status
                bookRequest.setStatus(status);

                // Save the updated book request in the database
                Transaction transaction = session.beginTransaction();
                session.update(bookRequest);
                transaction.commit();

                session.close();

                // Show success message (optional)
                FacesContext facesContext = FacesContext.getCurrentInstance();
                facesContext.getExternalContext().getFlash().put("message", "Status updated successfully");
            } else {
                System.out.println("Book request not found in the database.");
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Custom error message or further error handling
        }
    }
    public List<BookRequest> getAllBookRequest() {
	    sessionFactory = SessionHelper.getConnection();
	    Session session = sessionFactory.openSession(); 
	    Criteria cr = session.createCriteria(BookRequest.class);
	    List<BookRequest> lst = cr.list();
	    return lst;
	}
    
    public void updateBooks(String status) {
        try {
            sessionFactory = SessionHelper.getConnection();
            Session session = sessionFactory.openSession();

            // Search for the book requests to update
            Query query = session.createQuery("UPDATE book_requests SET status = :status';\r\n"
            		+ "");
            query.setParameter("status", status);
            int rowsUpdated = query.executeUpdate();

            session.getTransaction().commit();
            session.close();

            if (rowsUpdated > 0) {
                // Show success message
                FacesContext facesContext = FacesContext.getCurrentInstance();
                facesContext.getExternalContext().getFlash().put("message", "Updated Successfully");

                // Redirect to menu.jsp after 2 seconds
                // HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
                // response.setHeader("Refresh", "2;url=menu.jsp");
                // facesContext.responseComplete();
            } else {
                System.out.println("No book requests found in the database.");
            }
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
            // Custom error message or further error handling
        }
    }

    public BookRequest searchById(int id) {
		System.out.println(id);
		 sessionFactory = SessionHelper.getConnection();
         Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(BookRequest.class);
		Criterion criterion1 = Restrictions.eq("id", id);
		Criterion criterion2 = Restrictions.eq("status",Status.PENDING);
		cr.add(Restrictions.and(criterion1, criterion2));
		List<BookRequest> bookList = cr.list();
		if (bookList.size() == 0) {
			return null;
		}

		return bookList.get(0);
	}
    public void redirect() throws IOException {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect("login1.jsp");
    }
    
    
    public List<Books> getAllBooks() {
	    sessionFactory = SessionHelper.getConnection();
	    Session session = sessionFactory.openSession(); 
	    Criteria cr = session.createCriteria(Books.class);
	    List<Books> lst = cr.list();
	    return lst;
	}
    
    public Books getBookById(int id) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession(); 
		Criteria cr = session.createCriteria(Books.class);
		cr.add(Restrictions.eq("id", id));
		List<Books> booksList = cr.list();
		return booksList.get(0);
	}
    public void updateBook(Books book) {
        sessionFactory = SessionHelper.getConnection();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        
        try {
            transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

} 


