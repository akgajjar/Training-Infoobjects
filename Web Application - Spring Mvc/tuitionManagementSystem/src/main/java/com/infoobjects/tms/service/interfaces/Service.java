package com.infoobjects.tms.service.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface Service<String, T> {

    void insert(T dto);

    void delete(String id) throws SQLException;

    T find(String id);

    void update(T dto);

    List<T> findAll();

}
