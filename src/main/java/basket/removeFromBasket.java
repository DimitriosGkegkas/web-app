package basket;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(urlPatterns = "/remove-to-basket.do")
public class removeFromBasket  extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String connectionURL = "jdbc:mysql://localhost:3306/pc-web-database";
		Connection connection = null;
		Statement statement = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection = DriverManager.getConnection(connectionURL, "root","");
			statement = connection.createStatement();
			String sql="SELECT * FROM `products` WHERE `id` LIKE '"+request.getParameter("item")+"'";
			System.out.println(request.getParameter("item"));
			ResultSet rs=statement.executeQuery(sql);
			rs.next();
			System.out.println(request.getParameter("item"));
			basket basket=(basket) request.getSession().getAttribute("basket");
			
			System.out.println(basket);
			basket.removeFromBasket(new item(rs.getString("title") ,request.getParameter("item"),rs.getFloat("price")));
			request.getSession().setAttribute("basket", basket);
		} catch ( SQLException e) {
			System.err.println("Got an exception!!!");
			System.err.println(e.getMessage());
		}
		PrintWriter writer = response.getWriter();
		String item=request.getParameter("item");
		basket basket=(basket) request.getSession().getAttribute("basket");
		for(Pair<item, Integer> product : basket.retrieveBasket()) {
			System.out.println(item);
			String id=product.getItem().getId();
			System.out.println("yessss");
			if(id.equals(item)) {
				System.out.println("yessss");
				writer.write("	<td>"+product.getItem().getName()+"</td>\r\n" + 
						"		<td>"+product.getItem().getPrice()+"</td>\r\n" + 
						"		<td>"+product.getAmount()+"</td>\r\n" + 
						"		<td class=\"buttons\">\r\n" + 
						"		<a class=\"btn btn-outline-success\" onClick=\"removeFromBasketAjax("+product.getItem().getId()+")\">-</a> \r\n" + 
						"		<a class=\"btn btn-outline-danger\" onClick=\"deleteFromBasketAjax("+product.getItem().getId()+")\">Delete</a>\r\n" + 
						"		</td>");
			
			    break;
			}
		}
		writer.close();
	
	}
	
}
