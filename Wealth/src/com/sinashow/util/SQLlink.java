package com.sinashow.util;

import java.sql.Connection;    
import java.sql.DriverManager;    
import java.sql.ResultSet;    
import java.sql.SQLException;
import java.sql.Statement;  
import java.util.ArrayList;

public class SQLlink {
	private String ip="122.227.42.196:2433";
	private String user = "webshow";
	private String password = "5ILyhZkqIlW5vdAW";
	private String dbname = "member";
	private String dbUrl;
	private Connection con = null;    
	private Statement stmt = null;    
	private ResultSet rs = null;    
	
	public SQLlink(){
		//sa身份连接
		dbUrl = "jdbc:sqlserver://"+ip+";"
				+"databaseName="+dbname+";"
				+"user="+user+";"
				+"password"+password;
		dbUrl = "jdbc:sqlserver://122.227.42.196:2433;databaseName=member;user=webshow;password=5ILyhZkqIlW5vdAW";
	 
	}
	
	private ResultSet select(String sql){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(dbUrl);
			stmt = con.createStatement();    
            rs = stmt.executeQuery(sql); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs; 
	}
	
	public String query(String sql){
		ResultSet result;
		result=  select(sql);
//		ArrayList<String> list = new ArrayList<String>();
//		while(result != null){
//			list.add(result.toString());
//		}
		
		String s = null ;
		try {
			result.next();
			s = result.getString(1);
			result.close();
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}
			

	     
}
