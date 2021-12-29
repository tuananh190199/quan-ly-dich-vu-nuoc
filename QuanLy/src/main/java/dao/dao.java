package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class dao {
	public static Connection getConnection() {
		String user_name = "sa";
		String Pass = "123456";
		String URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=quanly;";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, user_name, Pass);
		} catch (Exception ex) {

			ex.printStackTrace();
		}
		return connection;
	}
	public static void main(String[] args) {
	System.out.println(dao.getConnection());
	}
}
