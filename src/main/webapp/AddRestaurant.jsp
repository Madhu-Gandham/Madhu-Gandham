<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
.col-sm-6{
background-color: white;
font-weight: bold;

}
</style>
<title>Restaurant Registration</title>
</head>
<body>
<jsp:include page="Navbar.jsp" />
<div class="container">
  <div class="row">
   <div class="col-sm-6 mx-auto">
     
    <form method="get" action="AddRestaurant.jsp">
     <div class="form-group">
	     Name
		<input type="text" name="name" class="form-control" required/>
     </div>
     
      <div class="form-group">
        City         : 
		<input type="text" name="city" class="form-control" required/ >
     </div>
     
      <div class="form-group">
       State        : 
	   <input type="text" name="state" class="form-control" required/>
     </div>

      <div class="form-group">
       Pincode 
	   <input type="number" name="pincode" class="form-control" required/>
     </div>
      <div class="form-group">
       Email 
	  <input type="email" name="email" class="form-control" required/>
     </div>
     
      <div class="form-group">
        Mobile Number
		<input type="tel" name="mobileno" pattern="[6789][0-9]{9}" class="form-control" required/>
     
     </div>
      <div class="form-group">
         User Name
		 <input type="text" name="username" class="form-control" required/>
     
     </div>
      <div class="form-group">
       Password
	   <input type="text" name="password" class="form-control" required/>
     </div>
     <input type="submit" value="Register" class="btn btn-dark"/> 
     </form>
     <c:if test="${param.email!=null}">
		<jsp:useBean id="resturant" class="com.infinite.can.Restaurant" />
		<jsp:useBean id="dao" class="com.infinite.can.RestaurantDAO"/>
		<jsp:setProperty property="*" name="resturant"/>
		<c:out value="${dao.addResturant(resturant)}" />
	</c:if>
	
   </div>
  </div>
</div>
</body>
</html>