package com.jmei.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {
	private static Properties pro = new Properties();
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static{
		try {
			String path = DBUtils.class.getResource("").getPath()+"/db.properties";
			InputStream is = new FileInputStream(path);
			pro.load(is);
			driver = (String) pro.get("driver");
			url = (String) pro.get("url");
			username = (String) pro.get("username");
			password = (String) pro.get("password");
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, username, password);
	}
	
	
	public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs) throws SQLException{
		if(rs != null){ rs.close();}
		if(pstmt != null){ pstmt.close();}
		if(conn != null){ conn.close();}
	}
	public static void close(Connection conn,PreparedStatement pstmt)throws SQLException{
		 close(conn,pstmt,null);
	}
	
	public static void close(Connection conn)throws SQLException{
		 close(conn,null,null);
	}
	
	public static void close(Connection conn,Statement stmt,ResultSet rs)throws SQLException{
		if(rs != null){ rs.close();}
		if(stmt != null){ stmt.close();}
		if(conn != null){ conn.close();}
	}
	public static void close(Connection conn,Statement stmt)throws SQLException{
		close(conn,stmt);
	}

}
