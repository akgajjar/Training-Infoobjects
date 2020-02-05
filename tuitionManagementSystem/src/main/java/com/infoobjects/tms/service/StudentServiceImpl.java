package com.infoobjects.tms.service;

import com.infoobjects.tms.dao.StudentDAOImpl;
import com.infoobjects.tms.dao.interfaces.DAO;
import com.infoobjects.tms.dto.StudentDTO;
import com.infoobjects.tms.service.interfaces.Service;

import java.util.List;

public class StudentServiceImpl implements Service<Integer, StudentDTO> {

    private DAO<Integer, StudentDTO> studentDao = new StudentDAOImpl();

    public DAO<Integer, StudentDTO> getStudentDao() {
        return studentDao;
    }

    @Override
    public void insert(StudentDTO studentDTO) {
        studentDao.insert(studentDTO);
    }

    @Override
    public void delete(Integer id) {
        studentDao.delete(id);
    }

    @Override
    public StudentDTO find(Integer id) {
        return studentDao.find(id);
    }

    @Override
    public void update(StudentDTO studentDTO) {
        studentDao.update(studentDTO);
    }

    @Override
    public List<StudentDTO> findAll() {
        return studentDao.findAll();
    }

}
