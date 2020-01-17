package com.infoobjects.Tuition_Management_System.Service;

import java.util.List;

import com.infoobjects.Tuition_Management_System.DTO.StudentDTO;

public interface StudentService {
	
	public void insert(StudentDTO t);
    
    public void delete(int id);
    
    public StudentDTO find(int id);
    
    public void update(StudentDTO t);
    
    public List<StudentDTO> findAll();
}
