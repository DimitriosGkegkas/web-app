package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basket.basket;


@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet{

	LoginCheck service= new LoginCheck();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		boolean isUserValid =service.isUserValid(username,password);
		if(isUserValid) {
			request.getSession().setAttribute("username", username);
			request.getSession().setAttribute("fpa", 1.24);
			request.getRequestDispatcher("/WEB-INF/views/myHomePage.jsp").forward(request, response);
		}
		else {
			request.setAttribute("username",username);
			request.getRequestDispatcher("/WEB-INF/views/newUser.jsp").forward(request, response);
		}
	}
}
