<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<sf:form method="post" modelAttribute="student" action="${pageContext.request.contextPath}/students/update/${student.id}" >
	<table class="form-table">
		 <tr><td class="label">Name: </td> <td><sf:input path="name" name="name" type="text" value="${student.name}" /> </td></tr>
		 <tr><td class="label">Age: </td> <td><sf:input path="age" name="age" type="text" value="${student.age}" /> </td></tr>
		 <tr><td class="label">Department: </td> <td><sf:textarea class="text-area" path="department" name="department" rows="10" cols="10"></sf:textarea> </td></tr>
		 <tr><td class="label"> </td> <td><input class="create-button" value="Update Student" type="submit"/> </td></tr>
	</table>
</sf:form>
</body>
</html>