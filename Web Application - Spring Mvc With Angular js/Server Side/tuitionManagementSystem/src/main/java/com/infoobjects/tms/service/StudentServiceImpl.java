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
	 * Logger for Logging Events
	 */
	private static final Logger logger = LoggerFactory.getLogger(TmsDAOImpl.class);

	/**
	 * Generic DAO Reference to Perform Database Operation on Student
	 */
	@Autowired
	private TmsDAOImpl<Student> genericDAO;

	/**
	 * used to insert Student record into Database
	 * 
	 * @param studentDTO Student's Data
	 */
	@Override
	public void insert(Student studentDTO) {
		try {
			genericDAO.insert(studentDTO);
			logger.info(String.format("Student is Saved Sucessfully, studentId : %s ", studentDTO.getStudentId()));
		} catch (DataAccessException dataAccessException) {
			logger.error(String.format("Student is not Saved Successfully, studentId : %s %nError Occured : %s", studentDTO.getStudentId(), dataAccessException.fillInStackTrace().toString()));
		} catch (Exception exception) {
			logger.error(String.format("Student is not Saved Successfully, studentId : %s %nError Occured : %s", studentDTO.getStudentId(), exception.fillInStackTrace().toString()));
		}
	}

	/**
	 * used to delete Student Record from Database for Specific Student Id
	 * 
	 * @param id Student's Id
	 */
	@Override
	public void delete(String studentId) {
		try {
			genericDAO.delete(studentId, Student.class);
			logger.info(String.format("Student is Deleted Successfully, Id : %s ",  studentId));
		} catch (DataAccessException dataAccessException) {
			logger.error(String.format("Student is not Deleted Successfully, studentId : %s %nError Occured : %s", studentId, dataAccessException.fillInStackTrace().toString()));
		} catch (Exception exception) {
			logger.error(String.format("Student is not Deleted Successfully, studentId : %s %nError Occured : %s", studentId, exception.fillInStackTrace().toString()));
		}
	}

	/**
	 * used to find Student record from Database of Specific Student Id
	 * 
	 * @param id Student's Id
	 * @return Student
	 */
	@Override
	public Student find(String studentId) {
		Student student = null;
		try {
			student = genericDAO.find(studentId, Student.class);
			logger.info(String.format("Student is Found Successfully, Id = %s %n", studentId));
		} catch (DataAccessException dataAccessException) {
			logger.error(String.format("Student is not Found Successfully, studentId = %s %nError Occured : %s", studentId, dataAccessException.fillInStackTrace().toString()));
		} catch (Exception exception) {
			logger.error(String.format("Student is not Found Successfully, studentId = %s %nError Occured : %s", studentId, exception.fillInStackTrace().toString()));
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
			logger.info(String.format("Student is Updated Successfully, studentId : ", studentDTO.getStudentId()));
		} catch (DataAccessException dataAccessException) {
			logger.error(String.format("Student is not Updated Successfully, studentId : %s %nError Occured : %s", studentDTO.getStudentId(), dataAccessException.fillInStackTrace().toString()));
		} catch (Exception exception) {
			logger.error(String.format("Student is not Updated Successfully, studentId : %s %nError Occured : %s", studentDTO.getStudentId(), exception.fillInStackTrace().toString()));
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
			logger.info("Students is Found Successfully");
		} catch (DataAccessException dataAccessException) {
			logger.error(String.format("Students is not Found Successfully, Error Occured : %s", dataAccessException));
		} catch (Exception exception) {
			logger.error(String.format("Students is not Found Successfully, Error Occured : %s", exception));
		}
		return students;
	}

}
