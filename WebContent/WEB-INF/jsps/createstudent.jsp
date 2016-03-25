<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/docreate">
	<table class="form-table">
		
		 <tr><td class="label">Name: </td> <td><input name="name" type="text"/> </td></tr>
		 <tr><td class="label">Age: </td> <td><input name="age" type="text"/> </td></tr>
		 <tr><td class="label">Department: </td> <td><textarea class="text-area" name="department" rows="10" cols="10"></textarea> </td></tr>
		 <tr><td class="label"> </td> <td><input class="create-button" value="Register Student" type="submit"/> </td></tr>
	</table>
</form>


</body>
</html>