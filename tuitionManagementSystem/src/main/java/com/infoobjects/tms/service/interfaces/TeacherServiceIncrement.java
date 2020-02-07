package com.infoobjects.tms.service.interfaces;

import com.infoobjects.tms.dao.StudentDAOImpl;
import com.infoobjects.tms.dto.Student;

import java.util.List;

public interface TeacherServiceIncrement<Integer, TeacherDTO>  extends Service<Integer, TeacherDTO>{

    void insertStudent(int studentId, int teacherId) throws Exception;

    List<Student> showAllStudent(int teacherId, StudentDAOImpl studentDAO);

    void deleteStudents() throws Exception;

}
