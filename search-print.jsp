<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Library</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-DfkpXzj7VxHQvWyDdKj/vHEamBfrRtTcTj+cILpzYVP8vp9gOT4MWq4xvtsAUpMl"
	crossorigin="anonymous">

<!-- Bootstrap Icons -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	integrity="sha384-cL6e+ByPcEwpH9X0hUz07xU5Z6U5Z6U5Z6U5Z6U5Z6U="
	crossorigin="anonymous">

<!-- Bootstrap JS -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HkXgHJmkZp1sdZ+czvTmOXlhTtT0Jv1DzYd8O9Xujq3xEMBtjJWtO8A2+0V7QwMv"
	crossorigin="anonymous" type="text/javascript"></script>
<style>
.search-form {
	display: flex;
}

.search-form form {
	margin-right: 10px;
}
</style>
</head>
<body>
	<jsp:include page="menu.jsp" /><br />
	<c:set var="author"
		value="${not empty param.author ? param.author : ''}" />
	<c:set var="dept" value="${not empty param.dept ? param.dept : ''}" />
	<c:set var="sort"
		value="${not empty param.sort ? param.sort : 'author_asc'}" />
	<jsp:useBean id="beanDao" class="com.infinite.Library.LibraryDAO" />

	<br />
	<h3>Search for books:</h3>
	<div class="search-form">
		<form id="authorForm" action="" method="get">
			<input type="hidden" name="page" value="1" />
			<div class="form-group">
				<label for="author">Author:</label> <input type="text"
					class="form-control" name="author" id="authorField"
					value="${author}" required /> <span class="error-message"
					id="authorError"></span>
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-primary" name="search"
					value="Filter by Author" onclick="validateAuthorField(event)" /> <input
					type="reset" class="btn btn-secondary" value="Reset"
					onclick="resetFields()" />
			</div>
		</form>

		<form id="deptForm" action="" method="get">
			<input type="hidden" name="page" value="1" />
			<div class="form-group">
				<label for="dept">Department:</label> <input type="text"
					class="form-control" name="dept" id="deptField" value="${dept}"
					required /> <span class="error-message" id="deptError"></span>
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-primary" name="search"
					value="Filter by Department" onclick="validateDeptField(event)" />
				<input type="reset" class="btn btn-secondary" value="Reset"
					onclick="resetFields()" />
			</div>
		</form>
	</div>
	<br />
	<form action="issue.jsp" method="post">
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th scope="col" data-type="number">Id <span class="sort-arrow">&darr;</span><span
						class="sort-arrow">&uarr;</span></th>
					<th scope="col" data-type="string">Name<span
						class="sort-arrow">&darr;</span><span class="sort-arrow">&uarr;</span></th>
					<th scope="col" data-type="string">Author <span
						class="sort-arrow">&darr;</span><span class="sort-arrow">&uarr;</span></th>
					<th scope="col" data-type="number">Edition<span
						class="sort-arrow">&darr;</span><span class="sort-arrow">&uarr;</span></th>
					<th scope="col" data-type="string">Department<span
						class="sort-arrow">&darr;</span><span class="sort-arrow">&uarr;</span></th>
					<th scope="col" data-type="number">Total Books<span
						class="sort-arrow">&darr;</span><span class="sort-arrow">&uarr;</span></th>
					<th scope="col">Select</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="book"
					items="${beanDao.searchBooks(param.author, param.dept, param.sort)}"
					varStatus="status">
					<tr class="book-row"
						style="display: ${status.index < 10 ? '' : 'none'};">
						<td>${book.id}</td>
						<td>${book.name}</td>
						<td>${book.author}</td>
						<td>${book.edition}</td>
						<td>${book.dept}</td>
						<td>${book.totalBooks}</td>
						<c:if test="${book.totalBooks > 0}">
							<td><input type="checkbox" name="bookid" value="${book.id}" /></td>
						</c:if>
					</tr>
				</c:forEach>

				<!-- Display message when no records are found -->
				<c:if
					test="${empty beanDao.searchBooks(param.author, param.dept, param.sort)}">
					<p style="color: red; text-align: center;">No books found in
						the record.</p>
				</c:if>
			</tbody>
		</table>
		<button type="submit" class="btn btn-primary" name="issue">Issue
			Selected Books</button>
		<a class="btn btn-primary" href="menu.jsp">Back</a>
	</form>
	<script>
  // Get all the sortable columns
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

        // Sort alphabetically using localeCompare() for strings
        // and subtract the numbers for numbers
        return dataType === "string" ? aData.localeCompare(bData) : aData - bData;
      });

      // Reverse the order if the current order is descending
      if (currentOrder === "desc") {
        rowObjects.reverse();
      }

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
 
  const itemsPerPage = 10; // Number of items to display per page
  let currentPage = 1; // Current page number

  // Get all the rows in the table body
  const rows = Array.from(document.querySelectorAll("tbody tr"));

  // Calculate the number of pages
  const totalPages = Math.ceil(rows.length / itemsPerPage);

  // Function to display the specified page
  function displayPage(pageNumber) {
    // Calculate the start and end index for the current page
    const startIndex = (pageNumber - 1) * itemsPerPage;
    const endIndex = pageNumber * itemsPerPage;

    // Hide all the rows
    rows.forEach(row => {
      row.style.display = "none";
    });

    // Display the rows for the current page
    const rowsToDisplay = rows.slice(startIndex, endIndex);
    rowsToDisplay.forEach(row => {
      row.style.display = "";
    });
  }

  // Function to create the pagination links
  function createPaginationLinks() {
    const paginationContainer = document.createElement("div");
    paginationContainer.classList.add("pagination");

    // Create the previous page link
    const previousLink = document.createElement("a");
    previousLink.href = "#";
    previousLink.textContent = "Previous";
    paginationContainer.appendChild(previousLink);

    // Create the page links
    for (let i = 1; i <= totalPages; i++) {
      const pageLink = document.createElement("a");
      pageLink.href = "#";
      pageLink.textContent = i;
      paginationContainer.appendChild(pageLink);
    }

    // Create the next page link
    const nextLink = document.createElement("a");
    nextLink.href = "#";
    nextLink.textContent = "Next";
    paginationContainer.appendChild(nextLink);

    // Add the pagination container after the table 
    const table = document.querySelector("table");
    table.parentNode.insertBefore(paginationContainer, table.nextSibling);

    // Add click event listeners to the page links
    const pageLinks = document.querySelectorAll(".pagination a");
    pageLinks.forEach(pageLink => {
      pageLink.addEventListener("click", event => {
        event.preventDefault();

        if (event.target.textContent === "Previous") {
          currentPage -= 1;
        } else if (event.target.textContent === "Next") {
          currentPage += 1;
        } else {
          currentPage = parseInt(event.target.textContent);
        }

        // Ensure the current page stays within the valid range
        currentPage = Math.max(1, Math.min(totalPages, currentPage));

        // Update the active class for the page links
        pageLinks.forEach(link => {
          link.classList.remove("active");
        });
        pageLinks[currentPage].classList.add("active");

        // Display the current page
        displayPage(currentPage);
      });
    });

    // Display the first page by default
    displayPage(currentPage);
  }

  // Create the pagination links
  createPaginationLinks();
  
  function validateAuthorField(event) {
      var authorField = document.getElementById("authorField");
      var authorError = document.getElementById("authorError");
      if (authorField.value === "") {
          authorError.innerText = "Author Name is required.";
          event.preventDefault();
      } else {
          authorError.innerText = "";
      }
  }

  function validateDeptField(event) {
      var deptField = document.getElementById("deptField");
      var deptError = document.getElementById("deptError");
      if (deptField.value === "") {
          deptError.innerText = "Dept Name is required.";
          event.preventDefault();
      } else {
          deptError.innerText = "";
      }
  }

  function resetFields() {
      var authorField = document.getElementById("authorField");
      var deptField = document.getElementById("deptField");
      var authorError = document.getElementById("authorError");
      var deptError = document.getElementById("deptError");
      authorField.value = "";
      deptField.value = "";
      authorError.innerText = "";
      deptError.innerText = "";
  }
</script>
</body>
</html>


