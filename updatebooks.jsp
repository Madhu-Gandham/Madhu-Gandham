<%@page import="com.infinite.Library.Books"%>
<%@page import="com.infinite.Library.BookRequestDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Book</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .container {
            max-width: 500px;
            margin-top: 50px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Update Book</h1>

        <% 
        // Retrieve the book ID from the URL parameter
        String bookIdParam = request.getParameter("id");
        if (bookIdParam != null && !bookIdParam.isEmpty()) {
            int bookId = Integer.parseInt(bookIdParam);

            // Get the book details based on the book ID
            BookRequestDAO bookDAO = new BookRequestDAO();
            Books book = bookDAO.getBookById(bookId);
        
            if (book != null) {
                // Display the book details in an HTML form
        %>
        <form method="POST" action="">
            <input type="hidden" name="id" value="<%= book.getId() %>">
            <div class="form-group">
                <label>ID:</label>
                <input type="text" class="form-control" name="id" value="<%= book.getId() %>" readonly>
            </div>
            <div class="form-group">
                <label>Name:</label>
                <input type="text" class="form-control" name="name" value="<%= book.getName() %>">
            </div>
            <div class="form-group">
                <label>Author:</label>
                <input type="text" class="form-control" name="author" value="<%= book.getAuthor() %>">
            </div>
            <div class="form-group">
                <label>Edition:</label>
                <input type="text" class="form-control" name="edition" value="<%= book.getEdition() %>">
            </div>
            <div class="form-group">
                <label>Department:</label>
                <input type="text" class="form-control" name="dept" value="<%= book.getDept() %>">
            </div>
            <div class="form-group">
                <label>Total Books:</label>
                <input type="text" class="form-control" name="totalBooks" value="<%= book.getTotalBooks() %>">
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
        <% 
            } else {
        %>
        <p>Book not found</p>
        <% 
            }
        } else {
        %>
        <p>Invalid book ID</p>
        <% 
        }
        %>

        <% 
        // Handle the form submission
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            // Retrieve the form data
            String bookIdParamString = request.getParameter("id");
            String name = request.getParameter("name");
            String author = request.getParameter("author");
            String edition = request.getParameter("edition");
            String dept = request.getParameter("dept");
            String totalBooksParam = request.getParameter("totalBooks");

            if (bookIdParamString != null && !bookIdParamString.isEmpty()
                    && name != null && !name.isEmpty()
                    && author != null && !author.isEmpty()
                    && edition != null && !edition.isEmpty()
                    && dept != null && !dept.isEmpty()
                    && totalBooksParam != null && !totalBooksParam.isEmpty()) {
                
                int bookId = Integer.parseInt(bookIdParamString);
                int totalBooks = Integer.parseInt(totalBooksParam);

                // Update the book details in the database
                BookRequestDAO bookDAO = new BookRequestDAO();
                Books book = bookDAO.getBookById(bookId);
                
                if (book != null) {
                    book.setName(name);
                    book.setAuthor(author);
                    book.setEdition(edition);
                    book.setDept(dept);
                    book.setTotalBooks(totalBooks);

                    // Save the updated book details
                    bookDAO.updateBook(book);
                    
                    out.println("<p>Book updated successfully!</p>");
                    
                    // Redirect to Showbooks.jsp after successful update
                    response.sendRedirect("Showbooks.jsp");
                } else {
                    out.println("<p>Book not found</p>");
                }
            } else {
                out.println("<p>Invalid form data</p>");
            }
        }
        %>
    </div>
</body>
</html>
