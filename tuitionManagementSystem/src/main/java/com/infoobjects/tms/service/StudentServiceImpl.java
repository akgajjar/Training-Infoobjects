package com.infoobjects.tms.service;

import com.infoobjects.tms.dao.StudentDAOImpl;
import com.infoobjects.tms.dao.interfaces.DAO;
import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.service.interfaces.Service;

import java.util.List;

public class StudentServiceImpl implements Service<Integer, Student> {

    private DAO<Integer, Student> studentDao = new StudentDAOImpl();

    public DAO<Integer, Student> getStudentDao() {
        return studentDao;
    }

    @Override
    public void insert(Student studentDTO) {
        studentDao.insert(studentDTO);
    }

    @Override
    public void delete(Integer id) {
        studentDao.delete(id);
    }

    @Override
    public Student find(Integer id) {
        return studentDao.find(id);
    }

    @Override
    public void update(Student studentDTO) {
        studentDao.update(studentDTO);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

}
