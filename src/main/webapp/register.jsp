<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>登録</h2>
	<form action="register" method="post">
		<label for="employee_id">社員番号</label> <input type="employee_id"
			name="employee_id" required> <br> <label
			for="employee_id">日付</label> <input type="date" name="date" required>
		<br> <label for="start_time">出勤時間</label> <input type="time"
			name="start_time" required> <br> <label for="end_time">退勤時間</label>
		<input type="time" name="end_time" required> <br> <label
			for="over_time">残業時間</label> <input type="time" name="over_time"
			required> <br> <input type="submit" value="登録">
	</form>
	<form action="menu.jsp" method="get">
		<input type="submit" value="戻る">
	</form>
</body>
</html>