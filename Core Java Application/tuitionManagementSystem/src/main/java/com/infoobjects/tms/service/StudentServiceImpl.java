package com.infoobjects.tms.service;

import com.infoobjects.tms.dao.TmsDAOImpl;
import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.interfaces.DTO;
import com.infoobjects.tms.mapper.TmsMapper;
import com.infoobjects.tms.service.interfaces.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements Service<String, DTO> {

    @Override
    public void insert(DTO studentDTO) {
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.insert(TmsMapper.dtoToMap(studentDTO),TmsMapper.getTableName(studentDTO));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
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
    public DTO find(String id) {
        DTO student = null;
        try {
            HashMap map = new HashMap();
            map.put("studentId", id);
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            List<Map<String, Object>> resultList = genericDAO.find(map ,"Student");
            if (resultList.size() == 0) {
                return null;
            }
            Map<String, Object> mapResult = resultList.get(0);
            student = TmsMapper.mapToDto(mapResult, new Student());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void update(DTO studentDTO) {
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.update(TmsMapper.dtoToMap(studentDTO),TmsMapper.getTableName(studentDTO), "studentId");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<DTO> findAll() {
        List<DTO> students = new ArrayList<>();
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            List<Map<String, Object>> resultList = genericDAO.findAll(new HashMap(),"Student");
            for(int loopCounter = 0 ; loopCounter < resultList.size(); loopCounter++) {
                Map<String, Object> mapResult = resultList.get(loopCounter);
                DTO student = TmsMapper.mapToDto(mapResult, new Student());
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

}
