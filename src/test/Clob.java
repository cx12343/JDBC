package test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class Clob {
	
public static void main(String[] args) {
	 PreparedStatement ps=null;
		Connection conn=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","admin");
		String sql="insert into t_user(username,pwd,myinfo) values ('cc',555,?) ";
		 ps=conn.prepareStatement(sql);
		ps.setClob(1, new FileReader(new File("D:/a.txt")));
		 //ps.setClob(1, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aaabbb".getBytes()))));
		ps.executeUpdate();
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(ps!=null) {ps.close();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(conn!=null) {conn.close();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
}
