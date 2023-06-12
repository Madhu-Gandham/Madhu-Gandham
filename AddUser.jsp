<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Add User</title>
</head>
<body>
	<form action="AddUser.jsp" method="post">
		<h2>Add User</h2>
		
		<label for="userName">Username: </label>
		<input type="text" id="userName" name="userName" />
		<br/><br/>
		
		<label for="password">Password: </label>
		<input type="password" id="password" name="password"/>
		<br/><br/>
		
		<input type="submit" value="Add User" name="LibraryDAO.addUser">
		
	</form>
</body>
</html>
