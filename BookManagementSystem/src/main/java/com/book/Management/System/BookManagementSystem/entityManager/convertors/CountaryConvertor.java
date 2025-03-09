package com.book.Management.System.BookManagementSystem.entityManager.convertors;

import com.book.Management.System.BookManagementSystem.controller.genericCode.DynamicRepositoryService;
import com.book.Management.System.BookManagementSystem.entity.CountryMaster;
import com.book.Management.System.BookManagementSystem.entityManager.BaseConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class CountaryConvertor extends BaseConverter<CountryMaster> {
    private final ObjectMapper objectMapper;

    public CountaryConvertor(ObjectMapper objectMapper) {
        super(CountryMaster.class); // Pass entity class type
        this.objectMapper = objectMapper;
    }

    @Autowired
    private DynamicRepositoryService dynamicRepositoryService;
    @Override
    public CountryMaster convert(Object input) {

        //convert data and then check if value present or not
        CountryMaster countryMaster = null;

        JpaRepository repository = dynamicRepositoryService.createRepository(CountryMaster.class, Long.class);


//        repository.findbyName();

        return objectMapper.convertValue(input, CountryMaster.class);
    }
}
