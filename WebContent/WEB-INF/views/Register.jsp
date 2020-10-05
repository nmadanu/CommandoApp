<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
	<script type="text/javascript">
		 function validate(){
			var userName = document.register.userName.value;
		    var emailID = document.register.emailID.value;
		    var phone = document.register.phone.value;
		    var password = document.register.password.value;
		    var title = document.register.title.value;
		    var interestedTopic = document.register.interestedTopic.value;
		    var repassword = document.register.repassword.value;
		    var phoneregex = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
		    var re = /\S+@\S+\.\S+/;
		    
		    if(userName.length < 6){
		    	alert("User Name must be atleast 6 characters long");
		    	return false;
		    }else if(emailID == null || emailID == ""){
		    	alert("Email ID can't be blank");
		    	return false;
		    }else if(!re.test(emailID)){
		    	alert("Enter a valid emailID");
		    	return false;
		    }else if(phone == null || phone == ""){
		    	alert("Phone number can't be blank");
		    	return false;
		    }else if((phone.length < 6) || (!phoneregex.test(phone))){
		    	alert("Enter a valid phone number");
		    	return false;
		    }else if(password.length < 6 ){
		    	alert("Password must be atleast 6 characters long.");
		    	return false;
		    }else if(password != repassword){
		    	alert("Confirm the password doesn't match the real password");
		    	return false;
		    }else if(title == null || title == ""){
		    	alert("Title can't be blank");
		    	return false;
		    }else if(title != "Study" && title != "Job"){
		    	alert("Title has to be Study or Job");
		    	return false;
		    }else if(interestedTopic == null || interestedTopic == ""){
		    	alert("Please select a topic");
		    	return false;
		    }
		    
		    return true;
		}
	</script>

</head>
<body>
	<h2>Register the USER</h2>
	<form name="register" action="${pageContext.request.contextPath}/registeruser" method="post" onsubmit="return validate()">
	
	<table align="center">
		<tr>
			<td>USER NAME</td>
			<td><input type="text" name="userName" /></td>
		</tr>
		<tr>
			<td>PASSWORD</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td>RETYPE PASSWORD</td>
			<td><input type="password" name="repassword" /></td>
		</tr>
		<tr>
			<td>EMAIL ID</td>
			<td><input type="email" name="emailID" /></td>
		</tr>
		<tr>
			<td>PHONE</td>
			<td><input type="text" name="phone" /></td>
		</tr>
		<tr>
			<td>TITLE(Study or Job)</td>
			<td><input type="text" name="title" /></td>
		</tr>
		<tr>
			<td>Interested Topic</td>
			<td>
				<select name="interestedTopic">
					<c:forEach items="${topicList}" var="product">
     					<option value="${product}">${product}</option>
     				</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td><%=(request.getAttribute("errorMessage") == null) ? "" : request.getAttribute("errorMessage") %></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Register" /><input type="reset" value="Reset" /></td>
		</tr>
	</table>
	
	</form>
	
</body>
</html>