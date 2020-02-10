package com.infoobjects.tms.service.interfaces;

import com.infoobjects.tms.dao.StudentDAOImpl;
import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.interfaces.DTO;

import java.util.List;

public interface TeacherServiceIncrement<Integer, DTO>  extends Service<Integer, DTO>{

    void insertStudent(int studentId, int teacherId) throws Exception;

    List<Student> showAllStudent(int teacherId, StudentDAOImpl studentDAO);

    void deleteStudents() throws Exception;

}
