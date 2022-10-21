<%@page import="com.infinite.hib.Agent"%>
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
<form method="get" action="searchAgent.jsp">
	<center>
		Enter Agent ID :
		<input type ="text" name ="agentId" /><br/><br/>
		<input type="submit" value ="Search" />
	</center>

</form>


 <%   
if(request.getParameter("agentId")!= null){
 AgentDAO dao = new AgentDAO();
String  id = request.getParameter("agentId");
 Agent agent = dao.searchAgent(id);
 %> 
 <table border="3" align="center">
 <tr> 
		<th>AgentId</th>
		<th>AgentName</th>
		<th>AgentCity</th>
		<th>AgentGender</th>
		<th>Agent MaritalStatus</th>
		<th>Agent premium</th>
	</tr>
	<tr> 
		<td><%=agent.getAgentId()%></td>
		<td><%=agent.getName() %></td>
		<td><%=agent.getCity() %></td>
		<td><%=agent.getGender() %></td>
		<td><%=agent.getMaritalStatus() %></td>
		<td><%=agent.getPremium()%></td>
		
	</tr>
	</table>
 <%} %>
</body>
</html>