package com;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Example6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the database URL:");
        String url = scanner.nextLine();
        System.out.println("Enter the database username:");
        String username = scanner.nextLine();
        System.out.println("Enter the database password:");
        String password = scanner.nextLine();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            
            String sql = "CREATE TABLE student (" +
                         "sno INT PRIMARY KEY," +
                         "student_name VARCHAR(50)," +
                         "age INT)";
            
            statement.executeUpdate(sql);
            
            System.out.println("Table 'student' created successfully.");
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
