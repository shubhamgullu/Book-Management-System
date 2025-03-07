package com.book.Management.System.BookManagementSystem.controller.genericCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class DynamicRepositoryService {


    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ApplicationContext applicationContext;

    public <T, ID extends Serializable> JpaRepository<T, ID> createRepository(Class<T> entityClass, Class<ID> idClass) {
        return new JpaRepository<T, ID>() {

            private final JpaRepository<T, ID> repository;

            {
                // Create the repository dynamically using the JPA entity class.
                repository = new SimpleJpaRepository<>(entityClass, entityManager);
            }

            @Override
            public List<T> findAll() {
                return repository.findAll();
            }

            @Override
            public List<T> findAll(Sort sort) {
                return Collections.emptyList();
            }

            @Override
            public Page<T> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public List<T> findAllById(Iterable<ID> ids) {
                return Collections.emptyList();
            }

            @Override
            public <S extends T> List<S> saveAll(Iterable<S> entities) {
                return Collections.emptyList();
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends T> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends T> List<S> saveAllAndFlush(Iterable<S> entities) {
                return Collections.emptyList();
            }

            @Override
            public void deleteAllInBatch(Iterable<T> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<ID> ids) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public T getOne(ID id) {
                return null;
            }

            @Override
            public T getById(ID id) {
                return null;
            }

            @Override
            public T getReferenceById(ID id) {
                return null;
            }

            @Override
            public <S extends T> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends T> List<S> findAll(Example<S> example) {
                return Collections.emptyList();
            }

            @Override
            public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
                return Collections.emptyList();
            }

            @Override
            public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends T> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends T> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends T, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }

            @Override
            public Optional<T> findById(ID id) {
                return repository.findById(id);
            }

            @Override
            public <S extends T> S save(S entity) {
                return repository.save(entity);
            }

            @Override
            public boolean existsById(ID id) {
                return repository.existsById(id);
            }

            @Override
            public long count() {
                return repository.count();
            }

            @Override
            public void deleteById(ID id) {
                repository.deleteById(id);
            }

            @Override
            public void delete(T entity) {
                repository.delete(entity);
            }

            @Override
            public void deleteAllById(Iterable<? extends ID> ids) {

            }

            @Override
            public void deleteAll(Iterable<? extends T> entities) {
                repository.deleteAll(entities);
            }

            @Override
            public void deleteAll() {
                repository.deleteAll();
            }
        };
    }

}
