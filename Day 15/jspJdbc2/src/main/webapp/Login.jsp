<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.infinite.jspJdbc2.EmployDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Login.jsp">
<center>
 User Name:
 <input type="text" name="userName" /> <br/><br/>
 Password:
  <input type="password" name="passCode" /> <br/><br/>
   <input type="submit" name="Login" /> <br/><br/>
</center>

   </form>
   <%
   if(request.getParameter("userName")!=null && request.getParameter("passCode")!=null){
	   EmployDAO dao = new EmployDAO();
	   String user = request.getParameter("userName");
	   String pwd = request.getParameter("passCode");
	   int count = dao.validate(user,pwd);
	   if(count==1){
		   %>
		    <jsp:forward page="EmployTable.jsp" />
		    <% 
	   }else{
		   out.println("Invalild Credentials....");
	   }
   }
   
   
   %>
</body>
</html>