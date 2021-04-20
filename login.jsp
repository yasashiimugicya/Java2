<%@page import="model.LoginUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	<body>
		<h1>ユーザ管理</h1>
		<%
			String message = (String)request.getAttribute("message");
			LoginUser loginUser = (LoginUser)session.getAttribute("login");
			if (message != null) {
		%>
			<p><%=message%></p>
		<%
			}
		%>
		<h2>ログイン</h2>
		<p>IDとパスワードを入力してください</p>
		<form action="LoginServlet" method="post">
			ID:<input type="text" name="id"/><br/>
			Password:<input type="password" name="password"/><br/>
			<input type="submit" value="ログイン"/>
		</form>
		<%
			if(loginUser != null) {
		%>
			<p>ユーザID:<%=loginUser.getId()%>でログイン中です</p>
			<h2>ログアウト</h2>
			<form action="LoginServlet">
				<input type="submit" value="ログアウト"/>
			</form>
		<%
			}
		%>
	</body>
</html>