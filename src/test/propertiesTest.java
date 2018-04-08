package test;


import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Random;



/**
 * ResultSet
 * @author Administrator
 *
 */

public class propertiesTest {
	
		
public static void main(String[] args) {
	Connection conn=null;
	Statement stmt=null;
	//º”‘ÿ«˝∂Ø¿‡
	try {
		conn=JDBCUtil.getMysqlConn();
		//Properties ps =conn.prepareStatement(sql)

		
		  
		
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		JDBCUtil.close(conn);
		}
	

}
	}

