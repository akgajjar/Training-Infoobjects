package com.infoobjects.tms.dao;

import com.infoobjects.tms.dto.interfaces.DTO;
import static com.infoobjects.tms.mapper.TmsMapper.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TmsDAOImpl<T> {

	@Autowired
	private HibernateTemplate template;

	/*
	 * @Autowired private SessionFactory sessionFactory;
	 * 
	 * public void setSessionFactory(SessionFactory sf){ this.sessionFactory = sf; }
	 */

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Transactional
	public void insert(T reference) {
			template.save(reference);
	}

	@Transactional
	public void delete(String id,Class<T> type) {
		template.delete(find(id,type));
	}

	public T find(String id, Class<T> type) {
		return (T) template.get(type, id);
	}

	@Transactional
	public void update(T reference) {
		template.update(reference);
	}

	public List<T> findAll(Class<T> type) {
		return template.loadAll(type);
	}

}
