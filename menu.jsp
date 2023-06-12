<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Welcome MainMenu Page</title>
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

  <!-- Custom CSS -->
  <style type="text/css">
  
    .navbar {
      background-color:  #FDAC53;
    }
    .navbar-brand, .nav-link {
      color: #000000;
    }
    .nav-link:hover {
      color: #d56d2d;
    }
    .content {
      padding: 20px;
    }
  </style>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-light">
    <a class="navbar-brand" href="#">
      Welcome MainMenu Page
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="account-detail.jsp">Account Details</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="search-issue-dropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Search/Issue Panel
          </a>
          <div class="dropdown-menu" aria-labelledby="search-issue-dropdown">
            <a class="dropdown-item" href="search-print.jsp">Book Issued</a>
            <a class="dropdown-item" href="search.jsp">No Book Issued</a>
          </div>
        </li>
        
        <!--  <li class="nav-item">
          <a class="nav-link" href="search.jsp">Search Panel</a>
        </li> -->
        
        <li class="nav-item">
          <a class="nav-link" href="return.jsp">Return</a>
        </li>
              <ul class="navbar-nav ml-auto">
        <li class="nav-item">
 <a class="nav-link" href="#" onclick="confirmLogout()">Home</a>        </li>
      </ul>
        <li class="nav-item">
          <a class="nav-link" href="history.jsp">History</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="book-request-form.xhtml">Book-Req-Form</a>
        </li>
         <li class="nav-item">
          <a class="nav-link" href="login1.jsp">Adminstartor Panel</a>
        </li>
 
 <!-- <li class="nav-item dropdown">
    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      Administartor Panel
    </a>
    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
      <a class="dropdown-item" href="addbook.xhtml">Add Book</a>
      <a class="dropdown-item" href="Update.xhtml">Update Book</a>
      <a class="dropdown-item" href="delete.xhtml">Delete Book</a>
      <a class="dropdown-item" href="AddUser.xhtml">Add User</a>
    </div>
  </li> -->
</ul>

      
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
 <a class="nav-link" href="#" onclick="confirmLogout()">Logout</a>        </li>
      </ul>
      <!-- Modal HTML -->
<div id="logoutModal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Confirmation</h4>
      </div>
      <div class="modal-body">
        <p>Are you sure you want to logout?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
        <button type="button" class="btn btn-primary" onclick="logout()">Logout</button>
      </div>
    </div>
  </div>
</div>
     
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script>
  function confirmLogout() {
    // Show the modal dialog
    $('#logoutModal').modal('show');
  }
  
  function logout() {
    // Redirect to the logout page
    window.location.href = "login.jsp"; // Replace with the desired logout URL
  }
</script>
    </div>
  </nav>
  <div class="content">
    <h1>Welcome <%= session.getAttribute("user") %></h1>
    <!-- page content goes here -->
  </div>
  <!-- jQuery and Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
