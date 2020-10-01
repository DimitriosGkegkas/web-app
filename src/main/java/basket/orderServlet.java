package basket;

import java.io.File;
import java.io.FileWriter;
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

@WebServlet(urlPatterns = "/placeOrder.do")
public class orderServlet  extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if(request.getSession().getAttribute("username")!=null) {
			basket basket=(basket) request.getSession().getAttribute("basket");
			String connectionURL = "jdbc:mysql://localhost:3306/pc-web-database";
			Connection connection = null;
			Statement statement = null;
			String username=(String) request.getSession().getAttribute("username");
			FileWriter myWriter;
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				connection = DriverManager.getConnection(connectionURL, "root","");
				statement = connection.createStatement();
				File myObj = new File("orders/"+username+".txt");
				if(myObj.createNewFile()) {
					myWriter = new FileWriter("orders/"+username+".txt",true);
					myWriter.write("user, product, quantity\n");
				}
				else {
					myWriter = new FileWriter("orders/"+username+".txt",true);
				}
				for(Pair<item, Integer> temp : basket.retrieveBasket()) {
					String sql="INSERT INTO `orders` (`user`, `product`, `quantity`) VALUES ('"+ request.getSession().getAttribute("username")+"', '"+temp.getItem().getId()+"', '"+temp.getAmount()+"')";
					myWriter.write(username+", "+temp.getItem().getId()+", "+temp.getAmount()+"\n");
					statement.executeUpdate(sql);
				}
				myWriter.close();
				request.getSession().setAttribute("basket",  new basket());
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
			response.sendRedirect("/basket.do");
	
	}
	else {
		response.sendRedirect("/login.do");
	}
	}
}

	