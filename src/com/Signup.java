package com;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.SQLException;

class Signup {
    public static void main(String args[]) throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter mail: ");
            String mail = scanner.nextLine();
            
            System.out.print("Enter the password: ");
            String password = scanner.nextLine();
            
            System.out.print("Enter the confirm password: ");
            String confirmPassword = scanner.nextLine();
            
            if (!password.equals(confirmPassword)) {
                System.out.println("Confirm password does not match");
                return;
            }
            
            // Creating connection to the database
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?user=root&password=9398074963");
            
            // Creating a statement object
            Statement st = c.createStatement();
            
            // Executing SQL query to create table
            st.executeUpdate("CREATE TABLE IF NOT EXISTS signup_details (Name VARCHAR(20), Mail VARCHAR(20), Password VARCHAR(20))");
            
            // Executing SQL query to insert data into the table
            st.executeUpdate("INSERT INTO signup_details (Name, Mail, Password) VALUES ('" + name + "', '" + mail + "', '" + password + "')");
            
            ResultSet rs = st.executeQuery("SELECT *FROM Signup_details");
            ResultSetMetaData md = rs.getMetaData();
    		int columnCount = md.getColumnCount();
    		for(int i = 1; i<= columnCount; i++) { 
    			System.out.println(md.getColumnLabel(i));
    		}
    		
    		while(rs.next()) {
    			for(int i = 1; i<= columnCount; i++) {
    				System.out.println(rs.getString(i));
            // Closing resources
    			}
    		}
        }
    }
}

    