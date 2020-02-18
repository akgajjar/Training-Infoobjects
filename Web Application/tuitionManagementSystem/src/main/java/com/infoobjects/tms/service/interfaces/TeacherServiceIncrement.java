package com.infoobjects.tms.service.interfaces;

import com.infoobjects.tms.dto.Student;

import java.util.List;

public interface TeacherServiceIncrement<Integer, DTO>  extends Service<Integer, DTO>{

    void insertStudent(DTO teacherStudent);

    List<Student> showAllStudent(int teacherId);

    void deleteAllStudents() throws Exception;

}
