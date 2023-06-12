<%@page import="com.infinite.Library.Books"%>
<%@page import="com.infinite.Library.LibraryDAO"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-DfkpXzj7VxHQvWyDdKj/vHEamBfrRtTcTj+cILpzYVP8vp9gOT4MWq4xvtsAUpMl"
	crossorigin="anonymous">

<!-- Bootstrap Icons -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	integrity="sha384-cL6e+ByPcEwpH9X0hUz07xU5Z6U5Z6U5Z6U5Z6U5Z6U="
	crossorigin="anonymous">

<!-- Bootstrap JS -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HkXgHJmkZp1sdZ+czvTmOXlhTtT0Jv1DzYd8O9Xujq3xEMBtjJWtO8A2+0V7QwMv"
	crossorigin="anonymous"></script>
<style >
.search-form {
    display: flex;
}

.search-form form {
    margin-right: 10px;
}
</style>
</head>
<body>
	<jsp:include page="menu.jsp"/>
	<br/>
	<%
		LibraryDAO dao = new LibraryDAO();
		String searchType = request.getParameter("searchtype");
		String searchValue = request.getParameter("searchvalue");
		List<Books> booksList = dao.searchBooked(searchType, searchValue);
	%>
	<form action="issue.jsp">
	<table border="3" align="center">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Author</th>
			<th>Edition</th>
			<th>Department</th>
			<th>Total Books</th>
		</tr>
	<%
		for(Books book : booksList) {
			int bid = book.getId();
			int btotal = book.getTotalBooks();
	%>
		<tr>
			<td> <%=book.getId() %> </td>
			<td><%=book.getName() %> </td>
			<td><%=book.getAuthor() %> </td>
			<td> <%=book.getEdition() %> </td>
			<td><%=book.getDept() %> </td>
			<td><%=book.getTotalBooks() %> </td>
			<%
				if(btotal > 0) {
			%>
			<td>
			<input type='checkbox' name='bookid' value=<%=book.getId() %> >
			
			 
			</td>
			<%
				}
			%>
		</tr>
	<%
		}
	%>
	</table>
	<input type="submit" value="Issue Book(s)" />
	</form>
</body>
</html>