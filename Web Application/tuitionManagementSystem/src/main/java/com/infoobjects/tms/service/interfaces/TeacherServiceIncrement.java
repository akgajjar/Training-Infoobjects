package com.infoobjects.tms.service.interfaces;

import com.infoobjects.tms.dto.Student;

import java.util.List;

public interface TeacherServiceIncrement<String, DTO>  extends Service<String, DTO>{

    void insertStudent(DTO teacherStudent);

    List<Student> showAllStudent(String teacherId);

    void deleteAllStudents() throws Exception;

}
