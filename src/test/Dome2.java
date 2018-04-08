package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class Dome2 {
public static void main(String[] args) {
	//加载驱动类
	try {
	
		Class.forName("com.mysql.jdbc.Driver");
		//建立连接
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin");
		System.out.println(conn);
		 String name="张李2";//传参数
		 String sql="insert into t_user (username,pwd,regTime) values(?,?,?)";//占位符
		 PreparedStatement ps =conn.prepareStatement(sql);
		 ps.setString(1, name);//填充站位符 从1开始
		 ps.setObject(2,"2222");
		 ps.setObject(3, new Date(System.currentTimeMillis()));
		 //ps.execute();
		 int a =ps.executeUpdate();
		System.out.println(a);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
