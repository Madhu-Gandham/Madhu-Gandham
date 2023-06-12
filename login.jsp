<%@page import="com.infinite.Library.Books"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.apache.logging.log4j.LogManager" %>
<%@ page import="org.apache.logging.log4j.Logger" %>
<%! private static final Logger logger = LogManager.getLogger(Books.class); %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">
 <style>
    body {
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      height: 100vh;
    }
    
    .content {
      flex: 1;
      text-align: center;
    }
    
    .alert-container {
      margin-top: 20px;
      text-align: center;
    }
  </style>
<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="main">
    <!-- Sing in Form -->
    <section class="sign-in">
        <div class="container">
            <div class="signin-content">
                <div class="signin-image">
                    <figure>
                        <img src="images/signin-image.jpg" alt="sing up image">
                    </figure>
                    <a href="AddUser.xhtml" class="signup-image-link">Create an account</a>
                </div>

                <div class="signin-form">
                    <h2 class="form-title">Login-form</h2>
                    <form method="" action="" class="register-form" id="login-form">
                       <div class="form-group">
    <label for="username"><i class="zmdi zmdi-account material-icons-name"></i></label>
    <input type="text" name="username" id="username" placeholder="Your Name" />
</div>
<div class="form-group">
    <label for="password"><i class="zmdi zmdi-lock"></i></label>
    <input type="password" name="password" id="password" placeholder="Password" />
</div>
<div class="alert alert-danger" id="errorMsg" role="alert" style="color: red; display: none;"></div>

                       <!--  <div class="alert alert-danger" role="alert" style="color: red;">Invalid username or password!</div> -->
                        <div class="form-group">
                            <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                            <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
                        </div>
                       <div class="form-group form-button">
    <input type="submit" name="signin" id="signin" class="form-submit" value="Log in" onclick="validateForm(event)" />
</div>
                    </form>
                    <div class="form-group">
                        <a href="reset-password.jsp" class="forgot-password">Forgot Password</a>
                    </div>
                    <div class="social-login">
                        <span class="social-label">Or login with</span>
                        <ul class="socials">
                            <li><a href="#"><i class="display-flex-center zmdi zmdi-facebook"></i></a></li>
                            <li><a href="#"><i class="display-flex-center zmdi zmdi-twitter"></i></a></li>
                            <li><a href="#"><i class="display-flex-center zmdi zmdi-google"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

		<c:if test="${param.username != null && param.password != null }">
			<jsp:useBean id="beanLibUsers" class="com.infinite.Library.LibUsers" />
			<jsp:setProperty property="*" name="beanLibUsers" />
			<jsp:useBean id="beanDAO" class="com.infinite.Library.LibraryDAO" />
			<c:set var="user" value="${param.username }" />
			<c:set var="password" value="${param.password }" />
			<c:set var="count" value="${beanDAO.loginCheck(user, password) }" />
			<c:if test="${count==1}">
				<c:set var="user" value="${user}" scope="session" />
				<jsp:forward page="menu.jsp" />
			</c:if>
			<c:if test="${count!=1}">
			<%
    String user = request.getParameter("username");
    String errorMsg = "Invalid username or password: " + user;
    logger.error(errorMsg);
%>
			
<div class="alert-container">
    <div class="alert alert-danger" role="alert" style="color: red;">
      Invalid username or password!
    </div>
			</c:if>
		</c:if>
	</div>
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script>
    function validateForm(event) {
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var errorMsg = document.getElementById("errorMsg");

        if (username === "") {
            errorMsg.innerText = "Please enter a username.";
            errorMsg.style.display = "block";
            event.preventDefault();
        } else if (password === "") {
            errorMsg.innerText = "Please enter a password.";
            errorMsg.style.display = "block";
            event.preventDefault();
        } else {
            errorMsg.style.display = "none";
        }
    }
</script>
</body>
</html>
