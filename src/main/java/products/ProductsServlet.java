package products;

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
import items.items;

@WebServlet(urlPatterns = "/products.do")
public class ProductsServlet extends HttpServlet{
	protected items items=new items();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("items", items.retrieveItems());
		request.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(request, response);
	}
}
