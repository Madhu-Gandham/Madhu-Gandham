package com.infinite.Library;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

@ManagedBean(name="LibraryDAO")
@SessionScoped
@RequestScoped
public class LibraryDAO {
	SessionFactory sessionFactory;
	
	private static Logger logger=LogManager.getLogger(LibraryDAO.class);
	
	public int loginCheck(String userName, String password) {
	    try {
	        sessionFactory = SessionHelper.getConnection();
	        Session session = sessionFactory.openSession();
	        Criteria criteria = session.createCriteria(LibUsers.class);
	        criteria.add(Restrictions.eq("userName", userName));
	        criteria.add(Restrictions.eq("password", doHasing(password)));
	        List<LibUsers> listUsers = criteria.list();
	        session.close();
	        return listUsers.size();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}
	public String addUser(String userName, String password, String email, java.util.Date dob, String firstname, String phn_num,
			String securityQuestion, String answers) {
	
	    try {
	        sessionFactory = SessionHelper.getConnection();
	        Session session = sessionFactory.openSession();
	        FacesContext context = FacesContext.getCurrentInstance();
	        boolean validUser = ForgotPasswordDAO.isUserExist(userName);
	        if (validUser) {
	           
	            context.addMessage("cregfrm:userName", new FacesMessage("Username already exists."));
	            return "success";
	        } else {
	            LibUsers user = new LibUsers();
	            user.setUserName(userName);
	            user.setEmail(email);
	            user.setDob(dob);
	            user.setFirstname(firstname);
	            user.setPhn_num(phn_num);
	            user.setAnswers(answers);
	            user.setSecurityQuestion(securityQuestion);
	            user.setPassword(doHasing(password));
	            org.hibernate.Transaction tran = session.beginTransaction();
	            session.save(user);
	            tran.commit();
	            logger.info("User details saved successfully: " + userName);
	            context.addMessage("cregfrm", new FacesMessage("Details saved successfully"));
	            ExternalContext externalContext = context.getExternalContext();
	            externalContext.redirect(externalContext.getRequestContextPath() + "/login.jsp");
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
	public void redirectToLoginPage() throws IOException {
	    FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsp");
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
		
	public List<Books> searchBooks(String author, String dept, String sort) {
	    try {
	        sessionFactory = SessionHelper.getConnection();
	        Session session = sessionFactory.openSession();
	        Criteria cr = session.createCriteria(Books.class);

	        if (author != null && !author.isEmpty()) {
	            cr.add(Restrictions.ilike("author", author + "%"));
	        }

	        if (dept != null && !dept.isEmpty()) {
	            cr.add(Restrictions.ilike("dept", "%" + dept + "%"));
	        }

	        List<Books> lst = cr.list();

	        if (sort != null && !sort.isEmpty()) {
	            if (sort.equalsIgnoreCase("author_asc")) {
	                Collections.sort(lst, Comparator.comparing(Books::getAuthor));
	            } else if (sort.equalsIgnoreCase("author_desc")) {
	                Collections.sort(lst, Comparator.comparing(Books::getAuthor).reversed());
	            }
	        }

	        return lst;
	    } catch (Exception e) {
	        // Handle the exception
	        e.printStackTrace();
	        return new ArrayList<>();
	    }
	}




	public Books searchById(int id) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession(); 
		Criteria cr = session.createCriteria(Books.class);
		cr.add(Restrictions.eq("id", id));
		List<Books> booksList = cr.list();
		return booksList.get(0);
	}
	
	public String issueBook(TranBook tranBook) {
	    try {
	        sessionFactory = SessionHelper.getConnection();
	        Session session = sessionFactory.openSession();
	        if (issueOrNot(tranBook.getBookId()) == 1) {
	            return "Book with id " + tranBook.getBookId() + "Already issued...";
	        }
	        java.util.Date date = new java.util.Date();
	        java.sql.Date sqlDate = new Date(date.getTime());
	        tranBook.setFromDate(sqlDate);
	        Transaction tran = session.beginTransaction();
	        session.save(tranBook);
	        tran.commit();
	        session.close();
	        session = sessionFactory.openSession();
	        Books book = searchById(tranBook.getBookId());
	        book.setTotalBooks(book.getTotalBooks() - 1);
	        tran = session.beginTransaction();
	        session.saveOrUpdate(book);
	        tran.commit();
	        return "Book with Id " + tranBook.getBookId() + "Issued Successfully...";
	    } catch (Exception e) {
	        logger.error("Error",e);
	        e.printStackTrace();
	        return "Error: Failed to issue the book";
	    }
	}

	public int issueOrNot(int bookId) {
	    try {
	        sessionFactory = SessionHelper.getConnection();
	        Session session = sessionFactory.openSession();
	        Criteria cr = session.createCriteria(TranBook.class);
	        cr.add(Restrictions.eq("bookId", bookId));
	        return cr.list().size();
	    } catch (Exception e) {
	        // Handle the exception
	        e.printStackTrace();
	        return -1; // Return a negative value to indicate an error
	    }
	}

	
	public TranBook search(int bookId, String user) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession(); 
		Criteria cr = session.createCriteria(TranBook.class);
		cr.add(Restrictions.eq("bookId", bookId));
		cr.add(Restrictions.eq("userName", user));
		List<TranBook> list = cr.list();
		return list.get(0);
	}
	public List<TranBook> issueBooks(String user) {
	    try {
	        sessionFactory = SessionHelper.getConnection();
	        Session session = sessionFactory.openSession();
	        Criteria cr = session.createCriteria(TranBook.class);
	        List<TranBook> lst = cr.list();
	        session.close();
	        return lst;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ArrayList<>();
	    }
	}

	
	public Date currentSQLDate() {
		LocalDate localDate = LocalDate.now();
	    Date sqlDate = Date.valueOf(localDate);
	    return sqlDate;
	}
	public String returnBookDAO(int bookId, String user) {
	    try {
	        sessionFactory = SessionHelper.getConnection();
	        Session session = sessionFactory.openSession();

	        TranBook tranBook = search(bookId, user);
	        Date issueDate = tranBook.getFromDate();

	        ReturnBook returnBook = new ReturnBook();

	        returnBook.setBookId(bookId);
	        returnBook.setUsername(user);
	        returnBook.setFromDate(issueDate);
	        returnBook.setTodate(currentSQLDate());

	        TranBook tarnBook = search(bookId, user);

	        Transaction tran = session.beginTransaction();
	        session.save(returnBook);
	        tran.commit();
	        session.close();

	        session = sessionFactory.openSession();
	        tran = session.beginTransaction();
	        session.delete(tranBook);
	        tran.commit();
	        session.close();

	        Books books = searchById(bookId);
	        books.setTotalBooks(books.getTotalBooks() + 1);

	        session = sessionFactory.openSession();
	        tran = session.beginTransaction();
	        session.update(books);
	        tran.commit();
	        session.close();

	        return "Book with Id " + bookId + " Returned Successfully...";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "An error occurred while returning the book.";
	    }
	}

	
	public int noOfDays(Date fromDate, Date toDate) {
	    try {
	        int totalDays = toDate.getDate() - fromDate.getDate();
	        return ++totalDays;
	    } catch (Exception e) {
	        e.printStackTrace(); // Or handle the exception in an appropriate way
	        return -1; // Return a default value or error indicator
	    }
	}

	
	public float calculateFine(int noOfDays) {
		float fine = 0;
		
		if(noOfDays >3) {
			fine = 2 * (noOfDays - 3);
		}
		return fine;
	}
	
	public List<ReturnBook> history(String user) {		
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession(); 
		Criteria cr = session.createCriteria(ReturnBook.class);
		cr.add(Restrictions.eq("username", user));
		List<ReturnBook> lst = cr.list();
		return lst;
	}
	
	public List<Books> getAllBooks() {
	    sessionFactory = SessionHelper.getConnection();
	    Session session = sessionFactory.openSession(); 
	    Criteria cr = session.createCriteria(Books.class);
	    List<Books> lst = cr.list();
	    return lst;
	}
	public List<Books> searchBooks1(String authorFilter, String deptFilter) {
	    sessionFactory = SessionHelper.getConnection();
	    Session session = sessionFactory.openSession();
	    Criteria cr = session.createCriteria(Books.class);

	    if (authorFilter != null && !authorFilter.isEmpty()) {
	        cr.add(Restrictions.ilike("author", "%" + authorFilter + "%"));
	    }
	    if (deptFilter != null && !deptFilter.isEmpty()) {
	        cr.add(Restrictions.ilike("dept", "%" + deptFilter + "%"));
	    }

	    List<Books> lst = cr.list();
	    return lst;
	}
    private String authorFilter;
    private String deptFilter;
    private List<Books> booksList;

    public String getAuthorFilter() {
        return authorFilter;
    }

    public void setAuthorFilter(String authorFilter) {
        this.authorFilter = authorFilter;
    }

    public String getDeptFilter() {
        return deptFilter;
    }

    public void setDeptFilter(String deptFilter) {
        this.deptFilter = deptFilter;
    }

    public List<Books> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Books> booksList) {
        this.booksList = booksList;
    }

    public void searchByAuthor() {
        SessionFactory sessionFactory = SessionHelper.getConnection();
        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Books.class);
        cr.add(Restrictions.eq("author", authorFilter));
        booksList = cr.list();
        session.close();
    }

    public void searchByDept() {
        SessionFactory sessionFactory = SessionHelper.getConnection();
        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Books.class);
        cr.add(Restrictions.eq("dept", deptFilter));
        booksList = cr.list();
        session.close();
    }
    
    public List<Books>SelectedBooks(List<Integer> bookIds) {
        sessionFactory = SessionHelper.getConnection();
        Session session = sessionFactory.openSession(); 
        Criteria cr = session.createCriteria(Books.class);
        cr.add(Restrictions.in("id", bookIds));
        List<Books> selectedBooks = cr.list();
        return selectedBooks;
    }
    
    public String addBook(Books book) {
        try {
            sessionFactory = SessionHelper.getConnection();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(book);
            transaction.commit();
            session.close();
            
            // Redirect to menu.jsp
            FacesContext.getCurrentInstance().getExternalContext().redirect("login1.jsp");
            
            // Return an empty string to indicate that the navigation has already occurred
            return "Details saved Successfully";
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
            return "Error: Failed to redirect to menu.jsp";
        }
    }

    public Books UpdateBooks1(String name) {
        try {
            sessionFactory = SessionHelper.getConnection();
            Session session = sessionFactory.openSession();
            Books books = search(name);
            Criteria cr = session.createCriteria(Books.class);
            cr.add(Restrictions.eq("id", books.getId()));
            cr.add(Restrictions.eq("name", books.getName()));
            cr.add(Restrictions.eq("author", books.getAuthor()));
            cr.add(Restrictions.eq("edition", books.getEdition()));
            cr.add(Restrictions.eq("dept", books.getDept()));
            cr.add(Restrictions.eq("totalBooks", books.getTotalBooks()));
            List<Books> customerList = cr.list();
            return customerList.get(0);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
            return null; // Return null or handle the error condition appropriately
        }
    }

    
    public Books search(String name) {
    	sessionFactory = SessionHelper.getConnection();
        Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(Books.class);
		cr.add(Restrictions.eq("name", name));
		List<Books> tt = cr.list();
		return tt.get(0);

	}
    
    public void UpdateBooks(String name, String author, String edition, String dept, int totalBooks, int id) {
        try {
            sessionFactory = SessionHelper.getConnection();
            Session session = sessionFactory.openSession();

            // Search for the book to update
            Criteria cr = session.createCriteria(Books.class);
            cr.add(Restrictions.eq("id", id));
            List<Books> booksList = cr.list();

            if (!booksList.isEmpty()) {
                // Update the book properties
                Books book = booksList.get(0);
                book.setAuthor(author);
                book.setEdition(edition);
                book.setName(name);
                book.setDept(dept);
                book.setTotalBooks(totalBooks);

                // Save the updated book in the database
                session.beginTransaction();
                session.update(book);
                session.getTransaction().commit();

                session.close();

                // Show success message
                FacesContext facesContext = FacesContext.getCurrentInstance();
                facesContext.getExternalContext().getFlash().put("message", "Updated Successfully");

                // Redirect to menu.jsp after 2 seconds
                HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
                response.setHeader("Refresh", "2;url=login1.jsp");
                facesContext.responseComplete();
            } else {
                System.out.println("Book not found in the database.");
                session.close();
            }
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
            // Custom error message or further error handling
        }
    }

    public void deleteBook(int id) {
        try {
            sessionFactory = SessionHelper.getConnection();
            Session session = sessionFactory.openSession();

            // Search for the book to delete
            Criteria cr = session.createCriteria(Books.class);
            cr.add(Restrictions.eq("id", id));
            List<Books> booksList = cr.list();

            if (!booksList.isEmpty()) {
                Books book = booksList.get(0);

                // Delete the book from the database
                session.beginTransaction();
                session.delete(book);
                session.getTransaction().commit();

                session.close();

                // Show success message
                FacesContext facesContext = FacesContext.getCurrentInstance();
                facesContext.getExternalContext().getFlash().put("message", "Book deleted successfully");

                // Redirect to menu.jsp after 2 seconds
                HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
                response.setHeader("Refresh", "2;url=login1.jsp");
                facesContext.responseComplete();
            } else {
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage errorMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Book Id was not found in the database", null);
                facesContext.addMessage(null, errorMessage);
                session.close();
            }
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
            // Custom error message or further error handling
        }
    }

    public List<Books> searchBooked(String searchtype, String searchvalue) {
        try {
            sessionFactory = SessionHelper.getConnection();
            Session session = sessionFactory.openSession();
            Criteria cr = session.createCriteria(Books.class);

            if (searchtype.equals("id")) {
                int id = Integer.parseInt(searchvalue);
                cr.add(Restrictions.eq("id", id));
            }
            if (searchtype.equalsIgnoreCase("dept")) {
                cr.add(Restrictions.eq("dept", searchvalue));
            }

            if (searchtype.equalsIgnoreCase("bookname")) {
                cr.add(Restrictions.eq("name", searchvalue));
            }

            if (searchtype.equalsIgnoreCase("authorname")) {
                cr.add(Restrictions.eq("author", searchvalue));
            }

            List<Books> lst = cr.list();
            session.close();
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
