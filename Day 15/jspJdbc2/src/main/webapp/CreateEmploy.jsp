<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.infinite.jspJdbc2.EmployDAO"%>
<%@page import="com.infinite.jspJdbc2.Employ"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
  <form method="get" action="CreateEmploy.jsp">
    <center>
      Employ Name:
      <input type="text"  name="name" /><br/><br/>
      Department:
      <input type="text"  name="dept" /><br/><br/>
      Designation:
      <input type="text"  name="desig" /><br/><br/>
      Basic:
      <input type="text"  name="basic" /><br/><br/>
      <input type="submit"  value="Insert" />
    </center>
  </form>
  <%
      if(request.getParameter("basic")!=null){
    	  Employ employ = new Employ();
    	  employ.setName(request.getParameter("name"));
    	  employ.setDept(request.getParameter("dept"));
    	  employ.setDesig(request.getParameter("desig"));
    	  employ.setBasic(Integer.parseInt(request.getParameter("basic")));
    	  EmployDAO dao = new EmployDAO();
    	  dao.addEmploy(employ);
 %>
     <jsp.forward page="EmployTable.jsp"/>
    	
   <% 	    
      }
  %>
</body>
</html>