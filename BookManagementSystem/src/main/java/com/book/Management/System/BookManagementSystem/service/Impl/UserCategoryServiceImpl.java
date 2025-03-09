package com.book.Management.System.BookManagementSystem.service.Impl;

import com.book.Management.System.BookManagementSystem.entity.UserCategoryMaster;
import com.book.Management.System.BookManagementSystem.repository.UserCategoryMasterRepository;
import com.book.Management.System.BookManagementSystem.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@Service
public class UserCategoryServiceImpl implements UserCategoryService {
//public class UserCategoryServiceImpl extends BaseDao implements UserCategoryService {

    @Autowired
    private UserCategoryMasterRepository userCategoryMasterRepository;


    @Override
    public List<UserCategoryMaster> findAllUserCategory() {

        return userCategoryMasterRepository.findAll();
//        return Collections.emptyList();
    }

    @Override
    public void insertUserCategoryMaster(String categoryName) {
        UserCategoryMaster userCategoryMaster = new UserCategoryMaster();
        //check if exist or not
//        userCategoryMaster.setCategoryName(categoryName);
//        userCategoryMaster.setStatus(true);
        //check if exist




        userCategoryMaster.setCategoryName(categoryName.trim().toUpperCase(Locale.ROOT).toUpperCase().replace(" ", "_"));
        userCategoryMaster.setUpdatedAt(LocalDateTime.now());
        userCategoryMasterRepository.save(userCategoryMaster);
    }


}
