package com.infoobjects.tms.service;

import java.util.List;

import com.infoobjects.tms.dao.ProjectDAO;
import com.infoobjects.tms.dto.StudentDTO;

public interface Service<T,Object> {

    public static ProjectDAO<StudentDTO> projectDao = new ProjectDAO<StudentDTO>();;

	public void insert(T t);
    
    public void delete(Object id);
    
    public T find(Object id);
    
    public void update(T t);
    
    public List<T> findAll();

}
