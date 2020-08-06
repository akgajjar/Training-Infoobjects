package com.infoobjects.tms.service;

import com.infoobjects.tms.dao.TmsDAOImpl;
import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.mapper.TmsMapper;
import com.infoobjects.tms.service.interfaces.TeacherServiceIncrement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherServiceImpl implements TeacherServiceIncrement<String, Teacher> {

    @Override
    public void insert(Teacher teacherDTO) {
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.insert(TmsMapper.dtoToMap(teacherDTO), teacherDTO);
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
            map.put("teacherId", id);
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.delete(map, new Teacher());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public Teacher find(String id) {
        Teacher teacher = null;
        try {
            HashMap map = new HashMap();
            map.put("teacherId", id);
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            List<Map<String, Object>> resultList = genericDAO.find(map, new Teacher());
            if (resultList.size() == 0) {
                return null;
            }
            Map<String, Object> mapResult = resultList.get(0);
            teacher = (Teacher) TmsMapper.mapToDto(mapResult, new Teacher());
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return teacher;
    }

    @Override
    public void update(Teacher teacherDTO) {
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.update(TmsMapper.dtoToMap(teacherDTO), teacherDTO, "teacherId");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Teacher> findAll() {
        List<Teacher> teachers = new ArrayList<>();
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            List<Map<String, Object>> resultList = genericDAO.findAll(new HashMap(), new Teacher());
            for (int loopCounter = 0; loopCounter < resultList.size(); loopCounter++) {
                Map<String, Object> mapResult = resultList.get(loopCounter);
                Teacher teacher = (Teacher) TmsMapper.mapToDto(mapResult, new Teacher());
                teachers.add(teacher);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return teachers;
    }


}
