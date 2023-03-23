<%@page import="com.infinite.Hib.SessionHelper"%>
<%@page import="com.infinite.Hib.Employ"%>
<%@page import="org.hibernate.Transaction"%>
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
		Employ employ = new Employ();
	    
	   employ.setDesignation(request.getParameter("designation"));
	  employ.setAge(Integer.parseInt(request.getParameter("Age")));
	  employ.setEmpID(Integer.parseInt(request.getParameter("EmpId")));
	  employ.setSalary(Integer.parseInt(request.getParameter("salary")));
	   
	   employ.setname(request.getParameter("Ename"));
	   employ.setExperience(request.getParameter("Experience"));

	   
		
		SessionFactory sf = SessionHelper.getFactory();
		Session s=sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(employ);
		t.commit();
		out.println("*** Record Inserted ***");
	%>
</body>
</html>