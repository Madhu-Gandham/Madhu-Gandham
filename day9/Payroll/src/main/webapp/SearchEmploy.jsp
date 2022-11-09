<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.infinite.payroll.Employ" %>
    <%@ page import="java.util.List" %>
     <%@ page import="com.infinite.payroll.EmployDAO" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <jsp:useBean id="beanDao" class="com.infinite.payroll.EmployDAO"/>
  <form action="SearchEmploy.jsp" method="post">
   Employ No:
  <input type="number" name="empno"/><br/><br/>
  <input type='submit' value='SearchEmploy' >                              
  <c:set var="empno" value="${param.empno}"/>
 <c:if test="${param.empno != null}">              
 <c:set var="empno" value="${param.empno}"/>
 <c:forEach var="employ" items="${beanDao.searchEmploy(param.empno)}">
<h1>Employ Details</h1>
 Employ No:<b>
 <c:out value="${employ.empno}"/><br/><br/>
 </b>
 Employ Name:<b>
 <c:out value="${employ.empName}"/> <br/><br/>
 </b>
 Gender:<b>
 <c:out value="${employ.gender}"/> <br/><br/>
 </b>
 Salary:<b>
 <c:out value="${employ.salary}"/> <br/><br/>
 </b>
 Hra:<b>
<c:out value="${employ.hra}"/> <br/><br/>
</b>
Da:<b>
<c:out value="${employ.da}"/> <br/><br/>
</b>
Ta:<b>
<c:out value="${employ.ta}"/> <br/><br/>
</b>
Tax:<b>
<c:out value="${employ.tax}"/> <br/><br/>
</b>
Gross:<b>
<c:out value="${employ.gross}"/> <br/><br/>
</b>
Net Pay:<b>
<c:out value="${employ.netPay}"/> <br/><br/>
</b>
Leave Available:<b>
<c:out value="${employ.leaveAvailable}"/> <br/><br/>
</b>
 
 </c:forEach>
 </c:if>
 </form>
 </body>
 </html>                                                                                          
                  
                  
                  

                
               