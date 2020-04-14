package com.infoobjects.tms.service;

import com.infoobjects.tms.dao.TmsDAOImpl;
import com.infoobjects.tms.entity.Student;
import com.infoobjects.tms.service.interfaces.StudentServiceIncrement;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

/**
 * @author Aniket
 * @description Service Class - used to Perform Data Transformation on Student
 */
@Service
public class StudentServiceImpl implements StudentServiceIncrement<Student> {

	/**
	 * Generic DAO Reference to Perform Database Operation on Student
	 */
	@Autowired
	private TmsDAOImpl<Student> genericDAO;

	/**
	 * setters
	 */
	public void setGenericDAO(TmsDAOImpl<Student> genericDAO) {
		this.genericDAO = genericDAO;
	}

	/**
	 * used to insert Student record into Database
	 * 
	 * @param studentDTO Student's Data
	 */
	@Override
	public void insert(Student studentDTO) {
		try {
			genericDAO.insert(studentDTO);
		} catch (DataAccessException dataAccessException) {
			dataAccessException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * used to delete Student Record from Database for Specific Student Id
	 * 
	 * @param id Student's Id
	 */
	@Override
	public void delete(String id) {
		try {
			genericDAO.delete(id, Student.class);
		} catch (DataAccessException dataAccessException) {
			dataAccessException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * used to find Student record from Database of Specific Student Id
	 * 
	 * @param id Student's Id
	 * @return Student
	 */
	@Override
	public Student find(String id) {
		Student student = null;
		try {
			student = genericDAO.find(id, Student.class);
		} catch (DataAccessException dataAccessException) {
			dataAccessException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return student;
	}

	/**
	 * used to update Student into Database for Specific Student Id
	 * 
	 * @param studentDTO Student Data
	 */
	@Override
	public void update(Student studentDTO) {
		try {
			genericDAO.update(studentDTO);
		} catch (DataAccessException dataAccessException) {
			dataAccessException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * used to find all Student Data with it's TeacherStudent Mapping Data
	 * 
	 * @return List<Student>
	 */
	@Override
	public List<Student> findAll() {
		List<Student> students = null;
		try {
			students = genericDAO.findAll(Student.class);
		} catch (DataAccessException dataAccessException) {
			dataAccessException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return students;
	}

}
