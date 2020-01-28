package com.infoobjects.tms.service;

import com.infoobjects.tms.dao.interfaces.DAO;
import com.infoobjects.tms.dao.StudentDAOImpl;
import com.infoobjects.tms.service.interfaces.Service;
import com.infoobjects.tms.dto.StudentDTO;

import java.util.List;

public class StudentServiceImpl implements Service<Integer,StudentDTO> {

    public DAO<Integer,StudentDTO> projectDao = new StudentDAOImpl();

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
