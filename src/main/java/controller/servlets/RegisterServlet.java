package controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import model.StudentModel;


@WebServlet(asyncSupported = true, urlPatterns = { "/RegisterServlet" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	DatabaseController dbController = new DatabaseController();
	
    public RegisterServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter printOut = response.getWriter();
		response.setContentType("text/html");
		printOut.print("Hello World!");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String dobString = request.getParameter("dob");
		LocalDate dob = LocalDate.parse(dobString);
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone_number = request.getParameter("phoneNumber");
		String subject = request.getParameter("subject");
		String password = request.getParameter("password");
		String retypePassword = request.getParameter("retypePassword");
		
		System.out.println(username+" "+firstname+" "+lastname+" "+dob+" "+gender+" "+ email+" "+phone_number+" "+subject+" "+username+" "+password);
		StudentModel studentModel = new StudentModel(firstname, lastname, dob, gender, email, phone_number, subject, username, password);
		
		int result = dbController.addStudent(studentModel);
		
		if(result>0) {
			response.sendRedirect(request.getContextPath() + "/pages/login.html");
		} else {
			response.sendRedirect(request.getContextPath() + "/pages/error.html");
		}
		
	}

}
