<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="beanDao" class="com.infinite.payroll.EmployDAO"/>

	<form method="get" action="PaySlip.jsp">

		Enter Empno : 
		<input type="number" name="empno"/><br/> <br/>
		Enter Month :
		 <input type="number" name="month" /><br/> <br/> 
		<input type="submit" value="submit"/><br/><br/>

	
	<c:if test="${param.empno != null && param.month != null}">

		<c:set var="id" value="${param.empno}"/>
		<c:set var="month" value="${param.month}"/>
		<c:out value="${beanDao.payslip(id,month)}"/>
	
	<table>
		<tr>
			<th></th>
			<th></th>
		</tr>
		<tr>
			<td>Earnings
				<hr>
			</td>
			<td>Deduction
				<hr>
			</td>
		</tr>
		<tr>
			<td>BASIC:${employ.salary}</td>
			<td>PF:${employ.pf}</td>
		</tr>
		<tr>
			<td>HRA:${employ.hra}</td>
			<td>Tax:${employ.tax}</td>
		</tr>
		<tr>
			<td>DA:${employ.da}</td>
			<td>LOSS Of Pay:${pay}</td>
		</tr>
		<tr>
			<td>TA:${employ.ta}</td>

		</tr>

		<tr>
			<td><hr>Total Earning: ${employ.gross}
				<hr></td>
			<td><hr>Total Deduction:<c:out
					value="${employ.pf+employ.tax+pay }" />
				<hr></td>
		</tr>
		<tr>
			<c:set var="total" value="${employ.pf+employ.tax+pay }" />
			<td>Net Pay :<c:out value="${employ.gross-total}" /></td>
		</tr>

	</table>
	</c:if>
	</form>

</body>
</html>
