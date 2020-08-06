package com.infoobjects.tms.service.interfaces;

import java.util.List;

public interface Service<String,T> {

	void insert(T dto);
    
    void delete(String id);
    
    T find(String id);
    
    void update(T dto);
    
    List<T> findAll();

}
