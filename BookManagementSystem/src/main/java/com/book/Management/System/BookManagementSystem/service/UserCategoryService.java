package com.book.Management.System.BookManagementSystem.service;

import com.book.Management.System.BookManagementSystem.entity.UserCategoryMaster;

import java.util.List;

public interface UserCategoryService {

    List<UserCategoryMaster> findAllUserCategory();

    void insertUserCategoryMaster(String categoryName);

//    void updateUserCategoryMaster();
}
