<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="students">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Age</td>
			<td>Department</td>
		</tr>
		<c:forEach var="student" items="${students}">
			<tr>
				<td><c:out value="${student.id}"></c:out></td>
				<td><c:out value="${student.name}"></c:out></td>
				<td><c:out value="${student.age}"></c:out></td>
				<td><c:out value="${student.department}"></c:out></td>
				<td><a href="${pageContext.request.contextPath}/students/edit/${student.id}"> Edit</a></td>
				<td><a href="${pageContext.request.contextPath}//students/delete/${student.id}"> Delete</a></td>
			</tr>
		</c:forEach>
	</table>

<a href="${pageContext.request.contextPath}/"> Home</a>
</body>
</html>