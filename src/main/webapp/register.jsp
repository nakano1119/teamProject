<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if (error != null) {
	%>
	<%=error%></p>
	<%
	}
	%>
	<h2>登録</h2>
	<form action="register" method="post">
		<label for="employeeId">社員番号</label> <input type="employeeId"
			name="employeeId" required> <br> <label for="employeeId">日付</label>
		<input type="date" name="date" required> <br> <label
			for="startTime">出勤時間</label> <input type="time" name="startTime"
			required> <br> <label for="endTime">退勤時間</label> <input
			type="time" name="endTime" required> <br> <label
			for="overTime">残業時間</label> <input type="time" name="overTime"
			required> <br> <input type="submit" value="登録">
	</form>
	<form action="menu.jsp" method="get">
		<input type="submit" value="戻る">
	</form>
</body>
</html>