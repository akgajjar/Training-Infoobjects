package com.infoobjects.tms.service.interfaces;

import java.util.List;

public interface Service<Integer,T> {

	public void insert(T dto);
    
    public void delete(Integer id);
    
    public T find(Integer id);
    
    public void update(T dto);
    
    public List<T> findAll();

}
