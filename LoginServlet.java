package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginManager;
import model.LoginUser;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(
		HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.invalidate();

		request.setAttribute("message", "ログアウトしました");

		RequestDispatcher rd =
			request.getRequestDispatcher("login.jsp");

		rd.forward(request, response);
	}

	protected void doPost(
		HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		LoginManager loginManager = new LoginManager();
		LoginUser loginUser = loginManager.login(id, password);

		if(loginUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", loginUser);
			request.setAttribute("message", "ログインしました");
		} else {
			request.setAttribute("message", "ログインできませんでした");
		}

		RequestDispatcher rd =
			request.getRequestDispatcher("login.jsp");

		rd.forward(request, response);
	}
}