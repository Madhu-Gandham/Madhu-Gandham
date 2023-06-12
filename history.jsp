<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>History</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
  <!-- Custom CSS -->
  <style>
    body {
      background-color: #f8f9fa;
    }

    h1 {
      text-align: center;
      margin-bottom: 30px;
    }

    table {
      background-color: #fff;
      border-collapse: collapse;
      width: 100%;
      margin: 0 auto;
      margin-bottom: 20px;
    }

    th, td {
      padding: 12px 15px;
      text-align: left;
      border: 1px solid #ddd;
    }

    th {
      background-color: #17a2b8;
      color: #fff;
    }

    tr:nth-child(even) {
      background-color: #f2f2f2;
    }
  </style>
</head>
<body>
  <div class="container">
    <jsp:include page="menu.jsp"/><br/>
    <jsp:useBean id="beanDao" class="com.infinite.Library.LibraryDAO"/>
    <c:set var="user" value="${sessionScope.user}"/>
    <h1>History</h1>
    <table class="table">
      <thead class="thead-dark">
        <tr>
          <th>TID</th>
          <th>Book ID</th>
          <th>Name</th>
          <th>Issued Date</th>
          <th>Return Date</th>
          <th>No. of Days</th>
          <th>Fine</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="history" items="${beanDao.history(user)}">
          <tr>
            <td><c:out value="${history.tid}"/></td>
            <td><c:out value="${history.bookId}"/></td>
            <td><c:out value="${history.username}"/></td>
            <td><c:out value="${history.fromDate}"/></td>
            <td><c:out value="${history.todate}"/></td>
            <c:set var="noOfDays" value="${beanDao.noOfDays(history.fromDate, history.todate)}"></c:set>
            <td><c:out value="${noOfDays}"/></td>
            <td><c:out value="${beanDao.calculateFine(noOfDays)}"/></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
      <a href="menu.jsp" class="btn btn-primary">Go to Menu</a>
  </div>
  <!-- Bootstrap JS -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
