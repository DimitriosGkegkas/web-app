package items;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class items {
	private static List<item> items=new ArrayList<item>();
	
	static {
		String connectionURL = "jdbc:mysql://localhost:3306/pc-web-database";
		Connection connection = null;
		Statement statement = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			connection = DriverManager.getConnection(connectionURL, "root","");
			statement = connection.createStatement();
			String sql="SELECT * FROM `products` ";
			ResultSet rs=statement.executeQuery(sql);
	
			while(rs.next()) {
				items.add(new item(rs.getString("title"),rs.getString("id"),rs.getFloat("price")));
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}

	public List<item> retrieveItems(){
		return items;
	}
	
	public void addItem(item todo) {
		items.add(todo);
	}

}
