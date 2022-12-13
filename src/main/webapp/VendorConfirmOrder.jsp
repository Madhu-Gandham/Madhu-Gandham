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
<jsp:include page="VDashboard.jsp"/>
<div class="container">
 <div class="row">
   <div class="col-sm-6 mx-auto">
      <form action="VendorConfirmOrder.jsp">
       <div class="form-group">
       Order Id:
		<input type="text" name="orderId" class="form-control" value="${param.orderId}" readonly/>
       </div>
        <div class="form-group">
        Customer Id:
		<input type="text" name="custId" class="form-control" value="${param.custId}" readonly/>
       </div>
        <div class="form-group">
        Status:
		<select name="status" class="form-control">
		 <option value="OUTFORPICKUP">OUT FOR PICKUP</option>
		 <option value="OUTFORDELIVERY">OUT FOR DELIVERY</option>
		 <option value="DELIVERED">DELIVERED</option>
		</select>
       </div>
       <input type="submit" value="Update" class="btn btn-success"/>
      </form>
      <c:if test="${param.orderId != null && param.status != null }">
		<jsp:useBean id="orderDao" class="com.infinite.can.OrderDeatilsDAO"/>
		<c:out value="${orderDao.updateStatus(param.orderId, param.status)}"/>
		
		<c:redirect url="VendorOrder.jsp"/>
		
		
		</c:if>
   </div> 
   </div>
</div>


</body>
</html>