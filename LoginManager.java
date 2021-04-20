package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginManager {

	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public LoginUser login(String id, String password) {

		LoginUser loginUser = null;
		try {
			getConnection();

			String sql = "SELECT * FROM login_user";
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("id").equals(id) &&
					rs.getString("password").equals(password)) {
					loginUser = new LoginUser(id, password);
				}
			}

			close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return loginUser;
	}

	private void getConnection()
		throws ClassNotFoundException, SQLException {

		if(con == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url  = "jdbc:mysql://localhost/user";
			String user = "root";
			String password = "";

			con = DriverManager.getConnection(url, user, password);
		}
	}

	private void close() throws SQLException {
		if (con != null) {
			con.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (rs != null) {
			rs.close();
		}
	}
}