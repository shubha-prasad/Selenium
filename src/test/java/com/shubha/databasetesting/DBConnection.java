package com.shubha.databasetesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static Connection con;

    //    ESTABLISHING THE CONNECTION USING STATIC BLOCK
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/qapitolqa_jdbc?createDatabaseIfNotExist=true",
                    "root", "root");
            System.out.println("Connection established");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver class failed to load");
        } catch (SQLException e) {
            System.out.println("Connection failed");
        }
    }
}
