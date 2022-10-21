<%@page import="com.infinite.hib.Agent"%>
<%@page import="com.infinite.hib.AgentDAO"%>

<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AgentDAO dao = new AgentDAO();
List<Agent> agentList = dao.showAgent();
%>
<table border="3" align="center">
<tr>
<th>AgentId</th>
<th>Name</th>
<th>City</th>
<th>Gender</th>
<th>MaritalStatus</th>
<th>Premium</th>
</tr>
<%
for(Agent agent : agentList) {
%>
<tr>
<td>
<%=agent.getAgentId() %>
</td>
<td>
<%=agent.getName() %>
</td>
<td>
<%=agent.getCity() %>
</td>
<td>
<%=agent.getMaritalStatus() %>
</td>
<td>
<%=agent.getPremium() %>
</td>
</tr>
<%
}
%>
</table>
</body>
</html>
