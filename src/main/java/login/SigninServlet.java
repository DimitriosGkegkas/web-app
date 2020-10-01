package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basket.basketServlet;

import java.util.logging.Logger;

@WebServlet(urlPatterns = "/signIn.do")
public class SigninServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		String name =request.getParameter("name");
		String surname =request.getParameter("surname");
		String birthday =request.getParameter("birthday");
		basketServlet database= new basketServlet();
		String connectionURL = "jdbc:mysql://localhost:3306/pc-web-database";
		Connection connection = null;
		Statement statement = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection = DriverManager.getConnection(connectionURL, "root","");
			statement = connection.createStatement();
		
		String sql="INSERT INTO `users` (`username`, `name`, `surname`, `birthday`, `password`) VALUES ('"+username+"', '"+name+"', '"+surname+"', '"+birthday+"', '"+password+"');";
	

	
			
				int result= statement.executeUpdate(sql);
				System.out.print(result);
				response.sendRedirect("/login.do");
			} catch (SQLException e) {
				   System.err.println("Got an exception!");
				      System.err.println(e.getMessage());
			}
		
	}
}
