package com.infoobjects.tms.service;

import com.infoobjects.tms.dao.TmsDAOImpl;
import com.infoobjects.tms.entity.Teacher;
import com.infoobjects.tms.service.interfaces.TeacherServiceIncrement;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	 * Logger for Logging Events
	 */
	private static final Logger logger = LoggerFactory.getLogger(TmsDAOImpl.class);

	/**
	 * Generic DAO Reference to Perform Database Operation on Teacher
	 */
	@Autowired
	private TmsDAOImpl<Teacher> genericDAO;


	/**
	 * used to insert Student record into Database
	 * 
	 * @param teacherDTO Teacher's Data
	 */
	@Override
	public void insert(Teacher teacherDTO) {
		try {
			genericDAO.insert(teacherDTO);
			logger.info("Teacher is Saved Sucessfully, Data : %s ", teacherDTO);
		} catch (DataAccessException dataAccessException) {
			logger.error("Teacher is not Saved Successfully, Data : %s %nError Occured : %s", teacherDTO, dataAccessException.fillInStackTrace().toString());
		} catch (Exception exception) {
			logger.error("Teacher is not Saved Successfully, Data : %s %nError Occured : %s", teacherDTO, exception.fillInStackTrace().toString());
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
			logger.info("Teacher is Deleted Successfully, Id : %s ", id);
		} catch (DataAccessException dataAccessException) {
			logger.error("Teacher is not Deleted Successfully, Id : %s %nError Occured : %s", id, dataAccessException.fillInStackTrace().toString());
		} catch (Exception exception) {
			logger.error("Teacher is not Deleted Successfully, Id : %s %nError Occured : %s", id, exception.fillInStackTrace().toString());
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
			logger.info("Teacher is Found Successfully, Id = %s %n", id);
		} catch (DataAccessException dataAccessException) {
			logger.error("Teacher is not Found Successfully, id = %s %nError Occured : %s", id, dataAccessException.fillInStackTrace().toString());
		} catch (Exception exception) {
			logger.error("Teacher is not Found Successfully, id = %s %nError Occured : %s", id, exception.fillInStackTrace().toString());
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
			logger.info("Teacher is Updated Successfully, Data : %s", teacherDTO);
		} catch (DataAccessException dataAccessException) {
			logger.error("Teacher is not Updated Successfully, Data : %s %nError Occured : %s", teacherDTO, dataAccessException.fillInStackTrace().toString());
		} catch (Exception exception) {
			logger.error("Teacher is not Updated Successfully, Data : %s %nError Occured : %s", teacherDTO, exception.fillInStackTrace().toString());
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
			logger.info("Teachers is Found Successfully");
		} catch (DataAccessException dataAccessException) {
			logger.error("Teachers is not Found Successfully, Error Occured : %s", dataAccessException);
		} catch (Exception exception) {
			logger.error("Teachers is not Found Successfully, Error Occured : %s", exception);
		}
		return teachers;
	}

}
