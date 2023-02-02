package com.iu.s1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
		public static void main(String[]args) {
		
			try {
				Connection con =  DBConnection.getConnection();
				System.out.println(con !=null);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		//getConnection
		public static Connection getConnection() throws Exception{
			//1.
			String user = "user01";
			String password = "user01";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			//driver
			String driver = "oracle.jdbc.driver.OracleDriver";
			
			//2.Driver ����
			Class.forName(driver);
			
			//3.DB����
			return DriverManager.getConnection(url,user,password);
			
		}
		
		//disConnection
		public static void disConnection(PreparedStatement st, Connection con) throws Exception {
			st.close();
			con.close();
		}
		
		public static void disConnection(ResultSet rs, PreparedStatement st, Connection con) throws Exception {
			rs.close();
			st.close();
			con.close();
		}

}
