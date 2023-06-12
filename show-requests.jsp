<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Show Requests</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            padding: 20px;
        }            
    </style>
</head>
<body>
    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
                <th scope="col" data-type="number">Id <span class="sort-arrow">&darr;</span><span class="sort-arrow">&uarr;</span></th>
                <th scope="col" data-type="string">Teacher Name <span class="sort-arrow">&darr;</span><span class="sort-arrow">&uarr;</span></th>
                <th scope="col" data-type="string">Book Title <span class="sort-arrow">&darr;</span><span class="sort-arrow">&uarr;</span></th>
                <th scope="col" data-type="string">Reason <span class="sort-arrow">&darr;</span><span class="sort-arrow">&uarr;</span></th>
                <th scope="col" data-type="string">Status<span class="sort-arrow">&darr;</span><span class="sort-arrow">&uarr;</span></th>
                <th scope="col" data-type="string">Action <span class="sort-arrow">&darr;</span><span class="sort-arrow">&uarr;</span></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${BookRequestDAO.getAllBookRequest()}" var="request">
                <tr>
                    <td>${request.id}</td>
                    <td>${request.teacher_name}</td>
                    <td>${request.book_title}</td>
                    <td>${request.reason}</td>
                    <td id="status${request.id}">${request.status}</td>
                    <td>
                        <div class="dropdown">
                            <button class="btn btn-primary dropdown-toggle" type="button" id="statusDropdown${request.id}" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Action
                            </button>
                            <div class="dropdown-menu" aria-labelledby="statusDropdown${request.id}">
                                <c:choose>
                                    <c:when test="${request.status == 'approved'}">
                                        <a class="dropdown-item disabled">Approved</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="dropdown-item" href="#" onclick="updateStatus(${request.id}, 'approved'); return false;">Approved</a>
                                    </c:otherwise>
                                </c:choose>
                                <a class="dropdown-item" href="#" onclick="updateStatus(${request.id}, 'rejected'); return false;">Rejected</a>
                            </div>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
     <div class="container">
     <a class="btn btn-primary" href="adminpanel.jsp">Back</a>
	  </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        function updateStatus(id, status) {
            $.ajax({
                url: 'ApproveRequestServlet',
                type: 'GET',
                data: {
                    id: id,
                    status: status
                },
                dataType: 'json',
                success: function(response) {
                    // Update the UI based on the response
                    if (response.status === 'approved') {
                        $('#status' + id).text('approved');
                        $('#statusDropdown' + id).closest('.dropdown').find('.dropdown-toggle').addClass('disabled');
                    } else if (response.status === 'rejected') {
                        $('#status' + id).text('rejected');
                        $('#statusDropdown' + id).closest('.dropdown').find('.dropdown-toggle').addClass('disabled');
                    }
                },
                error: function(xhr, status, error) {
                    // Handle the error case
                }
            });
        }

        const sortableColumns = document.querySelectorAll("th[scope='col']");

        // Loop through each sortable column
        sortableColumns.forEach(column => {
            // Add a click event listener to each column
            column.addEventListener("click", () => {
                const dataType = column.getAttribute("data-type"); // string or number
                const currentOrder = column.getAttribute("data-order"); // asc or desc
                let newOrder;

                // Determine the new sorting order
                if (currentOrder === "asc") {
                    newOrder = "desc";
                } else if (currentOrder === "desc") {
                    newOrder = "asc";
                } else {
                    // Default to ascending order
                    newOrder = "asc";
                }

                // Update the column data-order attribute with the new sorting order
                column.setAttribute("data-order", newOrder);

                // Get all the rows in the table body
                const rows = Array.from(document.querySelectorAll("tbody tr"));

                // Create an array of objects representing each row
                const rowObjects = rows.map(row => {
                    const cells = Array.from(row.querySelectorAll("td"));
                    const values = cells.map(cell => {
                        let value = cell.textContent.trim();

                        // Parse the value if it's a number
                        if (dataType === "number") {
                            value = parseFloat(value);
                        }

                        return value;
                    });

                    return {
                        row: row,
                        values: values
                    };
                });

                // Sort the row objects based on the specified column or columns
                rowObjects.sort((a, b) => {
                    const aData = a.values[column.cellIndex];
                    const bData = b.values[column.cellIndex];

                    if (dataType === "string") {
                        // Sort alphabetically using localeCompare() for strings
                        if (newOrder === "asc") {
                            return aData.localeCompare(bData, undefined, { numeric: true, sensitivity: "base" });
                        } else {
                            return bData.localeCompare(aData, undefined, { numeric: true, sensitivity: "base" });
                        }
                    } else if (dataType === "number") {
                        // Sort numerically for numbers
                        if (newOrder === "asc") {
                            return aData - bData;
                        } else {
                            return bData - aData;
                        }
                    }

                    // Default comparison
                    return 0;
                });

                // Remove all the existing rows
                const tbody = document.querySelector("tbody");
                while (tbody.firstChild) {
                    tbody.removeChild(tbody.firstChild);
                }

                // Add the sorted rows back to the table
                rowObjects.forEach(rowObject => {
                    tbody.appendChild(rowObject.row);
                });
            });
        });
    </script>
</body>
</html>
