package settings;

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

@WebServlet(urlPatterns = "/deleteUser.do")
public class deleteUser extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String connectionURL = "jdbc:mysql://localhost:3306/pc-web-database";
		Connection connection = null;
		Statement statement = null;
		String username = (String) request.getSession().getAttribute("username");
		 
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				connection = DriverManager.getConnection(connectionURL, "root","");
				statement = connection.createStatement();
				String sql="DELETE FROM `users` WHERE `username` LIKE '"+username+"'";
				System.out.println( sql);
				statement.executeUpdate(sql);
				response.sendRedirect("/logout.do");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
