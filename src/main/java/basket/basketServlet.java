package basket;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import items.item;


@WebServlet(urlPatterns = "/basket.do")
public class basketServlet extends HttpServlet{
	protected basket basket;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String connectionURL = "jdbc:mysql://localhost:3306/pc-web-database";
		Connection connection = null;
		Statement statement = null;
		List<String> countries=new ArrayList<String>();
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection = DriverManager.getConnection(connectionURL, "root","");
			statement = connection.createStatement();
			String sql="SELECT * FROM `tax` ";
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				countries.add(rs.getString("country"));
				System.out.println(rs.getString("country"));
			}
			request.setAttribute("countries", countries);
		request.getRequestDispatcher("/WEB-INF/views/basket.jsp").forward(request, response);
		}catch (Exception e) {

		}
	}
}
