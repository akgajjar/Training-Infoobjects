package com.infoobjects.tms.dao;

import com.infoobjects.tms.dao.interfaces.TeacheDAOIncrement;
import com.infoobjects.tms.dto.StudentDTO;
import com.infoobjects.tms.dto.TeacherDTO;
import com.infoobjects.tms.enums.Designation;
import com.infoobjects.tms.utils.SingltonConnection;
import com.infoobjects.tms.utils.TmsUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImpl implements TeacheDAOIncrement<Integer, TeacherDTO> {

    private String insertQuery = "INSERT INTO TEACHER(TEACHERID,TEACHERNAME,TEACHERADDRESS,TEACHERMOBILE,TEACHEREMAIL,TEACHERSALARY,TEACHERDESIGNATION)values(?,?,?,?,?,?,?)";
    private String updateQuery = "UPDATE TEACHER SET TEACHERNAME = ?, TEACHERADDRESS = ?, TEACHERMOBILE = ?, TEACHEREMAIL= ?, TEACHERSALARY=?, TEACHERDESIGNATION = ? WHERE TEACHERID = ?";
    private String deleteQuery = "DELETE FROM TEACHER WHERE TEACHERID = ?";
    private String findQuery = "SELECT * FROM TEACHER WHERE TEACHERID = ?";
    private String findAllQuery = "SELECT * FROM TEACHER";
    private String insertstudentQuery = "INSERT INTO TEACHERSTUDENT(TEACHERID,STUDENTID)values(?,?)";
    private String findAllStudentsQuery = "SELECT * FROM TEACHERSTUDENT WHERE TEACHERID = ?";
    private String deleteAllStudentsQuery = "DELETE FROM TEACHERSTUDENT ";

    @Override
    public void insert(TeacherDTO teacherDTO) {
        try {
            Connection connection = SingltonConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            statement.setInt(1, teacherDTO.getTeacherId());
            statement.setString(2, teacherDTO.getTeacherName());
            statement.setString(3, teacherDTO.getTeacherAddress());
            statement.setString(4, teacherDTO.getTeacherMobile());
            statement.setString(5, teacherDTO.getTeacherEmailId());
            statement.setDouble(6, teacherDTO.getTeacherSalary());
            statement.setString(7, teacherDTO.getTeacherDesignation().toString());
            statement.executeUpdate();
            System.out.print(TmsUtils.insertSuccessmsg);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            Connection connection = SingltonConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(deleteQuery);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.print(TmsUtils.deleteSuccessmsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public TeacherDTO find(Integer id) {
        TeacherDTO teacherDTO = null;
        try {
            Connection connection = SingltonConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(findQuery);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                teacherDTO = new TeacherDTO();
                teacherDTO.setTeacherAddress(rs.getString("TEACHERADDRESS"));
                teacherDTO.setTeacherEmailId(rs.getString("TEACHEREMAIL"));
                teacherDTO.setTeacherId(rs.getInt("TEACHERID"));
                teacherDTO.setTeacherMobile(rs.getString("TEACHERMOBILE"));
                teacherDTO.setTeacherName(rs.getString("TEACHERNAME"));
                teacherDTO.setTeacherSalary(rs.getDouble("TEACHERSALARY"));

                switch (rs.getString("TEACHERDESIGNATION")){
                    case "Professor" :
                            teacherDTO.setTeacherDesignation(Designation.PROFESSOR);
                            break;
                    case "Teaching Assistance" :
                            teacherDTO.setTeacherDesignation(Designation.TEACHINGASSISTANCE);
                            break;
                    case "Lab Staff" :
                            teacherDTO.setTeacherDesignation(Designation.LABSTAFF);
                            break;
                    case "None" :
                            teacherDTO.setTeacherDesignation(Designation.NONE);
                            break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacherDTO;
    }

    @Override
    public void update(TeacherDTO teacherDTO) {
        try {
            Connection connection = SingltonConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(updateQuery);
            statement.setInt(7, teacherDTO.getTeacherId());
            statement.setString(1, teacherDTO.getTeacherName());
            statement.setString(2, teacherDTO.getTeacherAddress());
            statement.setString(3, teacherDTO.getTeacherMobile());
            statement.setString(4, teacherDTO.getTeacherEmailId());
            statement.setDouble(5, teacherDTO.getTeacherSalary());
            statement.setString(6, teacherDTO.getTeacherDesignation().getDesignationValue());
            statement.executeUpdate();
            System.out.print(TmsUtils.updateSuccessmsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TeacherDTO> findAll() {
        List<TeacherDTO> teacherList = new ArrayList<>();
        try {
            Connection connection = SingltonConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(findAllQuery);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                TeacherDTO teacherDTO = new TeacherDTO();
                teacherDTO.setTeacherAddress(rs.getString("TEACHERADDRESS"));
                teacherDTO.setTeacherEmailId(rs.getString("TEACHEREMAIL"));
                teacherDTO.setTeacherId(rs.getInt("TEACHERID"));
                teacherDTO.setTeacherMobile(rs.getString("TEACHERMOBILE"));
                teacherDTO.setTeacherName(rs.getString("TEACHERNAME"));
                teacherDTO.setTeacherSalary(rs.getDouble("TEACHERSALARY"));
                switch (rs.getString("TEACHERDESIGNATION")){
                    case "Professor" :
                        teacherDTO.setTeacherDesignation(Designation.PROFESSOR);
                        break;
                    case "Teaching Assistance" :
                        teacherDTO.setTeacherDesignation(Designation.TEACHINGASSISTANCE);
                        break;
                    case "Lab Staff" :
                        teacherDTO.setTeacherDesignation(Designation.LABSTAFF);
                        break;
                    case "None" :
                        teacherDTO.setTeacherDesignation(Designation.NONE);
                        break;
                }
                teacherList.add(teacherDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teacherList;
    }

    @Override
    public void insertStudent(int studentId, int teacherId) {
        try {
            Connection connection = SingltonConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(insertstudentQuery);
            statement.setInt(1, teacherId);
            statement.setInt(2, studentId);
            statement.executeUpdate();
            System.out.print(TmsUtils.insertSuccessmsg);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<StudentDTO> showAllStudent(int teacherId, StudentDAOImpl studentDAO) {
        List<StudentDTO> studentList = new ArrayList<StudentDTO>();
        try {
            Connection connection = SingltonConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(findAllStudentsQuery);
            statement.setInt(1, teacherId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int studentId = rs.getInt("STUDENTID");
                StudentDTO student = studentDAO.find(studentId);
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public void deleteStudents() {
        try {
            Connection connection = SingltonConnection.getInstance();
            PreparedStatement statement = connection.prepareStatement(deleteAllStudentsQuery);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



