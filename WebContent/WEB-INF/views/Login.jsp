<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<script type="text/javascript">
		 function validate(){
			var userName = document.logdetails.userName.value;
		    var password = document.logdetails.password.value;
		    
		    if(userName == null || userName == ""){
		    	alert("User Name can't be blank");
		    	return false;
		    }else if(password == null || password == "" ){
		    	alert("Password can't be blank");
		    	return false;
		    }
		    
		    return true;
		}
	</script>
</head>
<body>
	<form name="logdetails" action="<%=request.getContextPath()%>/loginuser" method="post" onsubmit="return validate()">
		<table align="center">
			<tr>
				<td>UserName</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%> </span></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>