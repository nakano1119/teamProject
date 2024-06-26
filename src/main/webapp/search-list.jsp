<%@page import="model.entity.TimeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<TimeBean> timeList = (List) request.getAttribute("timeList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>search-list</title>
</head>
<body>
	<h1>勤怠一覧</h1>
	<form action="list" method="post">
		<div>
			<label for="date">日付</label> <input type="date" name="date" required>
		</div>
		<button type="submit">検索</button>
	</form>
	<table>
		<thead>
			<tr>
				<th>出勤時間</th>
				<th>退勤時間</th>
				<th>残業時間</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<%
			for (TimeBean time : timeList) {
			%>
			<tr>
				<td><%=time.getStart_time()%></td>
				<td><%=time.getEnd_time()%></td>
				<td><%=time.getOver_time()%></td>
				<td><a href="time-edit?id=<%=time.getId()%>">編集</a></td>
				<td><a href="time-delete?id=<%=time.getId()%>">削除</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>