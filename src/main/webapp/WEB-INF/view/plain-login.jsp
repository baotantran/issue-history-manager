<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<title>My Login Page</title>

<!--  style sheet -->
<style type="text/css">
	.failed {
		color: red;
	}
	
	.success {
		color: green;
	}
</style>
<!-- style sheet end -->

</head>


<body>
<h3>
	My Custom Login Form
</h3>
	<form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
	<c:if test="${param.error != null}">
		<i class="failed"> username/password is incorrect</i>
	</c:if>
	<c:if test="${param.logout != null}">
		<i class="success"> log out succesfully</i>
	</c:if>
	<input type="hidden" 
		name="${_csrf.parameterName}"
		value="${_csrf.token}">
		<p>
		User name: <input type="text" name="username">
		</p>
		
		<p>
		Password: <input type="password" name="password">
		</p>
		
		<input type="submit" value="Login">
	</form>
	


</body>


</html>