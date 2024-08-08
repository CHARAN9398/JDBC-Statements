package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;

public class Example5 {
	
	public static String url = "jdbc:mysql://localhost:3306/sys";
	public static String name = "root";
	public static String password = "9398074963";
	
	public static void main(String[] args) throws SQLException {
		Connection c = DriverManager.getConnection(url, name, password);
		PreparedStatement ps = c.prepareStatement("CREATE TABLE shop2(name VARCHAR(20), price INT)");
		ps.executeUpdate();
		
		
		/*ps = c.prepareStatement("INSERT INTO mall(name, price) VALUES (?, ?)");*/
		ps.setString(1, "bread");
		ps.setInt(2, 40);
		ps.executeUpdate();
		
		ps.setString(1, "butter");
		ps.setInt(2, 80);
		ps.executeUpdate();
		
		ps.setString(1, "jam");
		ps.setInt(2, 20);
		ps.executeUpdate();
		
		System.out.println("rows are afected");
		
		ps.executeQuery("SELECT *FROM shop2 WHERE String=?");
		ps.setString(2, "bread");
		ps.executeUpdate();
		
		
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();
		for(int i = 1; i<= columnCount; i++) { 
			System.out.println(md.getColumnLabel(i));
		}
		while(rs.next()) {
			for(int i = 1; i<= columnCount; i++) {
				System.out.println(rs.getString(i));
			}
		}
		
	}
}
