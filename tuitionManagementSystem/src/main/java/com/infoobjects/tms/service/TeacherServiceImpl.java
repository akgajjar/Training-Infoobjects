package com.infoobjects.tms.service;

import com.infoobjects.tms.dao.TeacherDAOImpl;
import com.infoobjects.tms.dao.interfaces.DAO;
import com.infoobjects.tms.dao.interfaces.TeacheDAOIncrement;
import com.infoobjects.tms.dto.StudentDTO;
import com.infoobjects.tms.dto.TeacherDTO;
import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.service.interfaces.Service;
import com.infoobjects.tms.service.interfaces.TeacherServiceIncrement;

import java.util.List;

public class TeacherServiceImpl implements  TeacherServiceIncrement<Integer, TeacherDTO> {

    private TeacheDAOIncrement<Integer, TeacherDTO> teacherDAO = null;

    public TeacherServiceImpl() {
        teacherDAO = new TeacherDAOImpl();
    }

    @Override
    public void insert(TeacherDTO teacherDTO) {
        teacherDAO.insert(teacherDTO);
    }

    @Override
    public void delete(Integer id) {
        teacherDAO.delete(id);
    }

    @Override
    public TeacherDTO find(Integer id) {
        return teacherDAO.find(id);
    }

    @Override
    public void update(TeacherDTO teacherDTO) {
        teacherDAO.update(teacherDTO);
    }

    @Override
    public List<TeacherDTO> findAll() {
        return teacherDAO.findAll();
    }


    @Override
    public void insertStudent(int studentId, int teacherId) throws Exception {
        teacherDAO.insertStudent(studentId, teacherId);
    }

    @Override
    public List<StudentDTO> showAllStudent(int teacherId) {
        return teacherDAO.showAllStudent(teacherId);
    }

    @Override
    public void deleteStudents() throws Exception {
        teacherDAO.deleteStudents();
    }
}
