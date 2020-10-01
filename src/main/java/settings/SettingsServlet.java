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

@WebServlet(urlPatterns = "/settings.do")
public class SettingsServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if(request.getSession().getAttribute("username")!=null) {
			String connectionURL = "jdbc:mysql://localhost:3306/pc-web-database";
			Connection connection = null;
			Statement statement = null;
			String username = (String) request.getSession().getAttribute("username");
			 
				try {
					DriverManager.registerDriver(new com.mysql.jdbc.Driver());
					connection = DriverManager.getConnection(connectionURL, "root","");
					statement = connection.createStatement();
					String sql="SELECT * FROM `users` WHERE `username` LIKE '"+username+"'";
					ResultSet rs=statement.executeQuery(sql);
					rs.next();
					request.setAttribute("name", rs.getString("name"));
					request.setAttribute("surname", rs.getString("surname"));
					request.setAttribute("birthday", rs.getDate("birthday"));
					request.getRequestDispatcher("/WEB-INF/views/pageUpdate.jsp").forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		else {
			response.sendRedirect("/login.do");
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String connectionURL = "jdbc:mysql://localhost:3306/pc-web-database";
		Connection connection = null;
		Statement statement = null;
		String name=(String) request.getParameter("name");
		String surname=(String) request.getParameter("surname");
		String birthday=(String) request.getParameter("birthday");
		String username = (String) request.getSession().getAttribute("username");
		 
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				connection = DriverManager.getConnection(connectionURL, "root","");
				statement = connection.createStatement();
				String sql="UPDATE  `users` SET name= '"+name+"', surname='"+surname+"' ,birthday='"+birthday+"' WHERE `username` LIKE '"+username+"'";
				System.out.println( sql);
				statement.executeUpdate(sql);
				response.sendRedirect("/settings.do");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
