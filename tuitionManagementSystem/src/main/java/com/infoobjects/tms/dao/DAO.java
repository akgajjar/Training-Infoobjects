package com.infoobjects.tms.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DAO<T, Object> {

    public Map map= new HashMap();

    public void insert(T t, Object id);

    public void delete(Object id);

    public T find(Object id);

    public void update(T t, Object id);

    public List<T> findAll();

}
