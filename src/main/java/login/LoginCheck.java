package login;


import java.io.Console;
import java.sql.*;

import basket.basketServlet;

public class LoginCheck {
	public boolean isUserValid(String username,String password) {
		String connectionURL = "jdbc:mysql://localhost:3306/pc-web-database";
		Connection connection = null;
		Statement statement = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection = DriverManager.getConnection(connectionURL, "root","");
			statement = connection.createStatement();
			String sql="SELECT COUNT(*) AS 'total' FROM `users` WHERE `username` LIKE '"+username+"' AND `password` LIKE '"+password+"'";
			ResultSet rs=statement.executeQuery(sql);
			rs.next();
			if(rs.getInt("total")==0) 
				return false;
			else 
				return true;
			
		} catch ( SQLException e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return false;
	}
}
