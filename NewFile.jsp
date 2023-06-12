<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Show Requests</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Teacher Name</th>
                <th>Book Title</th>
                <th>Reason</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${BookRequestDAO.getAllBookRequest()}" var="request">
                <tr>
                    <td>${request.id}</td>
                    <td>${request.teacher_name}</td>
                    <td>${request.book_title}</td>
                    <td>${request.reason}</td>
                    <td>${request.status}</td>
                   
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
