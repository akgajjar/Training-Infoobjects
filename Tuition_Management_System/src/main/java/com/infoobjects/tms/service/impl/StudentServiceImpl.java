package com.infoobjects.tuitionManagementSystem.service.impl;

import com.infoobjects.tuitionManagementSystem.dao.ProjectDAO;
import com.infoobjects.tuitionManagementSystem.dto.StudentDTO;
import com.infoobjects.tuitionManagementSystem.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

	private ProjectDAO<StudentDTO> projectDao = null;
	
	public StudentServiceImpl() {
		projectDao = new ProjectDAO<StudentDTO>();
	}

	public void insert(StudentDTO t) {
		projectDao.insert(t, t.getStudentId());
	}

	public void delete(int id) {
		projectDao.delete(id);
	}

	public StudentDTO find(int id) {
		return projectDao.find(id);
	}

	public void update(StudentDTO t) {
		projectDao.update(t, t.getStudentId());
	}

	public List<StudentDTO> findAll() {
		return projectDao.findAll();
	}
}
