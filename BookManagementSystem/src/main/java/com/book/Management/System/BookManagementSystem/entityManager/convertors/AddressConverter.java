package com.book.Management.System.BookManagementSystem.entityManager.convertors;

import com.book.Management.System.BookManagementSystem.controller.genericCode.DynamicRepositoryService;
import com.book.Management.System.BookManagementSystem.entity.CountryMaster;
import com.book.Management.System.BookManagementSystem.entity.UserAddressDetails;
import com.book.Management.System.BookManagementSystem.entityManager.BaseConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressConverter extends BaseConverter<UserAddressDetails> {

    private final ObjectMapper objectMapper;

    @Autowired
    private DynamicRepositoryService dynamicRepositoryService;


    public AddressConverter(Class<UserAddressDetails> entityType, ObjectMapper objectMapper) {
        super(entityType);
        this.objectMapper = objectMapper;
    }

    @Override
    public UserAddressDetails convert(Object input) {

        //validate data form input


        return objectMapper.convertValue(input, UserAddressDetails.class);
    }
}
