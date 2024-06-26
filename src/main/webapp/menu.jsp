<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menu</title>
</head>
<body>
	<h1>メニュー</h1>
	<div>
		<form action="register.jsp" method="GET">
			<button type="submit" name="register">登録</button>
		</form>
		<form action="over.jsp" method="GET">
			<button type="submit" name="over">残業管理</button>
		</form>
		<form action="list" method="GET">
			<button type="submit" name="list">勤怠一覧</button>
		</form>
		<form action="logout" method="GET">
			<button type="submit" name="logout">ログアウト</button>
		</form>
	</div>
</body>
</html>