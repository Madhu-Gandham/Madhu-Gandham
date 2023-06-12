<%@page import="java.io.IOException"%>
<%@page import="com.infinite.Library.ForgotPasswordDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

	function validateForm() {
		var password = document.getElementById("password").value;
		var confirmPassword = document.getElementsByName("confirmPassword")[0].value;
		var passwordMatchMessage = document.getElementById("passwordMatchMessage");
		var regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8}$/;

		if (!regex.test(password)) {
			passwordMatchMessage.innerHTML = "New Password should be exactly 8 characters long, including one uppercase letter, one lowercase letter, one digit, and one special character.";
			return false;
		}

		if (password !== confirmPassword) {
			passwordMatchMessage.innerHTML = "New Password does not match with Confirm Password.";
			return false;
		}

		return true;
	}
</script>
</head>
<body>
	<div class="container">
		<h1>Reset Password</h1>

		<c:if test="${not empty error}">
			<div style="color: red;">${error}</div>
		</c:if>

		<form method="post" action="reset-password.jsp" onsubmit="return validateForm()">
			<label for="username">Username:</label>
			<input type="text" name="username" required><br><br>

			<label for="securityQuestion">Security Question:</label>
			<select name="securityQuestion" required>
				<option value="">Select a security question</option>
				<option value="color">color</option>
				<option value="What is your pet's name?">What is your pet's name?</option>
				<option value="What is your mother's name?">What is your mother's name?</option>
				<!-- Add more security questions here -->
			</select><br><br>

			<label for="securityAnswer">Security Answer:</label>
			<input type="text" name="securityAnswer" required><br><br>

			<label for="password">New Password:</label>
			<input type="password" name="password" id="password" required oninput="checkPasswordStrength()">
			<br>
			<progress id="password-strength-meter" max="4" value="0"></progress>
			<p id="password-strength-text"></p>
			<br>

			<label for="confirmPassword">Confirm Password:</label>
			<input type="password" name="confirmPassword" required>
			<br>
			<span id="passwordMatch"></span><br>
			<span id="passwordMatchMessage" style="color: red;"></span>
			<br>

			<div class="button-container">
				<input type="submit" class="btn btn-dark" value="Reset Password" />
				<a href="login.jsp" class="btn btn-dark">Back</a>
			</div>
		</form>

		<c:if test="${not empty message}">
			<div style="color: green;">${message}</div>
		</c:if>
	</div>

	<%
	String username = request.getParameter("username");
	String securityQuestion = request.getParameter("securityQuestion");
	String securityAnswer = request.getParameter("securityAnswer");
	String password = request.getParameter("password");
	String confirmPassword = request.getParameter("confirmPassword");

	if (password != null && password.equals(confirmPassword)) {
		if (ForgotPasswordDAO.isUserExist(username) && ForgotPasswordDAO.isSecurityAnswerCorrect(username, securityQuestion, securityAnswer)) {
			ForgotPasswordDAO.resetPassword(username, password);
			request.setAttribute("message", "Password changed successfully");
			response.sendRedirect("login.jsp");
			return;
		} else {
			request.setAttribute("error", "User does not exist or security answer is incorrect");
		}
	} else {
		/* request.setAttribute("error", "Passwords do not match"); */
	}
	%>

	<!-- Modify the code above to display the error message -->

	<% if (request.getAttribute("error") != null) { %>
	<div style="text-align: center; color: red;">
		<p><%= request.getAttribute("error") %></p>
	</div>
	<% } %>
</body>
</html>
