package com.infoobjects.tms.service;

import com.infoobjects.tms.dao.TmsDAOImpl;
import com.infoobjects.tms.entity.Teacher;
import com.infoobjects.tms.service.interfaces.TeacherServiceIncrement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

/**
 * @author Aniket
 * @description Service Class - used to Perform Data Transformation on Teacher
 */
@Service
public class TeacherServiceImpl implements TeacherServiceIncrement<Teacher> {

	/**
	 * Generic DAO Reference to Perform Database Operation on Teacher
	 */
	@Autowired
	private TmsDAOImpl<Teacher> genericDAO;

	/**
	 * setters
	 */
	public void setGenericDAO(TmsDAOImpl<Teacher> genericDAO) {
		this.genericDAO = genericDAO;
	}

	/**
	 * used to insert Student record into Database
	 * 
	 * @param teacherDTO Teacher's Data
	 */
	@Override
	public void insert(Teacher teacherDTO) {
		try {
			genericDAO.insert(teacherDTO);
		} catch (DataAccessException dataAccessException) {
			dataAccessException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * used to delete Teacher Record from Database for Specific Teacher Id
	 * 
	 * @param id Teacher's Id
	 */
	@Override
	public void delete(String id) {
		try {
			genericDAO.delete(id, Teacher.class);
		} catch (DataAccessException dataAccessException) {
			dataAccessException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * used to find Teacher record from Database of Specific Teacher Id
	 * 
	 * @param id Teacher's Id
	 * @return Teacher
	 */
	@Override
	public Teacher find(String id) {
		Teacher teacher = null;
		try {
			teacher = genericDAO.find(id, Teacher.class);
		} catch (DataAccessException dataAccessException) {
			dataAccessException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return teacher;
	}

	/**
	 * used to update Teacher into Database for Specific Teacher Id
	 * 
	 * @param teacherDTO Teacher and TeacherStudent Data
	 */
	@Override
	public void update(Teacher teacherDTO) {
		try {
			genericDAO.update(teacherDTO);
		} catch (DataAccessException dataAccessException) {
			dataAccessException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * used to find all Teacher Data with it's TeacherStudent Mapping Data
	 * 
	 * @return List<Teacher>
	 */
	@Override
	public List<Teacher> findAll() {
		List<Teacher> teachers = null;
		try {
			teachers = genericDAO.findAll(Teacher.class);
		} catch (DataAccessException dataAccessException) {
			dataAccessException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return teachers;
	}

}
