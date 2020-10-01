package basket;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import items.item;
import items.items;

@WebServlet(urlPatterns = "/country.do")
public class countryServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		basket basket=(basket) request.getSession().getAttribute("basket");
		String connectionURL = "jdbc:mysql://localhost:3306/pc-web-database";
		Connection connection = null;
		Statement statement = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection = DriverManager.getConnection(connectionURL, "root","");
			statement = connection.createStatement();
			String sql="SELECT * FROM `tax` WHERE `country` LIKE '"+request.getParameter("country")+"'";
			ResultSet rs=statement.executeQuery(sql);
			rs.next();
			basket.setTax((Float)rs.getFloat("tax"));
			request.getSession().setAttribute("basket", basket);
			
	}catch (Exception e) {
		// TODO: handle exception
	}
		response.sendRedirect("/basket.do");
	}
}
