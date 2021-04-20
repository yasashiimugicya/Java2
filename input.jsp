<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>input</title>
	</head>
	<body>
		<p>セッションに登録されている値</p>
		<%
			// セッションスコープの情報
			String sessionData = (String)session.getAttribute("data");
		%>
		<p>セッションスコープの値：<%=sessionData%></p>
		<br/>
		<p>セッションに登録する情報を入力してください</p>
		<form action="SessionServlet" method="post">
			<input type="text" name="input"/><br/>
			<input type="submit" value="送信">
		</form>
		<p>セッションのデータを破棄します</p>
		<form action="SessionServlet">
			<input type="submit" value="破棄">
		</form>
	</body>
</html>