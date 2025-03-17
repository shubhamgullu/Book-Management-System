package com.book.Management.System.BookManagementSystem.controller;

import com.book.Management.System.BookManagementSystem.service.DataInsertServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/insertDummyData")
public class DataInsertController {

    @Autowired
    private DataInsertServiceImpl dataInsertService;


    @Transactional
    @PostMapping("/insertCountry")
    public void insertCountryData(){
            dataInsertService.insertCountry();
    }


    @Transactional
    @PostMapping("/insertUsersDetails")
    public void insertUserDetails() {
        dataInsertService.insertUserDetails();
    }

    @Transactional
    @PostMapping("/insertUsersCategory")
    public void insertUsercategory() {
        dataInsertService.insertCategory();
    }


}
