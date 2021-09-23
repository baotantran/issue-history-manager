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

	<form:form action="saveBugInformation" modelAttribute="bugInformation" method="POST">
	<form:hidden path="id"/>
		<table>
			<tr>
				<td><label>Bug Summary</label></td>
				<td><form:input path="bugSummary"/></td>
			</tr>
			<tr>
				<td><label>Bug Detail</label></td>
				<td><form:input path="bugDetail"/>
					<form:errors path="bugDetail" style="color:red"></form:errors>
				</td>
			</tr>
			<tr>
				<td><label>Bug Resolver</label></td>
				<td><form:input path="bugResolver"/></td>
			</tr>
		</table>
		<input type="submit" value="Save">
	
	</form:form>
	<br><br>
	<a href="${pageContext.request.contextPath}/">Back to home page</a>

</body>
</html>