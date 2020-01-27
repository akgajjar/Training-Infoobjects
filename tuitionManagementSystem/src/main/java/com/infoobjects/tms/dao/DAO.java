package com.infoobjects.tms.dao;

import com.infoobjects.tms.dto.StudentDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DAO<T, Object> {

    public void insert(T t, Object id);

    public void delete(Object id);

    public T find(Object id);

    public void update(T t, Object id);

    public List<T> findAll();

}
