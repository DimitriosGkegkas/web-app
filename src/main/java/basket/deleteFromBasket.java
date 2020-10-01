package basket;

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

import items.item;

@WebServlet(urlPatterns = "/delete-to-basket.do")
public class deleteFromBasket  extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String connectionURL = "jdbc:mysql://localhost:3306/pc-web-database";
		Connection connection = null;
		Statement statement = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection = DriverManager.getConnection(connectionURL, "root","");
			statement = connection.createStatement();
			String sql="SELECT * FROM `products` WHERE `id` LIKE '"+request.getParameter("item")+"'";
			ResultSet rs=statement.executeQuery(sql);
			rs.next();

			basket basket=(basket) request.getSession().getAttribute("basket");
			if(basket==null) {
				basket=new basket();
			}
			
			System.out.println(basket);
			basket.deleteFromBasket(new item(rs.getString("title") ,request.getParameter("item"),rs.getFloat("price")));
			request.getSession().setAttribute("basket", basket);
		} catch ( SQLException e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		
		response.sendRedirect("/basket.do");
	}
	
}
