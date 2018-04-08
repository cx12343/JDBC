package test;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.PreparedStatement;


public class JDBCUtil {
	static Properties pro=null;
	static {
		pro =new Properties();
		try {
			pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static  Connection getMysqlConn() {
		 try {
			 Class.forName(pro.getProperty("mysqlDriver"));
			return DriverManager.getConnection(pro.getProperty("mysqlUrl"),pro.getProperty("mysqlUser"),pro.getProperty("mysqlPwd"));
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	public static void close(OutputStream os,PreparedStatement ps,Connection conn) {
		try {
			if(os!=null) {os.close();}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public static void close(Connection conn) {
	
		try {
			if(conn!=null) {conn.close();}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
