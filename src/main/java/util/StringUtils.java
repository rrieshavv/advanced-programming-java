package util;

public class StringUtils {
	//Start the SQL Queries 
	public static final String INSERT_STUDENT = 
			"insert into student_info (username, firstname, lastname, dob, gender, email, phone_number, subject, password) values (?,?,?,?,?,?,?,?,?)";

	public static final String GET_LOGIN_STUDENT_INFO = "select username, password from student_info";
	
	public static final String GET_ALL_STUDENT_INFO = "select * from student_info";

}
