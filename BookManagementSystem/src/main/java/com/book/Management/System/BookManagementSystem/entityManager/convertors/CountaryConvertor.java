package com.book.Management.System.BookManagementSystem.entityManager.convertors;

import com.book.Management.System.BookManagementSystem.entity.CountryMaster;
import com.book.Management.System.BookManagementSystem.entityManager.BaseConverter;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CountaryConvertor extends BaseConverter<CountryMaster> {
    private final ObjectMapper objectMapper;

    public CountaryConvertor(ObjectMapper objectMapper) {
        super(CountryMaster.class); // Pass entity class type
        this.objectMapper = objectMapper;
    }

    @Override
    public CountryMaster convert(Object input) {
        return objectMapper.convertValue(input, CountryMaster.class);
    }
}
