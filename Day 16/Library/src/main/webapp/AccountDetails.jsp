<%@page import="com.infinite.Library.TranBook"%>
<%@page import="com.infinite.Library.LibraryDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Menu.jsp"/> <br/>
<% 
   String user = (String)session.getAttribute("user");
   List<TranBook> booksList = new LibraryDAO().issueBooks(user);
%>
<table border="3">
<tr>
   <th>Book Id</th>
   <th>User Name</th>
   <th>Issued On</th>
 <%
 for(TranBook tbook : booksList){
	 %>
	 
	 <tr>
	     <td><%=tbook.getBookId() %></td>
	     <td><%=tbook.getUserName() %></td>
	     <td><%=tbook.getFromDate() %> </td>
	     </tr>
<% 	     
 }
 %>
</table>

</body>
</html>