<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="beanDao" class="com.infinite.Library.LibraryDAO" />
<c:set var="user" value="${sessionScope.user}" />
<jsp:include page="menu.jsp" /><br />
<div class="container text-center">
  <h3>Select books to issue:</h3> 
  <table class="table table-striped">
    <thead>
      <tr>
        <th>TID</th>
        <th>Book ID</th>
        <th>Name</th>
        <th>From Date</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="trans" items="${beanDao.issueBooks(user)}">
        <tr>
          <td><c:out value="${trans.tid}" /></td>
          <td><c:out value="${trans.bookId}" /></td>
          <td><c:out value="${trans.userName}" /></td>
          <td><c:out value="${trans.fromDate}" /></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  
  <a href="menu.jsp" class="btn btn-primary">Go to Menu</a>
</div>
