package com.infoobjects.tms.service.interfaces;

import com.infoobjects.tms.dto.StudentDTO;

import java.util.List;

public interface TeacherServiceIncrement<Integer, TeacherDTO>  extends Service<Integer, TeacherDTO>{

    public void insertStudent(int studentId, int teacherId) throws Exception;

    public List<StudentDTO> showAllStudent(int teacherId);

    public void deleteStudents() throws Exception;

}
