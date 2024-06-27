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
		<h1>編集</h1>
		<form action="edit" method="post">
			<div>
				<p>
					日付：<%=time.getDate()%></p>
			</div>
			<div>
				<label for="startTime">出勤時間</label> <input type="time"
					name="startTime" id="startTime"
					value="<%=time.getStartTime().toString().substring(0, 5)%>">
			</div>
			<div>
				<label for="endTime">退勤時間</label> <input type="time"
					name="endTime" id="endTime"
					value="<%=time.getEndTime().toString().substring(0, 5)%>">
			</div>
			<div>
				<label for="overTime">残業時間</label> <input type="time"
					name="overTime" id="overTime"
					value="<%=time.getOverTime().toString().substring(0, 5)%>">
			</div>
			<div>
				<button type="submit">更新</button>
				<input type="hidden" name="id" value="<%=time.getId()%>"> <input
					type="hidden" name="date" value="<%=time.getDate()%>">
			</div>
		</form>
		<form action="list" method="get">
			<input type="submit" value="戻る">
		</form>
	</div>
</body>
</html>