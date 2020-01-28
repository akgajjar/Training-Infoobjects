package com.infoobjects.tms.dao.interfaces;

import java.util.List;

public interface DAO<Integer, T> {

    public void insert(T t, Integer id);

    public void delete(Integer id);

    public T find(Integer id);

    public void update(T t, Integer id);

    public List<T> findAll();

}
