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
			logger.info(String.format("Teacher is Saved Sucessfully, teacherId : %s ", teacherDTO.getTeacherId()));
		} catch (DataAccessException dataAccessException) {
			logger.error(String.format("Teacher is not Saved Successfully, teacherId : %s %nError Occured : %s", teacherDTO.getTeacherId(), dataAccessException.fillInStackTrace().toString()));
		} catch (Exception exception) {
			logger.error(String.format("Teacher is not Saved Successfully, teacherId : %s %nError Occured : %s", teacherDTO.getTeacherId(), exception.fillInStackTrace().toString()));
		}
	}

	/**
	 * used to delete Teacher Record from Database for Specific Teacher Id
	 * 
	 * @param id Teacher's Id
	 */
	@Override
	public void delete(String teacherId) {
		try {
			genericDAO.delete(teacherId, Teacher.class);
			logger.info(String.format("Teacher is Deleted Successfully, teacherId : %s ", teacherId));
		} catch (DataAccessException dataAccessException) {
			logger.error(String.format("Teacher is not Deleted Successfully, teacherId : %s %nError Occured : %s", teacherId, dataAccessException.fillInStackTrace().toString()));
		} catch (Exception exception) {
			logger.error(String.format("Teacher is not Deleted Successfully, teacherId : %s %nError Occured : %s", teacherId, exception.fillInStackTrace().toString()));
		}
	}

	/**
	 * used to find Teacher record from Database of Specific Teacher Id
	 * 
	 * @param id Teacher's Id
	 * @return Teacher
	 */
	@Override
	public Teacher find(String teacherId) {
		Teacher teacher = null;
		try {
			teacher = genericDAO.find(teacherId, Teacher.class);
			logger.info(String.format("Teacher is Found Successfully, teacherId = %s %n", teacherId));
		} catch (DataAccessException dataAccessException) {
			logger.error(String.format("Teacher is not Found Successfully, teacherId = %s %nError Occured : %s", teacherId, dataAccessException.fillInStackTrace().toString()));
		} catch (Exception exception) {
			logger.error(String.format("Teacher is not Found Successfully, teacherId = %s %nError Occured : %s", teacherId, exception.fillInStackTrace().toString()));
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
			logger.info(String.format("Teacher is Updated Successfully, teacherId : %s", teacherDTO.getTeacherId()));
		} catch (DataAccessException dataAccessException) {
			logger.error(String.format("Teacher is not Updated Successfully, teacherId : %s %nError Occured : %s", teacherDTO.getTeacherId(), dataAccessException.fillInStackTrace().toString()));
		} catch (Exception exception) {
			logger.error(String.format("Teacher is not Updated Successfully, teacherId : %s %nError Occured : %s", teacherDTO.getTeacherId(), exception.fillInStackTrace().toString()));
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
			logger.error(String.format("Teachers is not Found Successfully, Error Occured : %s", dataAccessException));
		} catch (Exception exception) {
			logger.error(String.format("Teachers is not Found Successfully, Error Occured : %s", exception));
		}
		return teachers;
	}

}
