package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Dome01 {
public static void main(String[] args) {
	//����������
	try {
	
		Class.forName("com.mysql.jdbc.Driver");
		//��������
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin");
		System.out.println(conn);
		 Statement stmt =conn.createStatement();
		 String name="��";//������
		 String sql="insert into t_user (username,pwd,regTime) values('"+name+"',55,now())";
		 stmt.execute(sql);
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
