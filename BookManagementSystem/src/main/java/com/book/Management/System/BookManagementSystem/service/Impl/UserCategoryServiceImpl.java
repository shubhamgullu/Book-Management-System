package com.book.Management.System.BookManagementSystem.service.Impl;

import com.book.Management.System.BookManagementSystem.entity.UserCategoryMaster;
import com.book.Management.System.BookManagementSystem.repository.UserCategoryMasterRepository;
import com.book.Management.System.BookManagementSystem.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

import static com.book.Management.System.BookManagementSystem.utils.UtilOperations.convertInputUserCategory;

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
        UserCategoryMaster userCategoryMaster = null;

        String categoryNameString =convertInputUserCategory(categoryName);
        UserCategoryMaster userCategoryMaster1 = userCategoryMasterRepository.findByCategoryName(categoryNameString).orElse(null);

        if(userCategoryMaster1!=null){
            userCategoryMaster=userCategoryMaster1;
        }else{
            userCategoryMaster = new UserCategoryMaster();
            userCategoryMaster.setCategoryName(categoryNameString);

        }
        userCategoryMaster.setUpdatedAt(LocalDateTime.now());
        userCategoryMasterRepository.save(userCategoryMaster);
    }


}
