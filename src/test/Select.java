package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;


public class Select {
	public static long rTime(String time) {
		DateFormat format =new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			return format.parse(time).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return 0;
	}
	
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin");
		String sql="select * from t_user where regTime>? and regTime<? order by regTime";
		PreparedStatement ps=conn.prepareStatement(sql);
		Timestamp start=new Timestamp(rTime("2018-4-8 8:5:5"));
		Timestamp end=new Timestamp(rTime("2018-4-9 8:5:5"));
		ps.setObject(1, start);
		ps.setObject(2, end);
		ResultSet result= ps.executeQuery();
		while(result.next()) {
			System.out.println(result.getString(2)+"----"+result.getTimestamp("regTime"));
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
