<%@page import="com.infinite.Hib.Employ" %>
<%@page import="com.infinite.Hib.SessionHelper"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	SessionFactory sf = SessionHelper.getFactory();
	Session s=sf.openSession();
	Query q=s.createQuery("from Employ");
	List<Employ> list=q.list();
%>
	<table border="3">
		<tr>
			<th>empId</th>
			<th>Name</th>
			<th>Age</th>
			<th>designation</th>
			<th>salary</th>
			<th>experience</th>
		</tr>
<%
	for(Employ e : list) {
%>
	<tr>
		<td><%=e.getEmpID() %></td>
		<td><%=e.getname() %></td>
		<td><%=e.getAge()%> </td>
		<td><%=e.getDesignation()%> </td>
		<td><%=e.getSalary() %> </td>
		<td><%=e.getExperience() %></td>
	
		
		
		
		
		
	</tr>
<%
	}
%>
	</table>
</body>
</html>