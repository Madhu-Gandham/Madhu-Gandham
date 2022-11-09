<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
  <form action="SearchLeave.jsp" method="post">
   Employ No:
  <input type="number" name="empno"/><br/><br/>
  <input type='submit' value='SearchLeave' >                              
  <c:set var="empno" value="${param.empno}"/>
 <c:if test="${param.empno != null}">              
 <c:set var="empno" value="${param.empno}"/>
 <c:forEach var="leave" items="${beanDao.searchLeave(param.empno)}">
<h1>Leave Details</h1>
 Leave Id:<b>
 <c:out value="${leave.leaveId}"/><br/><br/>
 </b>
 Employ No:<b>
 <c:out value="${leave.empno}"/> <br/><br/>
 </b>
 LeaveStartDate:<b>
 <c:out value="${leave.leaveStartDate}"/> <br/><br/>
 </b>
 leaveEndDate:<b>
 <c:out value="${leave.leaveEndDate}"/> <br/><br/>
 </b>
 NoOfDays:<b>
<c:out value="${leave.noOfDays}"/> <br/><br/>
</b>
Leave Reason:<b>
<c:out value="${leave.leaveReason}"/> <br/><br/>
</b>
Loss of Pay<b>
<c:out value="${leave.lossOfPay}"/> <br/><br/>
</b>
 </c:forEach>
 </c:if>
 </form>
 </body>
 </html>                                                                                          
                  
                  
                  

                
               