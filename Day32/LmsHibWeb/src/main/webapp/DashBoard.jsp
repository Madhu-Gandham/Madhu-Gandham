<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<body>
<h1>My Details</h1>
<c:set var="empId" value="${param.id}"/>
<c:set var="mgrId" value="${param.mid}"/>
<jsp:useBean id="beanDao" class="com.infinite.lmshib.EmployDAO"/>
<jsp:useBean id="leaveDao" class="com.infinite.lmshib.LeaveHistoryDAO"/>
<c:set var="myDetails" value="${beanDao.searchEmploy(empId)}"/>  
Employ Id: <b>
<c:out value="${myDetails.empId} "></c:out>
</b>
<br/><br/>
Employ Name: <b>
${myDetails.empEmail}<br/><br/>
</b>
Employ Mobile NO:<b>
${myDetails.empMobile}<br/><br/>
</b>
Employ Date Of Join:<b>
${myDetails.empDoj}<br/><br/>
</b>
Employ Department:<b>
${myDetails.empDept}<br/><br/>
</b>
Employ ManagerId:<b>
${myDetails.mgrId}<br/><br/>
</b>
Employ LeaveAvailable:<b>
${myDetails.leaveAvail}<br/><br/>
</b>
<c:if test="${mgrId==' '}">
<b> No Manager For You...</b>
</c:if>

<c:if test="${mgrId!=' '}">
<c:set var="myManagerDetils" value="${beanDao.searchEmploy(mgrId)}"></c:set>
<h1> My Manager Details</h1>
Employ Id: <b> 
<c:out value="${myManagerDetils.empId}"> </c:out> <br/><br/>
</b>
Employ Name:<b>
${myManagerDetils.empName}<br/><br/>
</b>
Employ Email:<b>
${myManagerDetils.empEmail}<br/><br/>
</b>
Employ Mobile No:<b>
${myManagerDetils.empMobile}<br/><br/>
</b>
Employ Date Of Join:<b>
${myManagerDetils.empDoj}<br/><br/>
</b>
Employ Department:<b>
${myManagerDetils.empDept}<br/><br/>
</b>
Employ Manager Id:<b>
${myManagerDetils.mgrId}<br/><br/>
</b>
Employ LeaveBalance:<b>
${myManagerDetils.leaveAvail}<br/><br/>
</b>
</c:if>
<c:out value="${empId }"></c:out>
<h1> My Leave History</h1>

<table border="3" align="center">

<tr>

<th>Leave Id</th>

<th>No of Days</th>

<th>Manager Comments</th>

<th>Employ Id</th>

<th>Leave StartDate</th>

<th>Leave EndDate</th>

<th>Leave Type</th>

<th>Leave Status</th>

<th>Leave Reason</th>

</tr>

<c:out value="${empId}"></c:out>
<c:forEach var="lh" items="${leaveDao.showLeaveHistory(empId)}">

<tr>

<td>

<c:out value="${lh.leaveId }"></c:out>

</td>

<td>

<c:out value="${lh.leaveNoOfDays}"></c:out>

</td>

<td>

<c:out value="${lh.managerComments}"></c:out>

</td>

<td>

<c:out value="${lh.empId}"></c:out>

</td>

<td>

<c:out value="${lh.leaveStartDate}"></c:out>

</td>

<td>

<c:out value="${lh.leaveEndDate}"></c:out>

</td>

<td>

<c:out value="${lh.leaveType}"></c:out>

</td>

<td>

<c:out value="${lh.leaveStatus}"></c:out>

</td>

<td>

<c:out value="${lh.leaveType}"></c:out>

</td>

<td>

<c:out value="${lh.leaveStatus}"></c:out>

</td>

</c:forEach>

</table>

       <hr/>

       <h1> My SubOrdinates Pending Leaves</h1>  

       <table border="3" align="center">

       <tr>

       <tr>

<th>Leave Id</th>

<th>No of Days</th>

<th>Manager Comments</th>

<th>Employ Id</th>

<th>Leave StartDate</th>

<th>Leave EndDate</th>

<th>Leave Type</th>

<th>Leave Status</th>

<th>Leave Reason</th>

</tr>

<jsp:useBean id="beanleave" class="com.infinite.lmshib.LeaveHistoryDAO"/>

<c:forEach var="lh" items="${beanLeave.pendingLeaves(empId)}">

<tr>

<td>

<c:out value="${lh.leaveId }"></c:out>

</td>

<td>

<c:out value="${lh.leaveNoOfDays}"></c:out>

</td>

<td>

<c:out value="${lh.managerComments}"></c:out>

</td>

<td>

<c:out value="${lh.empId}"></c:out>

</td>

<td>

<c:out value="${lh.leaveStartDate}"></c:out>

</td>

<td>

<c:out value="${lh.leaveEndDate}"></c:out>

</td>

<td>

<c:out value="${lh.leaveType}"></c:out>

</td>

<td>

<c:out value="${lh.leaveStatus}"></c:out>

</td>

<td>

<c:out value="${lh.leaveType}"></c:out>

</td>

<td>

<c:out value="${lh.leaveStatus}"></c:out>

</td>

</c:forEach>

       </table>

</body>
</html>
