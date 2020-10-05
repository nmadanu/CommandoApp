<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
</head>
<body>
	<h2>Home Page</h2>
	<h4><span style="color:red"><%=(request.getAttribute("regMessage") == null) ? "" : request.getAttribute("regMessage")%> </span></h5>
	<br><br>
	<h3>Please <a href="<%=request.getContextPath()%>/loginuser">Login</a> to continue..</h3>
	<h3>Please <a href="<%=request.getContextPath()%>/registeruser">Register</a> to get more news..</h3>
</body>
</html>