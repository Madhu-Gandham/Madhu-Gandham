<%@page import="java.io.IOException"%>
<%@page import="com.infinite.Library.AdminDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reset Password</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <style>
        body {
            background-color: #F8F8F8;
        }
            h1 {
        text-align: center;
        margin-top: 50px;
        margin-bottom: 30px;
    }

    form {
        width: 50%;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 60px;
        box-shadow: 0px 0px 10px #ccc;
    }

    label {
        font-weight: bold;
        font-size: 16px;
    }

    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: none;
        border-radius: 5px;
        box-shadow: 0px 0px 5px #ccc;
    }

    input[type="submit"] {
        background-color: #007bff;
        color: #fff;
        border: none;
        border-radius: 5px;
        padding: 10px 20px;
        font-size: 16px;
        cursor: pointer;
    }

    .error {
        color: red;
        margin-bottom: 10px;
    }

    .success {
        color: green;
        margin-bottom: 10px;
    }
    .button-container {
  display: flex;
  justify-content: flex;
  gap: 10px;
}

.btn {
  flex: 1;
  max-width: 150px;
}
    
</style>
<script src="https://cdnjs.cloudflare.com/ajax/libs/zxcvbn/4.4.2/zxcvbn.js"></script>
<script>
function checkPasswordStrength() {
    var password = document.getElementById("password").value;
    var result = zxcvbn(password);

    var strengthMeter = document.getElementById("password-strength-meter");
    var strengthText = document.getElementById("password-strength-text");
    
    strengthMeter.value = result.score;
    
    if (result.score === 0) {
        strengthText.style.color = "red";
        strengthText.innerHTML = "Password is very weak";
    } else if (result.score === 1) {
        strengthText.style.color = "red";
        strengthText.innerHTML = "Password is weak";
    } else if (result.score === 2) {
        strengthText.style.color = "orange";
        strengthText.innerHTML = "Password is medium";
    } else if (result.score === 3) {
        strengthText.style.color = "green";
        strengthText.innerHTML = "Password is strong";
    } else {
        strengthText.style.color = "green";
        strengthText.innerHTML = "Password is very strong";
    }
}

</script>
</head>
<body>
    <div class="container">
   
        <h1>Reset Password</h1>

	<c:if test="${not empty error}">
		<div style="color: red;">${error}</div>
	</c:if>

	<form method="post" action="resetpassword.jsp">
		<label for="username">Username:</label>
		<input type="text" name="username" required><br><br>

		<label for="password">New Password:</label>
		<input type="password" name="password" id="password" onkeyup="checkPasswordStrength()" required>
		<progress id="password-strength-meter" max="4" value="0"></progress>
		<p id="password-strength-text"></p><br><br>

		<label for="confirmPassword">Confirm Password:</label>
		<input type="password" name="confirmPassword" required><br><br>
		<span id="passwordMatch"></span><br>
		<span id="passwordMatchMessage" style="color:red;"></span>
		<br>
		<%
    if(request.getParameter("confirmPassword") != null) {
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        if(!password.equals(confirmPassword)) {
            out.println("<script>");
            out.println("document.getElementById('passwordMatchMessage').innerHTML = 'New Password does not match with confirmpassword.';");
            out.println("</script>");
        }
    }
%>
  <div class="button-container">
  <input type="submit" class="btn btn-dark" value="Reset Password" />
  <a href="login1.jsp" class="btn btn-dark">Back</a>
</div>


	</form>

	<c:if test="${not empty message}">
		<div style="color: green;">${message}</div>
	</c:if>
		</div>
<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String confirmPassword = request.getParameter("confirmPassword");

	if (password != null && password.equals(confirmPassword)) {
		if (AdminDAO.isUserExist(username)) {
			AdminDAO.resetPassword(username, password);
			request.setAttribute("message", "Password changed successfully");
			response.sendRedirect("login1.jsp");
			return;
		} else {
			request.setAttribute("error", "User does not exist");
		}
	} else {
		request.setAttribute("error", "Passwords do not match");
	}
%>

</body>
</html>
