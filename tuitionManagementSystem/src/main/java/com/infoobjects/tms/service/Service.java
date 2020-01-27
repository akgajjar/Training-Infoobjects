package com.infoobjects.tms.service;

import java.util.List;

public interface Service<T,Object> {

	public void insert(T t);
    
    public void delete(Object id);
    
    public T find(Object id);
    
    public void update(T t);
    
    public List<T> findAll();

}
