package com.infoobjects.tms.dao;

import com.infoobjects.tms.dao.interfaces.DAO;
import com.infoobjects.tms.dto.StudentDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDAOImpl implements DAO<Integer, StudentDTO> {

    private Map<Integer, StudentDTO> map = null;

    public StudentDAOImpl() {
        map = new HashMap<Integer, StudentDTO>();
    }

    public void insert(StudentDTO t, Integer id) {
        map.put(id, t);
    }

    public void delete(Integer id) {
        map.remove(id);
    }

    public StudentDTO find(Integer id) {
        return map.get(id);
    }

    public void update(StudentDTO t, Integer id) {
        map.put(id, t);
    }

    public List<StudentDTO> findAll() {
        return new ArrayList<StudentDTO>(map.values());
    }

}
