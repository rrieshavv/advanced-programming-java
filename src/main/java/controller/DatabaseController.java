package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseController {
	public Connection getConnection() throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:/mysql//localhost:3131/college_app";
		String user = "root";
		String pass = "";
		return DriverManager.getConnection(url, user, pass);
	}
}
