package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Example4 {
	
	public static String url = "jdbc:mysql://localhost:3306/sys";
	public static String name = "root";
	public static String password = "9398074963";
	
	public static void main(String[] args) throws SQLException {
		Connection c = DriverManager.getConnection(url, name, password);
		PreparedStatement pt = c.prepareStatement("SELECT * FROM employe WHERE sno = ?");
		pt.setInt(1, 100);
		ResultSet rs = pt.executeQuery();
		
		ResultSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();

		for (int i = 1; i <= columnCount; i++) {
			System.out.println(md.getColumnLabel(i) + " ");
		}
		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.println(rs.getString(i));
			}
		}
	}
}
