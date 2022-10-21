<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<h2>Add rooms to list</h2>
<form method="get" action="AddRoom.jsp">
<center>
Type:
<input type="text" name="type"/><br/>



CostPerDay
<input type="number" name="costperday"/><br/>
<input type="submit" value="AddRoom"/>
</center>
</form>



<c:if test="${param.costperday != null}">
<jsp:useBean id="beanDao" class="com.infinite.oyo.RoomDAO"/>
<jsp:useBean id="beanRoom" class="com.infinite.oyo.Room"  />
        <jsp:setProperty property="*" name="beanRoom"/>
<c:out value="${beanDao.addroom(beanRoom)}"/>
</c:if>
</body>
</html>