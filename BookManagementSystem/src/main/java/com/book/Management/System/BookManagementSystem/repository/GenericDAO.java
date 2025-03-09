package com.book.Management.System.BookManagementSystem.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDAO {
    <T> void saveOrUpdate(final T entity);

    <T> Object getById(Class<T> entityClass, long id);

    <T> Long save(final T entity);

    <T> void delete(final T entity);

    <T> T merge(final T entity);

    <T> T getEntityById(Class<T> claz, Serializable id);

    <T> void saveUpdateBatch(List<T> collections, int batchSize);

    <T> List fetchDataFromEntity(final String query, final Map<String, Object> map);

    <T> List<T> fetchDataUsingTransformers(String query, Map<String, Object> map, Class<T> passedClass);

    <T> List<T> fetchDataUsingSqlWithTransformers(String query, Map<String, Object> map, Class<T> passedClass);

    <T> T update(final T entity);
}
