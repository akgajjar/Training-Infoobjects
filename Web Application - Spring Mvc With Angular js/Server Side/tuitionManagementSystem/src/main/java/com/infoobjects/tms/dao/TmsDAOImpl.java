package com.infoobjects.tms.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Aniket
 * @description Generic DAO class used to perform all Database related
 * Operations
 */
@Repository
public class TmsDAOImpl<T> {

    /**
     * HibernateTemplate Reference used to Perform Database Operations
     */
    @Autowired
    private HibernateTemplate template;

    /**
     * Used to Perform Insert Operations for Specific Entity into Database
     *
     * @param reference Record Data
     * @throws Exception
     */
    @Transactional
    public void insert(T reference) throws Exception {
        template.save(reference);
    }

    /**
     * Used to Perform Delete Operations for Specific Entity from Database
     *
     * @param id        Record's Id
     * @param classType Entity Class Type
     * @throws Exception
     */
    @Transactional
    public void delete(String id, Class<T> classType) throws Exception {
        template.delete(find(id, classType));
    }

    /**
     * Used to Find Specific Entity record from Database
     *
     * @param id        Record's Id
     * @param classType Entity Class Type
     * @return T
     * @throws Exception
     */
    @Transactional
    public T find(String id, Class<T> classType) throws Exception {
        return (T) template.get(classType, id);
    }

    /**
     * Used to Perform Update Operations for Specific Entity into Database
     *
     * @param reference Record Data
     * @throws Exception
     */
    @Transactional
    public void update(T reference) throws Exception {
        template.update(reference);
    }

    /**
     * Used to get all records for Specific Entity from Database
     *
     * @param classType Entity Class Type
     * @return List<T>
     * @throws Exception
     */
    @Transactional
    public List<T> findAll(Class<T> classType) throws Exception {
        return template.loadAll(classType);
    }

}
