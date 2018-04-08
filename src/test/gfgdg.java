package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class gfgdg {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
