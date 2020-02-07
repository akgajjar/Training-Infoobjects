package com.infoobjects.tms.service;

import com.infoobjects.tms.dao.StudentDAOImpl;
import com.infoobjects.tms.dao.TeacherDAOImpl;
import com.infoobjects.tms.dao.interfaces.TeacheDAOIncrement;
import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.service.interfaces.TeacherServiceIncrement;

import java.util.List;

public class TeacherServiceImpl implements  TeacherServiceIncrement<Integer, Teacher> {

    private TeacheDAOIncrement<Integer, Teacher> teacherDAO = new TeacherDAOImpl();

    public TeacheDAOIncrement<Integer, Teacher> getTeacherDAO() {
        return teacherDAO;
    }

    @Override
    public void insert(Teacher teacherDTO) {
        teacherDAO.insert(teacherDTO);
    }

    @Override
    public void delete(Integer id) {
        teacherDAO.delete(id);
    }

    @Override
    public Teacher find(Integer id) {
        return teacherDAO.find(id);
    }

    @Override
    public void update(Teacher teacherDTO) {
        teacherDAO.update(teacherDTO);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherDAO.findAll();
    }


    @Override
    public void insertStudent(int studentId, int teacherId) throws Exception {
        teacherDAO.insertStudent(studentId, teacherId);
    }

    @Override
    public List<Student> showAllStudent(int teacherId, StudentDAOImpl studentDAO) {
        return teacherDAO.showAllStudent(teacherId, studentDAO);
    }

    @Override
    public void deleteStudents() throws Exception {
        teacherDAO.deleteStudents();
    }

}
