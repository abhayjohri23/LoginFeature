package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    public static Connection connection;
    public static Connection getConnection() throws SQLException {
        if(connection == null)
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","LOYDX0@123");
        return connection;
    }
}
