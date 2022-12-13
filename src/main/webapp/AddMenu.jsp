<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/jquery-3.5.1.min.js"></script>
<style type="text/css">

</style>
</head>
<body>
<jsp:useBean id="restDao" class="com.infinite.can.RestaurantDAO"/>
<c:set var="rest1" value="${restDao.searchRestaurant(username)}"/>
<jsp:include page="RDashboard.jsp" /><br/><br/>
	<jsp:useBean id="beanDao" class="com.infinite.can.MenuDAO"/>
<div class="container">
  <div class="row">
     <div class="col-sm-6 mx-auto">
     <form method="get" action="AddMenu.jsp">

      <div class="form-group">
        Rest id:
	    <input type="text" name="rest_id" value="${rest1[0].resturantId}" class="form-control" readonly/>
      </div>
      <div class="form-group">
         Menu Item :
		<input type="text" name="menu_item" class="form-control" required/>
      </div>
      <div class="form-group">
       Menu Price :
		<input type="text" name="menu_price" class="form-control" required/>
      </div>
      <div class="form-group">
        Menu Type  :
		
		<select name="menu_type" class="form-control" required>
		  <option value="Veg">Veg</option>
		  <option value="NonVeg">NonVeg</option>
		  <option value="Bread">Bread</option>
		</select>
      </div>
      <input type="submit" value ="Add"  class="btn btn-success"/>
      </form>
      <c:if test="${param.menu_item != null }">
	<jsp:useBean id="beanMenu" class="com.infinite.can.Menu" />
	<jsp:setProperty property="*" name="beanMenu"/>
	<c:out value="${beanDao.AddMenu(beanMenu)}"/>
</c:if>
     </div>
  </div>
</div>


	
	
</body>
</html>