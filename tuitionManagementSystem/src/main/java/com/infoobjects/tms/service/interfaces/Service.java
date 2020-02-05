package com.infoobjects.tms.service.interfaces;

import java.util.List;

public interface Service<Integer,T> {

	void insert(T dto);
    
    void delete(Integer id);
    
    T find(Integer id);
    
    void update(T dto);
    
    List<T> findAll();

}
