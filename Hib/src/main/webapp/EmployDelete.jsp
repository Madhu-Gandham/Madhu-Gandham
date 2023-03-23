<%@page import="com.infinite.Hib.Employ"%>
<%@page import="com.infinite.Hib.SessionHelper"%>
<%@page import="org.hibernate.Transaction"%>
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
<form method="get" action="EmployDelete.jsp">
		Employ No : 
		<input type="number" name="empID" /> <br/><br/>
		<input type="submit" value="Search" /> <br/><Br/>
	</form>
	<%
		if (request.getParameter("empID") !=null) {
			int empID = Integer.parseInt(request.getParameter("empID"));
			SessionFactory sf = SessionHelper.getFactory();
			Session s=sf.openSession();
			Query q=s.createQuery("from Employ where empID="+empID);
			List<Employ> employList = q.list();
			if (employList.size() == 1) {
				Employ employ = employList.get(0);
				Transaction t = s.beginTransaction();
			    s.delete(employ);
			    t.commit();
			    out.println("Record Deleted...");
			}
			//out.println(employList.size());
		}
	%>
</body>
</html>