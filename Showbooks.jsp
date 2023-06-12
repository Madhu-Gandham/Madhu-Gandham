<%@page import="com.infinite.Library.BookRequestDAO"%>
<%@page import="com.infinite.Library.Books"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Books</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

    <div class="container">
         <div class="text-center">
        <h1>All Books</h1>
    </div>
        <table class="table table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Author</th>
                    <th>Edition</th>
                    <th>Department</th>
                    <th>Total Books</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <% 
                BookRequestDAO bookDAO = new BookRequestDAO();
                List<Books> books = bookDAO.getAllBooks();
                if (books != null && !books.isEmpty()) {
                    for (Books book : books) {
                %>
                <tr>
                    <td><%= book.getId() %></td>
                    <td><%= book.getName() %></td>
                    <td><%= book.getAuthor() %></td>
                    <td><%= book.getEdition() %></td>
                    <td><%= book.getDept() %></td>
                    <td><%= book.getTotalBooks() %></td>
                    <td><a href="updatebooks.jsp?id=<%= book.getId() %>">Update</a></td>
                    
                </tr>
                
                <% 
                
                    }
                } else {
                %>
                <tr>
                    <td colspan="7">No books found</td>
                </tr>
                <% 
                }
                %>
            </tbody>
        </table>
			        <div class="container">
			            <a class="btn btn-primary" href="adminpanel.jsp">Back</a>
			        </div>
    </div>
</body>
</html>
