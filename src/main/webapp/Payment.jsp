<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/jquery-3.5.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="custDao" class="com.infinite.can.CustomerDAO"/>
<c:set var="cust" value="${custDao.searchCustomer(cust_userName)}"/>
<jsp:useBean id="dao" class="com.infinite.can.WalletDAO"/>
<c:set var="bill" value="${param.total}"/>
<jsp:include page="CNavbar.jsp"/>
<div class="container">
   <div class="row">
     <div class="col-sm-6 mx-auto">
     <form action="Payment.jsp">
          
        <div class="form-group">
          <label>Customer Id</label>
          <input type="text" name="custId" value="${cust.cust_id}"  class="form-control" readonly>
        </div>
        <div class="form-group">
          <label>Wallet Type</label>
          <select name="walletType" class="form-control">
		   <c:forEach var="type" items="${dao.searchWallet(cust.cust_id)}">
				<option value="${type.walletType}">
				<c:out value="${type.walletType}" />
			    </option>
		    </c:forEach>
	       </select>
        </div>
        <div class="form-group">
          <label>Amount</label>
          <input type="number" class="form-control" name="billamt" value="${bill}" readonly/>
        </div>
        <div class="form-group">
          <label>Address</label>
         <input type="text" name="address" class="form-control" />
        </div>
        <div class="form-group">
          <label>Comments</label>
           <input type="text" name="comments" class="form-control"/>
        </div>
      
         <input type="submit" value="Pay" class="btn  btn-success"/>
      
       
      </form>
      <c:if test="${param.walletType != null}">
     <jsp:useBean id="d" class="com.infinite.can.OrderDeatilsDAO"/>
     <jsp:useBean id="order" class="com.infinite.can.OrderDetails" />
     <jsp:setProperty property="*" name="order" />
     <c:out value="${d.paymentOrder(order)}"></c:out>
    
  </c:if>
      </div>
   </div>
</div>
 
  
</body>
</html>