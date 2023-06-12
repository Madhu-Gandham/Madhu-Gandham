<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>

    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        th {
            background-color: #007bff;
            color: white;
        }
    </style>

</head>
<body>
    <jsp:include page="menu.jsp" /><br />
    <jsp:useBean id="beanDao" class="com.infinite.Library.LibraryDAO" />
    <c:set var="user" value="${sessionScope.user}" />
    <br /> Select books to Return Books: <br />

    <form action="return.jsp" method="get">
        <table>
            <tr>
                <th>TID</th>
                <th>Book Id</th>
                <th>Name</th>
                <th>Return</th>
            </tr>
            <c:forEach var="trans" items="${beanDao.issueBooks(user)}">
                <tr>
                    <td><c:out value="${trans.tid }"></c:out></td>
                    <td><c:out value="${trans.bookId}" /></td>
                    <td><c:out value="${trans.userName}" /></td>
                    <td><input type="checkbox" name="bid" value="${trans.bookId}" /></td>
                </tr>
            </c:forEach>
        </table>
        <br />
        <input type='submit' class="btn btn-primary"value='Return Books' >
         <a href="menu.jsp" class="btn btn-primary">Go to Menu</a>
         
    </form>
    

    <c:if test="${empty beanDao.issueBooks(user)}">
         <p style="color: red; text-align: center;">No books found in the record.</p>
    </c:if>

    <c:forEach var="b" items="${paramValues.bid}">
        <c:set var="bid" value="${b}" />
        <c:set var="user" value="${sessionScope.user}" />
        <c:out value="${beanDao.returnBookDAO(bid,user)}" />
    </c:forEach>

</body>
</html>
