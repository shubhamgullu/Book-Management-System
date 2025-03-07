package com.book.Management.System.BookManagementSystem.service;

import com.book.Management.System.BookManagementSystem.entity.UserDetails;
import com.book.Management.System.BookManagementSystem.model.UserDetailsVo;

public interface UserdetailsService {


    UserDetails getUserDetailById(Long id);

    UserDetails saveUserDetails(UserDetailsVo userDetails);
}
