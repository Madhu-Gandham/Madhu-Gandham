<%@page import="com.infinite.studenthib.SubjectsDAO"%>
<%@page import="com.infinite.studenthib.CourseList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	CourseList courseList = new CourseList();
	courseList.setCourseNo(request.getParameter("courseId"));
	courseList.setDuration(Integer.parseInt(request.getParameter("duration")));
	java.sql.Date sDate = java.sql.Date.valueOf(request.getParameter("startDate")); 
	java.sql.Date eDate = java.sql.Date.valueOf(request.getParameter("endDate"));
	courseList.setStartDate(sDate);
	courseList.setEndDate(eDate);
	courseList.setHod(request.getParameter("hod"));
	SubjectsDAO obj = new SubjectsDAO();
	obj.addCourse(courseList);
%>
</body>
</html>