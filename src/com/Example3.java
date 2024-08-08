package com;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Example3 {
	public static final String url = "jdbc:mysql://localhost:3306/sys";
	public static final String name = "root";
	public static final String password = "9398074963";
	
	public static void main(String[] args) throws SQLException {
		Connection c = DriverManager.getConnection(url, name, password);
		Statement st = c.createStatement();
		/*st.executeUpdate("CREATE TABLE employe(sno INT, name VARCHAR(20))");
		st.executeUpdate("INSERT INTO employe VALUES(100,'AJAY')");
		st.executeUpdate("INSERT INTO employe VALUES(101,'VIJAY')");
		st.executeUpdate("INSERT INTO employe VALUES(102,'JAY')");
		st.executeUpdate("INSERT INTO employe VALUES(103,'KIRAN')");
		st.executeUpdate("INSERT INTO employe VALUES(104,'AJAY')");
		st.executeUpdate("DELETE FROM employe WHERE SNO = 104");*/
		
		ResultSet rs = st.executeQuery("SELECT *FROM employe");	
		ResultSetMetaData metaData = rs.getMetaData();
		int columnCount = metaData.getColumnCount();
		
		
		for(int i = 1; i<= columnCount; i++) {
			System.out.println(metaData.getColumnLabel(i)+" ");
		}
		while(rs.next())
		{
			for(int i = 1; i<= columnCount; i++) {
				System.out.println(rs.getString(i));
			}
		}	
	}
}
