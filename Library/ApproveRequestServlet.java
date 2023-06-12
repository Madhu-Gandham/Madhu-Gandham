package com.infinite.Library;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ApproveRequestServlet")
public class ApproveRequestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Get the ID and status parameters from the request
	    int id = Integer.parseInt(request.getParameter("id"));
	    String status = request.getParameter("status");

	    // Update the status in the database
	    BookRequestDAO bookRequestDAO = new BookRequestDAO();
	    bookRequestDAO.updateStatus(id, status);

	    // Send a JSON response indicating the status update
	    String jsonResponse = "{\"status\": \"" + status + "\"}";
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(jsonResponse);
	}
}
