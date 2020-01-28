package com.infoobjects.tms.service.interfaces;

import java.util.List;

public interface Service<Integer,T> {

	public void insert(T t);
    
    public void delete(Integer id);
    
    public T find(Integer id);
    
    public void update(T t);
    
    public List<T> findAll();

}
