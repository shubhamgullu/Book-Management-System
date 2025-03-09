package com.book.Management.System.BookManagementSystem.entityManager.convertors;

import com.book.Management.System.BookManagementSystem.entity.CityMaster;
import com.book.Management.System.BookManagementSystem.entityManager.BaseConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CityConvertor  extends BaseConverter<CityMaster> {
    private final ObjectMapper objectMapper;

    public CityConvertor(ObjectMapper objectMapper) {
        super(CityMaster.class);
        this.objectMapper = objectMapper;
    }

    @Override
    public CityMaster convert(Object input) {
        return objectMapper.convertValue(input, CityMaster.class);
    }


}
