package test;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.naming.spi.DirStateFactory.Result;

/**
 * ResultSet
 * @author Administrator
 *
 */

public class Batch {
	public static long rTime(String time) {
		DateFormat format =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			return format.parse(time).getTime()+(new Random().nextInt(1000000000));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return 0;
	}
public static void main(String[] args) {
	Connection conn=null;
	Statement stmt=null;
	//加载驱动类
	try {
	
		Class.forName("com.mysql.jdbc.Driver");
		//建立连接
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin");
		conn.setAutoCommit(false);//手动提交事物
		stmt=conn.createStatement();
		for(int i=0;i<2000;i++) {
			java.sql.Timestamp t=new java.sql.Timestamp(rTime("2018-4-8 16:34:50")); 
			System.out.println(t);
			stmt.addBatch("insert into t_user (username,pwd,regTime) values('cc"+i+"',222,'"+t+"')");
		}
		stmt.executeBatch();
		conn.commit();//提交事物
		  
		
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			stmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
