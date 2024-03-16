package practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/MyFirstServlet" })
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printOut = response.getWriter();
		response.setContentType("text/html");
		printOut.print("Hello World!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter printOut = response.getWriter();
		
		String name = request.getParameter("userName");
		String age = request.getParameter("userAge");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3131/college_app";
			String user = "root";
			String pass = "";
			Connection con = DriverManager.getConnection(url, user, pass);
			
			String query = "Insert into test_table (name, age) value(?,?)";
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, name);
			st.setString(2, age);
			
			int result = st.executeUpdate();
			if(result > 0)
			{
				printOut.println("<h1>Your account is register as</h1>");
				printOut.println("<h3>Name: "+name+"</h3>");
				printOut.println("<h3>Age: "+age+"</h3>");
			}
			else 
			{
				printOut.println("<h1>Sorry! Your data is not resgistered.</h1>");
			}
		}
		catch (SQLException | ClassNotFoundException ex)
		{
			printOut.println("<h1>Please enter the correct data!</h1>");
		}
	}

}
