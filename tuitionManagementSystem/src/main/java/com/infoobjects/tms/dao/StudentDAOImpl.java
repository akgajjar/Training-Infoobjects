package com.infoobjects.tms.dao;

import com.infoobjects.tms.dao.interfaces.DAO;
import com.infoobjects.tms.dto.StudentDTO;
import com.infoobjects.tms.utils.TmsUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDAOImpl implements DAO<Integer, StudentDTO> {

    private Map<Integer, StudentDTO> map = null;

    public StudentDAOImpl() {
        map = new HashMap<Integer, StudentDTO>();
    }

    @Override
    public void insert(StudentDTO studentDTO) {
        map.put(studentDTO.getStudentId(), studentDTO);
        System.out.print(TmsUtils.insertSuccessmsg);
    }

    @Override
    public void delete(Integer id) {
        map.remove(id);
        System.out.print(TmsUtils.updateSuccessmsg);
    }

    @Override
    public StudentDTO find(Integer id) {
        return map.get(id);
    }

    @Override
    public void update(StudentDTO studentDTO) {
        map.put(studentDTO.getStudentId(), studentDTO);
        System.out.print(TmsUtils.updateSuccessmsg);
    }

    @Override
    public List<StudentDTO> findAll() {
        return new ArrayList<StudentDTO>(map.values());
    }

}
