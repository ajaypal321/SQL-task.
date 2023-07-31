package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
//database connection details
		String dburl="jdbc:mysql://localhost:3306/demo";
		String user="root";
		String password="root";
		try {
			//   load and register jdbc driver;
			Class.forName("com.mysql.jdbc.Driver");
			// establish connecttion
			Connection connection = DriverManager.getConnection(dburl,user,password);
			if(connection!=null) {
				System.out.println("Connected to database successfully");
				//perform some operation}
			}else {
				System.out.println("Failed to commect with Database");
			} connection.close();
		
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC driver not found");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("Database connect Error");
			e.printStackTrace();
		}
	}

}
