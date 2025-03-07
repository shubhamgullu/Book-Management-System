package com.book.Management.System.BookManagementSystem.controller;


import com.book.Management.System.BookManagementSystem.entity.UserCategoryMaster;
import com.book.Management.System.BookManagementSystem.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userCategory")
public class UserCategoryController {

    @Autowired
    private UserCategoryService userDetailsService;

    @GetMapping("/")
    public List<UserCategoryMaster> getAllUserCategory() {
        return userDetailsService.findAllUserCategory();
    }

    @PostMapping("/insertUserCategory")
    public void insertUserCategory(@RequestParam String categoryName) {
        userDetailsService.insertUserCategoryMaster(categoryName);
    }

    @PutMapping("/updateUserCategory")
    public void updateUserCategory(@RequestParam String categoryName) {
//        userDetailsService.updateUserCategoryMaster(categoryName);
//        userDetailsService.insertUserCategoryMaster(categoryName);
    }


}
