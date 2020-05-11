package com.infoobjects.tms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {

    private volatile static SingletonConnection singletonConnection;
    private Connection connection;

    private SingletonConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tms?serverTimezone=UTC", "root", "");
        } catch (ClassNotFoundException classNotFoundException) {
                throw  classNotFoundException;
        } catch (SQLException sqlException){
                throw sqlException;
        }
    }

    public Connection getConnection() {
        return connection;
    }


    public static synchronized SingletonConnection getInstance() throws ClassNotFoundException, SQLException {

        try {
            if (singletonConnection == null || singletonConnection.getConnection().isClosed()) {
                singletonConnection = new SingletonConnection();
            }
        } catch (ClassNotFoundException classNotFoundException) {
            throw  classNotFoundException;
        } catch (SQLException sqlException){
            throw sqlException;
        }
        return singletonConnection;
    }
}

