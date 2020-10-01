package products;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basket.basket;


@WebServlet(urlPatterns = "/myHomePage.do")
public class home extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if(request.getSession().getAttribute("username")!=null) {
			request.getRequestDispatcher("/WEB-INF/views/myHomePage.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("/login.do");
		}
		
	}
	
}

