package com.infoobjects.tms.service.interfaces;

import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.dto.TeacherStudent;

import java.util.List;

public interface TeacherStudentServiceIncrement<String, DTO> extends Service<String, DTO> {
    void update(TeacherStudent oldteacherStudentDTO, TeacherStudent newteacherStudentDTO);

    void delete(TeacherStudent teacherStudent);

    TeacherStudent find(TeacherStudent teacherStudentDTO);

    List<Student> showAllStudent(String teacherId);

    public List<Teacher> getTeacherName(String studentId);

    void deleteAllStudents() throws Exception;

    public void deleteByStudentId(String studentId);

    public void deleteByTeacherId(String teacherId);

}
