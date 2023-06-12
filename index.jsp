<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Logout</title>
  <script>
    function confirmLogout() {
      if (confirm("Are you sure you want to logout?")) {
        var logoutMessage = document.getElementById("logoutMessage");
        logoutMessage.innerText = "Logging out...";//it seems a logout message will be progresss

        // Perform logout action here
        // Replace the code below with your logout logic
        setTimeout(function() {
          window.location.href = "login.jsp"; // Replace with the desired logout URL
        }, 2000); // Set a timeout of 2 seconds (adjust as needed)
      }
    }
  </script>
</head>
<body>
  <h1>Logout Page</h1>
  <%-- Add the following line to display the confirmation message --%>
  <% if (request.getParameter("confirm") != null) { %>
    <p>Are you sure you want to logout?</p>
  <% } %>
  <p id="logoutMessage"></p>

  <!-- Include your menu here -->
  <div class="menu">
    <!-- your menu code -->
    <button onclick="confirmLogout()">Logout</button>
  </div>
</body>
</html>
