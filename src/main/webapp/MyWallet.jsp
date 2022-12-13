<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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
<style>



.nav-item{
font-weight: bold;
font-size: medium;

}
.nav-item:hover {
	background-color: #cccccc;
}
.container-fluid{
background-color: dark;
}

.jumbotron{
background-color:aqua;
text-align: center;


}
</style>

</head>

<body>
<jsp:useBean id="custDao" class="com.infinite.can.CustomerDAO"/>
<c:set var="cust" value="${custDao.searchCustomer(cust_userName)}"/>
<div class="jumbotron jumbotron-fluid m-0 p-4">
  <div class="container ">
    <h1>Canteen Management</h1>
    
  </div>
</div>
 <div class="container-fluid m-0">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
 
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="ShowRestaurant.xhtml">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="MyOrder.jsp">My Order</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" href="MyCart.jsp">My cart</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" href="MyWallet.jsp">My Wallet</a>
        </li>   
        <li class="nav-item">
          <a class="nav-link active" href="LogOut">LogOut</a>
        </li>
      </ul>
    </div>
    <b>
 Welcome !  ${cust_userName}
</b>

 

</nav>  </div>
<div class="container">
 <div class="row">
   <div class="col-sm-4">
   <form>
      <div class="form-group">
         Customer Id:
		<input type="text" name="customerId" value="${cust.cust_id}" class="form-control" readonly/>
      </div>
      <div class="form-group">
         Wallet Type:
		<select name="walletType" class="form-control">
		<option value="PHONEPAY">PHONEPAY</option>
		<option value="GPAY">GPAY</option>
		<option value="PAYTM">PAYTM</option>
		</select>
      </div>
      <div class="form-group">
        Amount:
		<input type="number" name="amt" class="form-control"/>
      </div>
      <input type="submit" value="Add" class="btn btn-info"/>
</form>
	<c:if test="${param.walletType != null}">
	<jsp:useBean id="wallet" class="com.infinite.can.Wallet"/>
	<jsp:setProperty property="*" name="wallet"/>
	<jsp:useBean id="walletDao" class="com.infinite.can.WalletDAO"/>
	<c:out value="${walletDao.addWallet(wallet)}"/>
	</c:if>
   </div>
   <div class="col-sm-2"></div>
   <div class="col-sm-5">
   <jsp:include page="test.jsp" /> 
   </div>
 </div>

</div>

</body>
</html>