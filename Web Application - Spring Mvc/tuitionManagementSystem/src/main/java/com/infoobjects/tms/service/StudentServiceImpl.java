package com.infoobjects.tms.service;

import com.infoobjects.tms.dao.TmsDAOImpl;
import com.infoobjects.tms.dto.Student;
import com.infoobjects.tms.dto.Teacher;
import com.infoobjects.tms.service.interfaces.StudentServiceIncrement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentServiceIncrement<Student> {

	@Autowired
	private TmsDAOImpl<Student> genericDAO;

	public void setGenericDAO(TmsDAOImpl<Student> genericDAO) {
		this.genericDAO = genericDAO;
	}

	@Override
	public void insert(Student studentDTO) {
		genericDAO.insert(studentDTO);
	}

	@Override
	public void delete(String id) {
		genericDAO.delete(id, Student.class);
	}

	@Override
	public Student find(String id) {
		return genericDAO.find(id, Student.class);
	}

	@Override
	public void update(Student studentDTO) {
		genericDAO.update(studentDTO);
	}

	@Override
	public List<Student> findAll() {
		return genericDAO.findAll(Student.class);
	}

}
