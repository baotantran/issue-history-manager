<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administration Page</title>
</head>
<body>

	<input type="button" value="Add New Bug" onclick="window.location.href='showFormForAdd'; return false;">

	<br><br>

	<table>
		<tr>
			<th>Bug Summary</th>
			<th>Bug Detail</th>
			<th>Bug Resolver</th>
		<tr>
		<c:forEach var="bug" items="${bugList}">
		<c:url var="update" value="/updateBugInformation">
			<c:param name="bugId" value="${bug.id}"></c:param>
		</c:url>
		<c:url var="delete" value="/deleteBugInformation">
			<c:param name="bugId" value="${bug.id}"></c:param>
		</c:url>
		 	<tr>
		 		<td>${bug.bugSummary}</td>
		 		<td>${bug.bugDetail}</td>
		 		<td>${bug.bugResolver}</td>
		 		<td><a href="${update}">Update</a></td>
		 		<td><a href="${delete}"
		 				onclick="if(!(confirm('Are you sure you want to delete this item?'))) return false">Delete</a></td>
		 	</tr>
		</c:forEach>
		
		
	</table>
	
	<br>
	
	<a href="${pageContext.request.contextPath}/">Back to home page</a>
	
	<br><br>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout">
	</form:form>

</body>
</html>