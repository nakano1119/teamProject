<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<h1>ログイン</h1>
	<form action="login" method="post">
		<div>
			<label for="name">name</label> <input type="text" name="name"
				id="name">
		</div>
		<div>
			<label for="password">password</label> <input type="password"
				name="password" id="password">
		</div>
		<button type="submit">ログイン</button>
	</form>
	<%
	if (error != null) {
	%>
	<%=error%></p>
	<%
	}
	%>
</body>
</html>