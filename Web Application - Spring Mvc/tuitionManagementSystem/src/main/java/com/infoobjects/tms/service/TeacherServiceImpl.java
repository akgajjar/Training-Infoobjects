package com.infoobjects.tms.service;

import com.infoobjects.tms.dao.TmsDAOImpl;
import com.infoobjects.tms.entity.Student;
import com.infoobjects.tms.entity.Teacher;
import com.infoobjects.tms.service.interfaces.TeacherServiceIncrement;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeacherServiceImpl implements TeacherServiceIncrement<Teacher> {

	@Autowired
	private TmsDAOImpl<Teacher> genericDAO;

	public void setGenericDAO(TmsDAOImpl<Teacher> genericDAO) {
		this.genericDAO = genericDAO;
	}

	@Override
	public void insert(Teacher teacherDTO) {
		genericDAO.insert(teacherDTO);
	}

	@Override
	public void delete(String id) {
		genericDAO.delete(id, Teacher.class);
	}

	@Override
	public Teacher find(String id) {
		return genericDAO.find(id, Teacher.class);
	}

	@Override
	public void update(Teacher teacherDTO) {
		genericDAO.update(teacherDTO);
	}

	@Override
	public List<Teacher> findAll() {
		return genericDAO.findAll(Teacher.class);
	}
	
	
}
