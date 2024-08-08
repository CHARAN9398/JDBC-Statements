package com;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Example7{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the database URL:");
        String url = scanner.nextLine();
        System.out.println("Enter the database username:");
        String username = scanner.nextLine();
        System.out.println("Enter the database password:");
        String password = scanner.nextLine();
        
        System.out.println("Enter the table name:");
        String tableName = scanner.nextLine();
        System.out.println("Enter student name:");
        String studentName = scanner.nextLine();
        System.out.println("Enter student age:");
        int age = scanner.nextInt();

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();

            String sql = "CREATE TABLE " + tableName + " (" +
                    "sno INT PRIMARY KEY," +
                    "student_name VARCHAR(50)," +
                    "age INT)";
            
            statement.executeUpdate(sql);

            System.out.println("Table '" + tableName + "' created successfully.");

            // Inserting data into the created table
            String insertData = "INSERT INTO " + tableName + " (sno, student_name, age) VALUES (1, '" + studentName + "', " + age + ")";
            
            statement.executeUpdate(insertData);

            System.out.println("Data inserted into table '" + tableName + "' successfully.");
        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
