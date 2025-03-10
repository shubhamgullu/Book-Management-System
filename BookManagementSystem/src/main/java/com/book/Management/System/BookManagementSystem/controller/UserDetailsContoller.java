package com.book.Management.System.BookManagementSystem.controller;

import com.book.Management.System.BookManagementSystem.entity.UserDetails;
import com.book.Management.System.BookManagementSystem.model.UserDetailsVo;
import com.book.Management.System.BookManagementSystem.service.UserdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Deprecated
@RestController
@RequestMapping("/api/userDetails")
public class UserDetailsContoller {

    @Autowired
    private UserdetailsService userdetailsService;


    @GetMapping("/{id}")
    public UserDetails getUserDetailById(@PathVariable Long id) {

        return userdetailsService.getUserDetailById(id);
    }


    @PostMapping("/saveUserDetails")
    public UserDetails getUserDetailById(@RequestBody UserDetailsVo userDetails) {

        return userdetailsService.saveUserDetails(userDetails);
    }


}
