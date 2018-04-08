package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

/**
 * ResultSet
 * @author Administrator
 *
 */

public class Dome3 {
public static void main(String[] args) {
	//加载驱动类
	try {
	
		Class.forName("com.mysql.jdbc.Driver");
		//建立连接
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin");
		System.out.println(conn);
		 String sql="select * from t_user where id>?";
		 PreparedStatement ps =conn.prepareStatement(sql);
		 ps.setObject(1, 2);
		 
		 ResultSet rs=ps.executeQuery();
	
		 while(rs.next()) {
			 System.out.println(rs.getInt(1)+"---"+rs.getString(2));
		 }
		 
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
