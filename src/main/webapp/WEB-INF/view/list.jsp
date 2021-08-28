<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<th>Bug Summary</th>
			<th>Bug Detail</th>
			<th>Bug Resolver</th>
		<tr>
		<c:forEach var="bug" items="${bugList}">
		 	<tr>
		 		<td>${bug.bugSummary}</td>
		 		<td>${bug.bugDetail}</td>
		 		<td>${bug.bugResolver}</td>
		 	</tr>
		</c:forEach>
		
		
	</table>

</body>
</html>