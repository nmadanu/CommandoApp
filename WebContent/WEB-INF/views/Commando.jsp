<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN PAGE</title>
<% if((request.getSession(false).getAttribute("Commando") == null))
{
	%>
	<jsp:forward page="/WEB-INF/views/Login.jsp"></jsp:forward>
<%} %>	
</head>
<body>
	<center><h2>COMMANDO PAGE</h2></center>
	Welcome <%=request.getAttribute("userName") %> <br><br>
	<h3>Details</h3><br><br>
	<h4>${commando.emailID}</h4><br><br>
	<h4>${commando.phone}</h4><br><br>
	<h4>${commando.title}</h4><br><br>
	<h4>${commando.interestedTopic}</h4><br><br>
	
	<div style="text-align: right"><a href="<%=request.getContextPath()%>/logoutuser">Logout</a></div>
 
</body>
</html>