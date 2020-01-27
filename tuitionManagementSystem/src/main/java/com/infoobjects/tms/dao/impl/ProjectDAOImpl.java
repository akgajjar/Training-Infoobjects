package com.infoobjects.tms.dao.impl;

import com.infoobjects.tms.dao.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectDAOImpl<T,Object> implements DAO<T,Object> {

		private Map<T, Object> map=null;

		public ProjectDAOImpl() {
			map=new HashMap<T, Object>();
		}
	
		public void insert(T t, Object id) {
			map.put(id, t);
		}

		public void delete(Object id) {
			map.remove(id);
		}

		public T find(Object id) {
			return map.get(id);
		}

		public void update(T t, Object id) {
			map.put(id, t);
		}

		public List<T> findAll() {
			return  new ArrayList<T>(map.values());
		}

	}
