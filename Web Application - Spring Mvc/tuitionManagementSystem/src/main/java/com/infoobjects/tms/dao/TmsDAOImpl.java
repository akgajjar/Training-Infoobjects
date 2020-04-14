package com.infoobjects.tms.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Aniket
 * @description Generic DAO class used to perform all Database related
 *              Operations
 */
@Repository
public class TmsDAOImpl<T> {

	/**
	 * Logger for Logging Events
	 */
	private static final Logger logger = LoggerFactory.getLogger(TmsDAOImpl.class);

	/**
	 * HibernateTemplate Reference used to Perform Database Operations
	 */
	@Autowired
	private HibernateTemplate template;

	/**
	 * setters
	 */
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	/**
	 * Used to Perform Insert Operations for Specific Entity into Database
	 * 
	 * @param reference Record Data
	 */
	@Transactional
	public void insert(T reference) throws Exception {
		StringBuilder logMessage = new StringBuilder(reference.getClass().getName());
		try {
			template.save(reference);
			logMessage.append(" is Saved Successfully, ");
			logMessage.append(reference.getClass().getName());
			logger.info(logMessage.toString());
		} catch (DataAccessException dataAccessException) {
			logMessage.append(" is not Saved , Details =  ");
			logMessage.append(reference);
			logMessage.append(" Error Occured = ");
			logMessage.append(dataAccessException.fillInStackTrace().toString());
			logger.error(logMessage.toString());
			throw dataAccessException;
		} catch (Exception exception) {
			logMessage.append(" is not Saved , Details = ");
			logMessage.append(reference);
			logMessage.append(" Error Occured = ");
			logMessage.append(exception.fillInStackTrace().toString());
			throw exception;
		}
	}

	/**
	 * Used to Perform Delete Operations for Specific Entity from Database
	 * 
	 * @param id        Record's Id
	 * @param classType Entity Class Type
	 */
	@Transactional
	public void delete(String id, Class<T> classType) throws Exception {
		StringBuilder logMessage = new StringBuilder(classType.getName());
		try {
			template.delete(find(id, classType));
			logMessage.append(" is Deleted Successfully, ");
			logMessage.append(classType.getName());
			logger.info(logMessage.toString());
		} catch (DataAccessException dataAccessException) {
			logMessage.append(" is not deleted , Details = id : ");
			logMessage.append(id);
			logMessage.append(" Error occured =  ");
			logMessage.append(dataAccessException.fillInStackTrace().toString());
			throw dataAccessException;
		} catch (Exception exception) {
			logMessage.append(" is not deleted , Details = id : ");
			logMessage.append(id);
			logMessage.append(" Error occured =  ");
			logMessage.append(exception.fillInStackTrace().toString());
			throw exception;
		}
	}

	/**
	 * Used to Find Specific Entity record from Database
	 * 
	 * @param id        Record's Id
	 * @param classType Entity Class Type
	 * @return T
	 */
	@Transactional
	public T find(String id, Class<T> classType) throws Exception {
		StringBuilder logMessage = new StringBuilder(classType.getName());
		try {
			T foundReference = (T) template.get(classType, id);
			logMessage.append(" is found successfully, ");
			logMessage.append(classType.getName());
			logger.info(logMessage.toString());
			return foundReference;
		} catch (DataAccessException dataAccessException) {
			logMessage.append(" is not found successfully,for id = ").append(id).append(" Error occured =  ")
					.append(dataAccessException.fillInStackTrace().toString());
			throw dataAccessException;
		} catch (Exception exception) {
			logMessage.append(" is not found,for id = ");
			logMessage.append(id);
			logMessage.append(" Error occured =  ");
			logMessage.append(exception.fillInStackTrace().toString());
			throw exception;
		}
	}

	/**
	 * Used to Perform Update Operations for Specific Entity into Database
	 * 
	 * @param reference Record Data
	 */
	@Transactional
	public void update(T reference) throws Exception {
		StringBuilder logMessage = new StringBuilder(reference.getClass().getName());
		try {
			template.update(reference);
			logMessage.append(" is updated successfully, ");
			logMessage.append(reference.getClass().getName());
			logger.info(logMessage.toString());
		} catch (DataAccessException dataAccessException) {
			logMessage.append(" is not updated , Details = ");
			logMessage.append(reference);
			logMessage.append(" Error Occured = ");
			logMessage.append(dataAccessException.fillInStackTrace().toString());
			logger.error(logMessage.toString());
			throw dataAccessException;
		} catch (Exception exception) {
			logMessage.append(" is not saved , Details = ");
			logMessage.append(reference);
			logMessage.append(" Error Occured = ");
			logMessage.append(exception.fillInStackTrace().toString());
			logger.error(logMessage.toString());
			throw exception;
		}
	}

	/**
	 * Used to get all records for Specific Entity from Database
	 * 
	 * @param type Entity Class Type
	 * @return List<T>
	 */
	@Transactional
	public List<T> findAll(Class<T> classType) throws Exception {
		StringBuilder logMessage = new StringBuilder(classType.getName());
		try {
			List<T> referenceList = template.loadAll(classType);
			logMessage.append("s is found successfully, ");
			logMessage.append(classType.getName());
			logger.info(logMessage.toString());
			return referenceList;
		} catch (DataAccessException dataAccessException) {
			logMessage.append("s is not found successfully, ");
			logMessage.append(" Error occured =  ");
			logMessage.append(dataAccessException);
			throw dataAccessException;
		} catch (Exception exception) {
			logMessage.append(" is not found successfully, ");
			logMessage.append(" Error occured =  ");
			logMessage.append(exception);
			throw exception;
		}
	}

}
