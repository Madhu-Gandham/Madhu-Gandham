<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="com.infinite.jspJdbc2.Employ"%>
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
<% 
 int empno = Integer.parseInt(request.getParameter("empno"));
   EmployDAO dao = new EmployDAO();
   Employ employ = dao.searchEmploy(empno);
   %>
   <form method="get" action="UpdateEmploy.jsp">
   <center>
   Employ No:
      <input type="text"  name="empno" value=<%=employ.getEmpno() %> >
      <br/>
    Employ Name:
      <input type="text"  name="name" value=<%=employ.getName()%> ></input>
         <br/>
      Department:
      <input type="text"  name="dept" value=<%=employ.getDept()%> >
            <br/>
      Designation:
      <input type="text"  name="desig" value=<%=employ.getDesig()%>>
       <br/>
       Basic:
        <input type="text"  name="basic" value=<%=employ.getBasic()%>>
        <br/>
      <input type="submit"  value="Update Employ" />
   
   
   
   
   </form>
      </center>
   <%
       if(request.getParameter("empno")!=null  && request.getParameter("basic")!=null){
    	   Employ employNew = new Employ();
    	   employNew.setEmpno(Integer.parseInt(request.getParameter("empno")));
    	   employNew.setName(request.getParameter("name"));
    	   employNew.setDept(request.getParameter("dept"));
    	   employNew.setDesig(request.getParameter("desig"));
    	   employNew.setBasic(Integer.parseInt(request.getParameter("basic")));
    	   
    	   %>
    	   <jsp:forward page="EmployTable.jsp"/>
    	   <% 
       }
   %>
  
</body>
</html>