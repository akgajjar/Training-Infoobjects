package com.infoobjects.tuitionManagementSystem.service;

import java.util.List;

import com.infoobjects.tuitionManagementSystem.dto.StudentDTO;

public interface StudentService {
	
	public void insert(StudentDTO t);
    
    public void delete(int id);
    
    public StudentDTO find(int id);
    
    public void update(StudentDTO t);
    
    public List<StudentDTO> findAll();

}
