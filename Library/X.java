package com.infinite.Library;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.faces.event.BehaviorEvent;

import org.primefaces.component.commandlink.CommandLinkBase;

import javassist.expr.NewArray;

public class X {
	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
//		User lib = new User();
//		lib.setPassword("Madhu123");
//		lib.setUserName("Gaurav");
		//System.out.println(new LibraryDAO().addUser(lib));
	   //System.out.println(new LibraryDAO().searchBooks1("dept", "author"));
		
		//System.out.println(new LibraryDAO().addUser("Priya","Priya@123"));
		//System.out.println(new LibraryDAO().searchBooks1("dept", "author", "Elliot Koffman", "C/C++"));
		//System.out.println(new LibraryDAO().searchBooks2("Elliot Koffman", "C/C++"));
		
//		List<Books> booksList = new LibraryDAO().searchBooks2("Elliot Koffman", "C/C++");
//		for (Books book : booksList) {
//		    System.out.println("Id: " + book.getId());
//		    System.out.println("Name: " + book.getName());
//		    System.out.println("Author: " + book.getAuthor());
//		    System.out.println("Edition: " + book.getEdition());
//		    System.out.println("Department: " + book.getDept());
//		    System.out.println("Total Books: " + book.getTotalBooks());
//		    System.out.println();
//		}

//		System.out.println(new ForgotPasswordDAO().isUserExist("hari"));
//		System.out.println(new ForgotPasswordDAO().resetPassword("Madhu", "Madhu@123"));\
		
		
		//System.out.println(new LibraryDAO().searchBooks1("dept", "ECE"));
//		System.out.println(new LibraryDAO().checkUsers());
		
		
		//System.out.println(new LibraryDAO().login());
		
//		LibraryDAO dao = new LibraryDAO();
//		dao.setLoginSuccessful(false);
//
//		String result = dao.login();
//
//		if (result.equals("")) {
//		    System.out.println("Navigation to login page successful.");
//		} else {
//		    System.out.println("Error navigating to login page.");
//		}
		
		//System.out.println(new LibraryDAO().login());
		//System.out.println(new LibraryDAO().addUser("Mahesh", "Nagur@1234"));
		
	//System.out.println(new LibraryDAO().searchBooks("Elliot Koffman", "Ece", "d"));
				//System.out.println(new StrongPasswordValidator().toString());
		//System.out.println(new LibraryDAO().issueBooks("Design using C#"));
		//System.out.println(new ForgotPasswordDAO().isUserExist("Madhu"));
		//System.out.println(new LibraryDAO().UpdateBooks("Problem Solving in C"));
//		Books book = new LibraryDAO().search("Problem Solving in C");
//		if (book != null) {
//		    book.setAuthor("John Doe"); // Set the updated author
//		    book.setEdition("2nd Edition"); // Set the updated edition
//		    book.setTotalBooks(50); // Set the updated totalBooks
//
//		    new LibraryDAO().UpdateBooks("Problem Solving in C");
//		}
		//.out.println(new ForgotPasswordDAO().isSecurityAnswerCorrect("Mohan","color", "red"));
		//System.out.println(new LibraryDAO().addUser("MAdhu", "regf", "jdkj",23/05/2023, "hfjs","9000871298", "jfdkj", "jkvkjsd"));
//		BookRequestDAO bookRequestDAO = new BookRequestDAO();
//		BookRequest bookRequest = new BookRequest();
//		bookRequest.setTeacherName("John Doe");
//		bookRequest.setBookTitle("Sample Book");
//		bookRequest.setReason("Request reason");
//		bookRequest.setStatus("Pending");
//		bookRequestDAO.addBookRequest(bookRequest);
//		System.out.println("Book request added successfully!");
		
		//System.out.println(new BookRequestDAO().getAllBookRequest());
//		System.out.println(new LibraryDAO().search("Problem Solving in C"));
		//System.out.println(new BookRequestDAO().searchById(1));
//		 BookRequestDAO bookRequestDAO = new BookRequestDAO();
//		    String status = "Approved"; // Update with the desired status
//
//		    // Call the updateBooks method
//		    bookRequestDAO.updateBooks(status);
//
//		    // Retrieve the book requests from the database
//		    List<BookRequest> updatedRequests = bookRequestDAO.getAllBookRequest();
//
//		    // Check the statuses of the updated book requests
//		    for (BookRequest request : updatedRequests) {
//		        System.out.println("Book Request ID: " + request.getId());
//		        System.out.println("Updated Status: " + request.getStatus());
//		    }
//
//		
//	}
		//System.out.println(new BookRequestDAO().addUser("ekndowen", "jhewbdkjwe", "jeknkwj"));
		//System.out.println(new LibraryDAO().addUser(null, null, null, null, null, null, null, null));
		//System.out.println(new AdminDAO().addadmin("Madhu", "9347785124", "Madhu","Madhu@12345",2023-05-10,"madhu123@gmail.com"));
		//System.out.println(new AdminDAO().resetPassword("MadhuNarasimha", "Madhu@415"));
		//System.out.println(new AdminDAO().isUserExist("MadhuNarasimhaf"));
     // System.out.println(new AdminDAO().loginCheck("MadhuNarasimha","Madhu@415"));
		//System.out.println(new LibraryDAO().searchBooks("Elliot Koffman","", ""));
		System.out.println(new BookRequestDAO().getAllBooks());
	}
	
}