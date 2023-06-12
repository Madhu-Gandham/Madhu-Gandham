package com.infinite.Library;

import com.infinite.Library.BookRequestDAO;
import com.infinite.Library.Books;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookIdParam = request.getParameter("id");
        if (bookIdParam != null && !bookIdParam.isEmpty()) {
            int bookId = Integer.parseInt(bookIdParam);

            BookRequestDAO bookDAO = new BookRequestDAO();
            Books book = bookDAO.getBookById(bookId);

            if (book != null) {
                request.setAttribute("book", book);
                request.getRequestDispatcher("updatebooks.jsp").forward(request, response);
            } else {
                response.getWriter().println("Book not found");
            }
        } else {
            response.getWriter().println("Invalid book ID");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the book details from the form
        int bookId = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String edition = request.getParameter("edition");
        String dept = request.getParameter("dept");
        int totalBooks = Integer.parseInt(request.getParameter("totalBooks"));

        // Create a new book object with the updated details
        Books updatedBook = new Books();
        updatedBook.setId(bookId);
        updatedBook.setName(name);
        updatedBook.setAuthor(author);
        updatedBook.setEdition(edition);
        updatedBook.setDept(dept);
        updatedBook.setTotalBooks(totalBooks);

        // Update the book in the database
        BookRequestDAO bookDAO = new BookRequestDAO();
        bookDAO.updateBooks(dept);
        bookDAO.updateBooks(edition);
        bookDAO.updateBooks(author);
        bookDAO.updateBooks(name);
        

        response.sendRedirect("books.jsp");
    }
}
