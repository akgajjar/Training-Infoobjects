package com.infoobjects.tms.service;

import com.infoobjects.tms.dao.interfaces.DAO;
import com.infoobjects.tms.dao.StudentDAOImpl;
import com.infoobjects.tms.service.interfaces.Service;
import com.infoobjects.tms.dto.StudentDTO;

import java.util.List;

public class StudentServiceImpl implements Service<Integer,StudentDTO> {

    public DAO<Integer,StudentDTO> projectDao = new StudentDAOImpl();

	@Override
	public void insert(StudentDTO studentDTO) {
		projectDao.insert(studentDTO);
	}

	@Override
	public void delete(Integer id) {
		projectDao.delete(id);
	}

	@Override
	public StudentDTO find(Integer id) {
		return projectDao.find(id);
	}

	@Override
	public void update(StudentDTO  studentDTO) {
		projectDao.update(studentDTO);
	}

	@Override
	public List<StudentDTO> findAll() {
		return projectDao.findAll();
	}

}
