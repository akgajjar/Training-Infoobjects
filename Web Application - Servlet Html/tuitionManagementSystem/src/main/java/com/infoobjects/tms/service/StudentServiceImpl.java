package com.infoobjects.tms.service;

import com.infoobjects.tms.dao.TmsDAOImpl;
import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.mapper.TmsMapper;
import com.infoobjects.tms.service.interfaces.StudentServiceIncrement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentServiceIncrement<String, Student> {

    @Override
    public void insert(Student studentDTO) {
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.insert(TmsMapper.dtoToMap(studentDTO), studentDTO);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        try {
            HashMap map = new HashMap();
            map.put("studentId", id);
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.delete(map, new Student());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Student find(String id) {
        Student student = null;
        try {
            HashMap map = new HashMap();
            map.put("studentId", id);
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            List<Map<String, Object>> resultList = genericDAO.find(map, new Student());
            if (resultList.size() == 0) {
                return null;
            }
            Map<String, Object> mapResult = resultList.get(0);
            student = (Student) TmsMapper.mapToDto(mapResult, new Student());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return student;
    }

    @Override
    public void update(Student studentDTO) {
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.update(TmsMapper.dtoToMap(studentDTO), studentDTO, "studentId");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            List<Map<String, Object>> resultList = genericDAO.findAll(new HashMap(), new Student());
            for (int loopCounter = 0; loopCounter < resultList.size(); loopCounter++) {
                Map<String, Object> mapResult = resultList.get(loopCounter);
                Student student = (Student) TmsMapper.mapToDto(mapResult, new Student());
                students.add(student);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return students;
    }

}
