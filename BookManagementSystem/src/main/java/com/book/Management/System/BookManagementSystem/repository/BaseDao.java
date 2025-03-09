package com.book.Management.System.BookManagementSystem.repository;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class BaseDao implements GenericDAO {

    private static final Logger logger = LoggerFactory.getLogger(BaseDao.class);

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public <T> void saveOrUpdate(T entity) {

    }


    @Override
    public <T> Object getById(final Class<T> entityClass, final long id) {
        return sessionFactory.getCurrentSession().load(entityClass, id);
    }

    @Override
    public <T> Long save(T entity) {
        return 0L;
    }

    @Override
    public <T> void delete(T entity) {

    }

    @Override
    public <T> T merge(T entity) {
        return null;
    }

    @Override
    public <T> T getEntityById(Class<T> claz, Serializable id) {
        return null;
    }

    @Override
    public <T> void saveUpdateBatch(List<T> collections, int batchSize) {

    }

    @Override
    public <T> List fetchDataFromEntity(String query, Map<String, Object> map) {
        return Collections.emptyList();
    }

    @Override
    public <T> List<T> fetchDataUsingTransformers(String query, Map<String, Object> map, Class<T> passedClass) {
        return Collections.emptyList();
    }

    @Override
    public <T> List<T> fetchDataUsingSqlWithTransformers(String query, Map<String, Object> map, Class<T> passedClass) {
        return Collections.emptyList();
    }

    @Override
    public <T> T update(T entity) {
        return null;
    }
}
