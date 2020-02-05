package com.infoobjects.tms.dao.interfaces;

import com.infoobjects.tms.dao.StudentDAOImpl;
import com.infoobjects.tms.dto.StudentDTO;
import com.infoobjects.tms.dto.TeacherDTO;

import java.util.List;

public interface TeacheDAOIncrement<Integer, DTO> extends  DAO<Integer, TeacherDTO> {

    void insertStudent(int studentId, int teacherId) throws Exception;

    List<StudentDTO> showAllStudent(int teacherId, StudentDAOImpl studentDAO);

    void deleteStudents() throws Exception;

}
