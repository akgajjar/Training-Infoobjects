package com.infoobjects.tms.service.impl;

import com.infoobjects.tms.dao.DAO;
import com.infoobjects.tms.dao.impl.ProjectDAOImpl;
import com.infoobjects.tms.service.Service;
import com.infoobjects.tms.dto.StudentDTO;

import java.util.List;

public class StudentServiceImpl implements Service<StudentDTO,Integer> {

    public DAO<StudentDTO,Integer> projectDao = new ProjectDAOImpl();

	public void insert(StudentDTO t) {
		projectDao.insert(t, t.getStudentId());
	}

	public void delete(Integer id) {
		projectDao.delete(id);
	}

	public StudentDTO find(Integer id) {
		return projectDao.find(id);
	}

	public void update(StudentDTO t) {
		projectDao.update(t, t.getStudentId());
	}

	public List<StudentDTO> findAll() {
		return projectDao.findAll();
	}

}
