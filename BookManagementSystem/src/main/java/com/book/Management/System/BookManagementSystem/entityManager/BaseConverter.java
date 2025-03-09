package com.book.Management.System.BookManagementSystem.entityManager;

public abstract class BaseConverter<T>{
    private final Class<T> entityType;

    public BaseConverter(Class<T> entityType) {
        this.entityType = entityType;
    }

    public Class<T> getEntityType() {
        return entityType;
    }

    public abstract T convert(Object input);
}
