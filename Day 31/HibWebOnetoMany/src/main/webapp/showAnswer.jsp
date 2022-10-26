<%@page import="com.infinite.hibweb.Answer"%>
<%@page import="com.infinite.hibweb.Question"%>
<%@page import="com.infinite.hibweb.SessionHelper"%>
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
	SessionFactory sf = SessionHelper.getConnection();
	Session s=sf.openSession();
	Query q=s.createQuery("from Question");
	List<Answer> list=q.list();
	
%>
	<table border="3">
		<tr>
			<th>id</th>
			<th>q name</th>
			
		</tr>
<%
  
	for(Answer e : list) {
%>
	<tr>
		<td><%=e.getId() %> </td>
		<td><%=e.getAnswerName()%>  </td>
		<td><%=e.getPostedBy() %>
		
	</tr>
<%
	}
%>
	</table>
</body>
</html>
