package com.book.Management.System.BookManagementSystem.service.Impl;

import com.book.Management.System.BookManagementSystem.controller.genericCode.DynamicRepositoryService;
import com.book.Management.System.BookManagementSystem.entityManager.BaseConverter;
import com.book.Management.System.BookManagementSystem.service.DataOperationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DataOperationServiceImple implements DataOperationService {

    @Autowired
    private DynamicRepositoryService dynamicRepositoryService;

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    private BaseConverter baseConverter;

    @Override
    public <T> T getEntityById(T Entity, Long id)  {
        Class<?> entityClass = null;
        try {
            entityClass = Class.forName("com.book.Management.System.BookManagementSystem.entity." + Entity);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Create the repository dynamically
        JpaRepository repository = dynamicRepositoryService.createRepository(entityClass, Long.class);

        // Call findAll
        T entitiey = (T) repository.findById(id);

        return entitiey;
    }

    @Override
    public <T> List<T> getAllEntity(T entity) {
        Class<?> entityClass = null;
        try {
            entityClass = Class.forName("com.book.Management.System.BookManagementSystem.entity." + entity);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Create the repository dynamically
        JpaRepository repository = dynamicRepositoryService.createRepository(entityClass, Long.class);

        // Call findAll
        List<?> entities = repository.findAll();

        return (List<T>) entities;
    }

    @Override
    public <T> T saveAllEntity(T entity, Object input) {
        Class<?> entityClass = null;
        try {
            entityClass = Class.forName("com.book.Management.System.BookManagementSystem.entity." + entity);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
//            Class<?> entityClass = Class.forName("com.yourpackage.model." + entity);

        // Create the repository dynamically
        JpaRepository repository = dynamicRepositoryService.createRepository(entityClass, Long.class);

        //create object for save data

        Object entityInstance = objectMapper.convertValue(input, entityClass);
//        Object entityInstance = objectMapper.convertValue(input, entityClass);

        Object savedEntity = repository.save(entityInstance);

        return (T) savedEntity;
    }
//
//    @Override
//    public void saveAllEntity(T entity, Object entityObject) {
//
//        //call for the convertors
//        Class<?> entityClass = null;
//        try {
//            entityClass = Class.forName("com.book.Management.System.BookManagementSystem.entity." + entity);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
////            Class<?> entityClass = Class.forName("com.yourpackage.model." + entity);
//
//        // Create the repository dynamically
//        JpaRepository repository = dynamicRepositoryService.createRepository(entityClass, Long.class);
//
//        //create object for save data
//
//        Object entityInstance = objectMapper.convertValue(entityObject, entityClass);
//
//        Object savedEntity = repository.save(entityInstance);
//
//        return savedEntity;
//    }

//    @Override
//    public <T> List<T> getAllEntity(Class<T> entityClass) {
////        Class<?> entityClass = Class.forName("com.book.Management.System.BookManagementSystem.entity." + entity);
////
////        // Create the repository dynamically
////        JpaRepository repository = dynamicRepositoryService.createRepository(entityClass, Long.class);
////
////        // Call findAll
////        List<?> entities = repository.findAll();
////
////        return entities;
//    }




}
