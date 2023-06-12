<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-4 mx-auto">
				<form method="post" action="ForgotPasswordServlet">
					<div class="form-group">

						<input type="text" name="username" class="form-control"
							placeholder="Enter user name" required />
					</div>
					<div class="form-group">

						<input type="password" id="pwd" name="password"
							class="form-control" placeholder="Enter Password" required />
						<p id="msg" style="color: red;"></p>
					</div>
					<div class="form-group">

						<input type="password" id="cpwd" name="confirmpassword"
							class="form-control" placeholder="Enter Confirm Password"
							required />
						<p id="cpwd-msg" style="color: red;"></p>
					</div>
					<input type="submit" value="Submit" class="btn btn-dark"
						id="submit-btn" disabled>
				</form>
				<c:if test="${not empty param.username}">
					<c:set var="dao"
						value="${new com.infinite.Library.ForgotPasswordDAO()}" />
					<c:set var="username" value="${param.username}" />
					<c:set var="password" value="${param.password}" />
					<c:set var="confirmpassword" value="${param.confirmpassword}" />
					<c:choose>
						<c:when test="${dao.isUserExist(username)}">
							<c:set var="result"
								value="${dao.resetPassword(username, password)}" />
							<c:if test="${result == 'Changed Successfully'}">
								<h5 style="color: green; text-align: center;">Password
									changed successfully</h5>
							</c:if>
						</c:when>
						<c:otherwise>
							<h5 style="color: red; text-align: center;">User name not
								found</h5>
						</c:otherwise>
					</c:choose>
				</c:if>
			</div>
		</div>
	</div>
	<script>
$(function(){
  $("#pwd").on("input", function(){
    var pss=$("#pwd").val();
    if (pss.match(/[a-z]/g) && pss.match(
        /[A-Z]/g) && pss.match(
        /[0-9]/g) && pss.match(
        /[^a-zA-Z\d]/g) && pss.length >=8 && pss.length <=15){
      $("#msg").html(""); 
      checkSubmit();
    }else{
      $("#msg").html("Invalid Password. Take password with 1 capital letter, 1 special letter, minimum length 8 and maximum length 15."); 
      disableSubmit();
    }
  });
  $("#cpwd").on("input", function(){
    var pss=$("#pwd").val();
    var cpss=$("#cpwd").val();

    if(pss !== cpss){
      $("#cpwd-msg").html("**Password not matched"); 
      disableSubmit();
    }
}else{
$("#cpwd-msg").html("");
checkSubmit();
}
});

function disableSubmit(){
$("#submit-btn").attr("disabled","disabled");
}

function checkSubmit(){
if($("#msg").html() == "" && $("#cpwd-msg").html() == ""){
$("#submit-btn").removeAttr("disabled");
}
}
});
</script>

</body>
</html>