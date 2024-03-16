package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import model.StudentModel;

public class DatabaseController {
	public Connection getConnection() throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3131/college_app";
		String user = "root";
		String pass = "";
		return DriverManager.getConnection(url, user, pass);
	}
	
	public int addStudent(StudentModel studentModel)
	{
		try(Connection con= getConnection())
		{
			PreparedStatement st = con.prepareStatement(util.StringUtils.INSERT_STUDENT);
			
			
			st.setString(1, studentModel.getFirstname());
			st.setString(2, studentModel.getLastname());
			st.setDate(3, Date.valueOf(studentModel.getDob()));
			st.setString(4, studentModel.getGender());
			st.setString(5, studentModel.getEmail());
			st.setString(6, studentModel.getPhoneNumber());
			st.setString(7, studentModel.getSubject());
			st.setString(8, studentModel.getUsername());
			st.setString(9, studentModel.getPassword());

			int result = st.executeUpdate();
			return result > 0 ? 1 : 0;
			
		} catch (SQLException | ClassNotFoundException ex)
		{
			ex.printStackTrace();
			return -1;
		}
	}
	
	public int getStudentLoginInfo(String username, String password) {
		try(Connection con= getConnection())
		{
			PreparedStatement st = con.prepareStatement(util.StringUtils.GET_LOGIN_STUDENT_INFO);
			
			st.setString(0, username);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return 1;
			} 
			
			return 0;
			
			
		} catch (SQLException | ClassNotFoundException ex)
		{
			ex.printStackTrace();
			return -1;
		}
	}
}
