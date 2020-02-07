package com.infoobjects.tms.dao.interfaces;

import com.infoobjects.tms.dao.StudentDAOImpl;
import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.Teacher;

import java.util.List;

public interface TeacheDAOIncrement<Integer, DTO> extends  DAO<Integer, Teacher> {

    void insertStudent(int studentId, int teacherId) throws Exception;

    List<Student> showAllStudent(int teacherId, StudentDAOImpl studentDAO);

    void deleteStudents() throws Exception;

}
