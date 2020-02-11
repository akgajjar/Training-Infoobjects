package com.infoobjects.tms.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {

    private static Connection connection;

    private SingletonConnection() {

    }

    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TMS", "root", "Infoobjects@123");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return connection;
    }

    public static synchronized Connection getInstance() {
        if (connection == null) {
            connection = getConnection();
        }
        return connection;
    }
}
