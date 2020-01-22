package com.infoobjects.tms.service.impl;

import com.infoobjects.tms.service.StudentService;
import com.infoobjects.tms.dao.ProjectDAO;
import com.infoobjects.tms.dto.StudentDTO;

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
