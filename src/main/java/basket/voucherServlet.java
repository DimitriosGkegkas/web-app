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

@WebServlet(urlPatterns = "/voucher.do")
public class voucherServlet  extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String connectionURL = "jdbc:mysql://localhost:3306/pc-web-database";
		Connection connection = null;
		Statement statement = null;
		basket basket=(basket) request.getSession().getAttribute("basket");
		String voucher=(String) request.getParameter("voucher");
		System.out.println("2");
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection = DriverManager.getConnection(connectionURL, "root","");
			statement = connection.createStatement();
			String sql="SELECT * FROM `vouchers` WHERE `voucher` LIKE '"+voucher+"'";

			ResultSet rs=statement.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()) {
				System.out.println(rs.getFloat("discount"));
				basket.setDiscount(rs.getFloat("discount"));
			}
	     }	
		catch (Exception e) {
			// TODO: handle exception
		}
		response.sendRedirect("/basket.do");
	}
}

	
