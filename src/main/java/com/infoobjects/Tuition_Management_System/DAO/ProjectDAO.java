package com.infoobjects.Tuition_Management_System.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectDAO<T>{

		private Map<Object, T> map=null;	
	
		public ProjectDAO() {
			map=new HashMap<Object, T>();
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
