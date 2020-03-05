package com.infoobjects.tms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {

    private static volatile Connection singletonConnection;

    private SingletonConnection() {

    }

    private static Connection getConnection() throws SQLException, ClassNotFoundException,Exception {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TMS", "root", "Infoobjects@123");

        } catch (ClassNotFoundException classnotFoundexception) {
            throw classnotFoundexception;
        } catch (SQLException sqlException) {
            throw sqlException;
        } catch (Exception exception) {
            throw exception;
        }
        return connection;
    }


    public static synchronized Connection getInstance() throws SQLException, ClassNotFoundException,Exception{
        if(singletonConnection == null){
            synchronized(SingletonConnection.class){
                if(singletonConnection == null) {
                    try {
                        singletonConnection = getConnection();
                    }catch (ClassNotFoundException classnotFoundexception) {
                        throw classnotFoundexception;
                    } catch (SQLException sqlException) {
                        throw sqlException;
                    } catch (Exception exception) {
                        throw exception;
                    }
                }
            }
        }
        return singletonConnection;
    }
}
