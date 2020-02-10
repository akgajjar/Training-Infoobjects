package com.infoobjects.tms.service;

import com.infoobjects.tms.dao.StudentDAOImpl;
import com.infoobjects.tms.dao.TmsDAOImpl;
import com.infoobjects.tms.dao.interfaces.DAO;
import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.mapper.TmsMapper;
import com.infoobjects.tms.service.interfaces.Service;

import java.util.HashMap;
import java.util.List;

public class StudentServiceImpl implements Service<Integer, Student> {

    private DAO<Integer, Student> studentDao = new StudentDAOImpl();
    private TmsDAOImpl genericDao = new TmsDAOImpl();

    public DAO<Integer, Student> getStudentDao() {
        return studentDao;
    }

    @Override
    public void insert(Student studentDTO) {
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.insert(TmsMapper.dtoToMap(studentDTO),TmsMapper.getTableName(studentDTO));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            HashMap map = new HashMap();
            map.put("studentId", id);
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.delete(map ,"Student");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
