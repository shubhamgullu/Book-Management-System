package com.book.Management.System.BookManagementSystem.service;//package com.book.Management.System.BookManagementSystem.service;
//
//import org.apache.catalina.core.ApplicationContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Service;
//
//import java.io.Serializable;
//import java.util.Optional;
//
//@Service
//public interface GenericService {
/// /public interface GenericService <T, ID extends Serializable> {
//
////    @Autowired
////    private JpaRepository<T, ID> repository;
////
////    public Optional<T> findById(ID id) {
////        return repository.findById(id);
////    }
////
////    public T save(T entity) {
////        return repository.save(entity);
////    }
//
//    @Autowired
//     ApplicationContext applicationContext;
//
//    public static <T, ID extends Serializable> Optional<T> findById(Class<T> clazz, ID id) {
//        JpaRepository<T, ID> repository = (JpaRepository<T, ID>) applicationContext.getBean(clazz.getSimpleName() + "Repository");
//        return repository.findById(id);
//    }
//
//    public default <T> T save(Class<T> clazz, T entity) {
//        JpaRepository<T, ?> repository = (JpaRepository<T, ?>) applicationContext.getBean(clazz.getSimpleName() + "Repository");
//        return repository.save(entity);
//    }
//}
