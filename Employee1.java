package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Employee1 {

	public static void main(String[] args) {
		
		String dburl="jdbc:mysql://localhost:3306/employee";
		String user="root";
		String password="root";
		try {
		//load and register jdbc driver;
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establish connection
			Connection connection=DriverManager.getConnection(dburl,user,password);
			
			if(connection!=null) {
				System.out.println("Connected to database");
				String insertQuery="INSERT INTO empl3(empcode,empname,empage,esalary) VALUES (?,?,?)";
				PreparedStatement stmt=connection.prepareStatement(insertQuery);
			
				//data
				int empcode=101;
			 String empname="Mahesh";
			 int empage=25;
			 int esalary=30000;
			 
			 stmt.setInt(1, empcode);
			 stmt.setString(2, empname);
			 stmt.setInt(3, empage);
			 stmt.setInt(4,30000);
			
			  int rowsAffected=stmt.executeUpdate();
			 if(rowsAffected>0) {
				 System.out.println("Data inserted Successfully");
			 }else {
				 System.out.print("Failed to insert the data");
				 
			 }
			 stmt.close();
			}else {
				System.out.println("Failed to connect to db");
			}
			
			connection.close();
		}catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		}catch (SQLException e) {
			System.out.println("Database connection error");
		}

	}

}
