package com.infoobjects.tms.dao;

import com.infoobjects.tms.mapper.TmsMapper;
import com.infoobjects.tms.dao.interfaces.DAO;
import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.utils.TmsUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDAOImpl implements DAO<Integer, Student> {

    private Map<Integer, Student> map;

    public StudentDAOImpl() {
        map = new HashMap<Integer, Student>();
    }

    @Override
    public void insert(Student studentDTO) {
        map.put(studentDTO.getStudentId(), studentDTO);
        try {
            TmsDAOImpl genericDAO = new TmsDAOImpl();
            genericDAO.insert(TmsMapper.dtoToMap(studentDTO),TmsMapper.getTableName(studentDTO));
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print(TmsUtils.insertSuccessmsg);
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
        return map.get(id);
    }

    @Override
    public void update(Student studentDTO) {
        map.put(studentDTO.getStudentId(), studentDTO);
        System.out.print(TmsUtils.updateSuccessmsg);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<Student>(map.values());
    }

}
