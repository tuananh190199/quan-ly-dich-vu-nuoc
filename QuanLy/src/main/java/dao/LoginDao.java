package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import control.Login;
import model.QuanLy;


public class LoginDao extends dao{
	Connection connection = dao.getConnection();
	
	public QuanLy checkLogin(String username, String password) {
		String sql = "SELECT * FROM user_ WHERE user_name = ? AND password = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				QuanLy q = new QuanLy(rs.getInt(1),rs.getString(2),rs.getString(3));
				return q;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		LoginDao l = new LoginDao();
		QuanLy q = l.checkLogin("a", "a");
		System.out.println(q);
	}
}
