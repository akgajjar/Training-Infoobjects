package com.infoobjects.tms.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {

    private static Connection connection;

    private SingletonConnection() {

    }

    private static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TMS", "root", "Infoobjects@123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static Connection getInstance() {
        if (connection == null) {
            connection = getConnection();
        }
        return connection;
    }
}
