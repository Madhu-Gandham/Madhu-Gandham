<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="beanDao" class="com.infinite.lmshib.EmployDAO"/>
<form method="get" action="DashBoard.jsp">
           <table border="3" align="center">
           <tr>
<th>Employ ID</th>
<th>Employ Name</th>
 <th>Employ Mail</th>
                      <th>Employ Mobile no</th>
                      <th>Employ Date of join</th>
                      <th>Employ Department</th>
                      <th>Employ Manager Id</th>
                      <th>Employ leaveAvail</th>
           </tr>
           <c:forEach var="employ" items="${beanDao.showEmploy()}">
           <tr>
                                 <td>${employ.empId}</td>
                                 <td>${employ.empName}</td>
                                 <td>${employ.empEmail}</td>
                                 <td>${employ.empMobile}</td>
                                 <td>${employ.empDoj}</td>
                                 <td>${employ.empDept}</td>
                                 <td>${employ.mgrId}</td>
                                 <td>${employ.leaveAvail}</td>
                                 <td><a href="DashBoard.jsp?id=${employ.empId}&mid=${employ.mgrId}">Search</a>
</td>
           </tr>
           </c:forEach>
           </table>
           </form>
</body>
</html>