<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css" />
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="CNavbar.jsp" />
<c:set var="orderId" value="${param.id}"/>
<jsp:useBean id="dao" class="com.infinite.can.OrderDeatilsDAO"/>
<c:set var="order" value="${dao.searchById(orderId)}"/>
<div class="container">
  <div class="row">
    <div class="col-sm-6 mx-auto">
     <form action="CustomerOrderView.jsp">
      <div class="form-group">
        Order Id:
        <input type="text" name="orderId" class="form-control" value="${orderId}" readonly/>
      </div>
      <div class="form-group">
        Customer Id:
        <input type="text" name="custId"  class="form-control" value="${order.custId}" readonly/>
      </div>
      <div class="form-group">
        Status:
       <input type="text" name="status"  class="form-control"  value="CANCELLED" readonly/>
      </div>
      <input type="submit" value="Cancel" class="btn btn-danger" />
    </form>
    <c:if test="${param.orderId != null && param.status != null }">
		<jsp:useBean id="orderDao" class="com.infinite.can.OrderDeatilsDAO"/>
		<c:out value="${orderDao.updateStatus(param.orderId,param.status)}"/>
		<c:redirect url="MyOrder.jsp"></c:redirect>
	</c:if>
    </div>
  </div>
</div>

</body>
</html>