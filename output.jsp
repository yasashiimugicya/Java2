<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>output</title>
	</head>
	<body>
		<p>セッションに登録されている値</p>
		<%
			// セッションスコープの情報
			String sessionData = (String)session.getAttribute("data");
		%>
		<p>セッションスコープの値：<%=sessionData%></p>
		<br/>
		<a href="input.jsp">input画面に戻る</a>
	</body>
</html>