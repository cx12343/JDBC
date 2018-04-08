package test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.RunnableScheduledFuture;



public class Blobss {
	
public static void main(String[] args) {
	 PreparedStatement ps=null;
		Connection conn=null;
		InputStream is =null;
		OutputStream os=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","admin");
		/*String sql="insert into t_user(username,pwd,myinfo,img) values ('cc',555,'111111',?) ";
		 ps=conn.prepareStatement(sql);
		ps.setBlob(1, new FileInputStream (new File("D:/b.mp3")));
		 //ps.setClob(1, new BufferedReader(new InputStreamReader(new ByteArrayInputStream("aaabbb".getBytes()))));
		ps.executeUpdate();*/
		
		
		String sql="select * from t_user where id=? ";
		 ps=conn.prepareStatement(sql);
		 ps.setObject(1, 22081);
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()) {
			Blob b=rs.getBlob("img");
			 is =b.getBinaryStream();
			 os=new FileOutputStream("D:/z.mp3");
			byte[] temp= new byte [20480];
			while(-1!=is.read(temp)) {
				os.write(temp);
			}
		 }
		 
		
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
	
}
}
