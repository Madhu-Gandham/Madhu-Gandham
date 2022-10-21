<%@page import="com.infinite.hib.AgentDAO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <form method="get" action="DeleteAgent.jsp">
    <center>
    Enter AgentId;
    <input type="text" name="agentId" /><br/><br/>
    <input type="submit" value ="Delete" />
    </center>
  </form>
  <%
  if(request.getParameter("agentId")!= null){
  AgentDAO dao = new AgentDAO();
  String id = request.getParameter("agentId");
  dao.deleteAgent(id);
  }
  %>
</body>
</html>