package com.infoobjects.tms.dao.interfaces;

import java.util.List;

public interface DAO<Integer, DTO> {

    public void insert(DTO dto);

    public void delete(Integer id);

    public DTO find(Integer id);

    public void update(DTO dto);

    public List<DTO> findAll();

}
