<%@page import="model.entity.TimeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
TimeBean time = (TimeBean) request.getAttribute("time");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠編集</title>
</head>
<body>
	<div>
		<h1>以下の勤怠情報を削除します。</h1>
		<form action="delete" method="post">
			<div>
				<p>
					日付：<%=time.getDate()%></p>
			</div>
			<div>
				<p>
					出勤時間：<%=time.getStartTime()%></p>
			</div>
			<div>
				<p>
					退勤時間：<%=time.getEndTime()%></p>
			</div>
			<div>
				<p>
					残業時間：<%=time.getOverTime()%></p>
			</div>
			<div>
				<button type="submit">削除</button>
				<input type="hidden" name="id" value="<%=time.getId()%>">
			</div>
		</form>
		<form action="list" method="get">
			<input type="submit" value="戻る">
		</form>
	</div>
</body>
</html>