package com.book.Management.System.BookManagementSystem.Testng.Generic.Code;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DynamicJpaRepository<T, ID> extends JpaRepository<T, ID> {
    List<T> findBy(String columnName, Object value);
}
