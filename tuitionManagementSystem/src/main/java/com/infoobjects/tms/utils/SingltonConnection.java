package com.infoobjects.tms.utils;

import java.sql.*;

public class SingltonConnection {

    private static Connection connection;
    private SingltonConnection(){

    }

    private Connection getConnection(){
            Connection con = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TMS", "root", "Infoobjects@123");
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return con;
    }

    public static Connection getInstance(){
        if(connection == null){
            connection = getInstance();
        }
        return connection;
    }
}
