package com.infoobjects.tms.dao.interfaces;

import com.infoobjects.tms.dto.StudentDTO;
import com.infoobjects.tms.dto.TeacherDTO;

import java.util.List;

public interface TeacheDAOIncrement<Integer, DTO> extends  DAO<Integer, TeacherDTO> {

    public void insertStudent(int studentId, int teacherId) throws Exception;

    public List<StudentDTO> showAllStudent(int teacherId);

    public void deleteStudents() throws Exception;

}
