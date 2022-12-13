<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function val(){
  console.error();
}
</script>
<style>
.col-sm-6{
background-color: white;
font-weight: bold;

}
</style>
</head>
<body>
<jsp:include page="Navbar.jsp" />
	<jsp:useBean id="beanDao" class="com.infinite.can.VendorDAO"/>
	<div class="container">
	  <div class="row">
	    <div class="col-sm-6 mx-auto">
	    <form method="get" action="AddVendor.jsp">
	       <div class="form-group">
	          Vendor Name:
		      <input type="text" name ="vend_name" class="form-control" required/>
	       </div>
	       <div class="form-group">
	          Vendor Email:
			  <input type="email" name ="vend_email" class="form-control" required/>
	       </div>
	       <div class="form-group">
	         Vendor Mobile No:
		     <input type="tel" name ="vend_mob_no" pattern="[6789][0-9]{9}" class="form-control" required/>
	       </div>
	       <div class="form-group">
	        Vendor UserName:
		   <input type="text" name ="vend_userName" class="form-control" required/>
	       </div>
	       <div class="form-group">
	       PassWord:
		   <input type="text" name ="vend_password" class="form-control" required/>
	       </div>
	       <input type="submit" value ="Register" class="btn btn-dark"/>
	    </form>  
	    <c:if test="${param.vend_name!=null && param.vend_password!=null}">

			<jsp:useBean id="beanVendor" class="com.infinite.can.Vendor" />
			<jsp:setProperty property="*" name="beanVendor"/>
			<c:out value="${beanDao.addVendor(beanVendor)}"/>
		</c:if> 
	    </div>
	  </div>
	
	</div>


</body>
</html>