package com.book.Management.System.BookManagementSystem.service;

import java.util.List;

public interface DataOperationService {


    <T> T getEntityById(T entity, Long id);
//    List<?>  getAllEntity(Class<T> Entity) throws ClassNotFoundException;
    <T> List<T> getAllEntity(T entity);
//    <T> List<T> getAllEntity(String entity);
//    <T> List<T> getAllEntity(Class<T> entityClass);
<T> T  saveAllEntity(T entity, Object input);
//    void saveAllEntity(String entity, Object input);
}
