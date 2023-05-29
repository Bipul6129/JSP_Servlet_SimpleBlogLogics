<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="re-usable/checkLoggedin.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); %>
	<h1>Welcome to Blog site</h1>
	<form action="login" method="post">
		Enter username:<input type="text" name="username"/>
		Enter password:<input type="password" name="password"/>
		<input type="submit"/>
	</form>
</body>
</html>