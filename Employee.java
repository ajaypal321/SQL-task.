package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {

	public static void main(String[] args) throws ClassNotFoundException {
		//database connection details
				String dburl="jdbc:mysql://localhost:3306/employee";
				String user="root";
				String password="root";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection(dburl,user,password);
					Statement stmt=conn.createStatement();

					//String sql="INSERT INTO empl3 ((id,empcode,empname,empage,esalary) VALUES (01,101,'Jenny',25,1000)";
				String sql="insert into empnew(empcode,empname,empage,esalary)  values (101,'Jenny',25,10000),(102,'Jacky',30,20000),(103,'Joe',20,40000),(104,'John',40,80000),(105,'Shameer',25,90000)";
							
					
					int rowsaffect=stmt.executeUpdate(sql);
					
					if(rowsaffect>0) {
						System.out.println(rowsaffect+"rows inserted into table");
					}else {
						System.out.println("No rows selected");
					}
					conn.close();
					} catch (SQLException e) {
					// TODO: handle exception
						e.printStackTrace();
				}
			}
				
			
	}


