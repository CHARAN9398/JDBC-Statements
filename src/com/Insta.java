package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;


public class Insta{
	public static final String url = "jdbc:mysql://localhost:3306/sys";
	public static final String name = "root";
	public static final String password = "9398074963";
	
	public static void main(String args[])throws SQLException{
	try (Scanner scanner = new Scanner(System.in)) {
		System.out.println("enter the user_name: ");
		String user_name = scanner.nextLine();
		
		System.out.println("enter the mail: ");
		String mail = scanner.nextLine();
		
		System.out.println("enter the user_password: ");
		String user_password = scanner.nextLine();
		
		Connection c = DriverManager.getConnection(url, name, password);
		//PreparedStatement pt1 = c.prepareStatement("CREATE TABLE insta_signup(USER_NAME VARCHAR (30),MAIL VARCHAR(30),USER_PASSWORD VARCHAR(20))");
		//pt1.executeUpdate();
		
		PreparedStatement pt = c.prepareStatement("INSERT INTO insta_signup (USER_NAME, MAIL, USER_PASSWORD) VALUES (?, ?, ?)");
		

		pt.setString(1, user_name);
		pt.setString(2, mail);
		pt.setString(3, user_password);
		pt.executeUpdate();

		
		ResultSet rs = pt.executeQuery("SELECT * FROM insta_signup");
		ResultSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();
		for(int i = 1; i<=columnCount; i++) {
			System.out.println(md.getColumnLabel(i)+"\t");
		}
		System.out.println();
		
		while(rs.next()) {
			for(int i = 1; i<=columnCount; i++) {
				System.out.println(rs.getString(i)+"\t");
			}
			System.out.println();
		}
	}
	
	}
}
