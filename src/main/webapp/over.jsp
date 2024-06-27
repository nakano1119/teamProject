<%@page import="model.entity.TimeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<TimeBean> overList = (List) request.getAttribute("overList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>over</title>
</head>
<body>
	<h1>残業管理</h1>
	<form action="over" method="post">
		<label for="employeeId">社員番号</label> <input type="employeeId"
			name="employeeId" required>
		<button type="submit">検索</button>
	</form>
	<form action="menu.jsp" method="get">
		<input type="submit" value="戻る">
	</form>
</body>
</html>