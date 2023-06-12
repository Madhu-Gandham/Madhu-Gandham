<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Panel</title>
    <style>
        .container {
            text-align: center;
        }

        .navbar {
            background-color: #936c6c;
            padding: 10px;
        }

        .navbar ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
            display: flex;
            justify-content: center;
        }

        .navbar li {
            margin: 0 10px;
        }

        .navbar li a {
            display: block;
            padding: 10px;
            color: #ffffff;
            text-decoration: none;
        }

        .navbar li a:hover {
            background-color: #286090;
        }

        .admin-content {
            margin-top: 20px;
        }
        
        body {
            background-image: url("https://www.pixel-studios.com/blog/wp-content/uploads/2018/12/012.jpg");
            background-position: center center;
            background-size: cover;
            height: 100vh;
            width: 100%;
        }
    </style>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
</head>
<body>
    <div class="container">
        <h1>Admin Panel</h1>

        <div class="navbar">
            <ul>
                <li><a href="addbook.xhtml">Add Book</a></li>
                <li><a href="Showbooks.jsp">Update Book</a></li>
                <li><a href="delete.xhtml">Delete Book</a></li>
                <li><a href="AddUser.xhtml">Add User</a></li>
                <li><a href="show-requests.jsp">Show Requests</a></li>
                <li><a href="#" onclick="confirmLogout()">Logout</a></li>
            </ul>
        </div>

        <div class="admin-content">
            <!-- Content goes here -->
        </div>
    </div>

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

    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Bootstrap JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <script>
        function confirmLogout() {
            // Show the modal dialog
            $('#logoutModal').modal('show');
        }

        function logout() {
            // Redirect to the logout page
            window.location.href = "login1.jsp"; // Replace with the desired logout URL
        }
    </script>
</body>
</html>
