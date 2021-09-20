<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bug Tracking Home Page</title>
</head>
<body>
	<h3>Home</h3>

	<a href="${pageContext.request.contextPath}/list">Bug Report</a>
	<br><br>
	<a href="${pageContext.request.contextPath}/admin">Go to administration page</a>
	<br><br>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>