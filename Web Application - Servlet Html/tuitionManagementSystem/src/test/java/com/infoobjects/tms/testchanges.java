package com.infoobjects.tms;

import com.infoobjects.tms.dao.SingletonConnection;
import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.TeacherStudent;
import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.mapper.TmsMapper;
import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.service.StudentServiceImpl;
import com.infoobjects.tms.service.TeacherServiceImpl;
import com.infoobjects.tms.service.TeacherStudentServiceImpl;
import com.infoobjects.tms.utils.TmsUtils;
import org.apache.commons.text.CaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class testchanges {
    public static void main(String[] args) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Infoobjects@123");


            String query  = "select * from testPrepare where id = ?";

            PreparedStatement pst  = connection.prepareStatement(query);

            pst.setString(1,"1 ; delete from testPrepare");

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                System.out.println("Id : " + rs.getString("id"));
                System.out.println("Name : " + rs.getString("name"));

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
