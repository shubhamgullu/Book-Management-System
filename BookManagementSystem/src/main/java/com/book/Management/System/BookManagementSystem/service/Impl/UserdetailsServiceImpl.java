package com.book.Management.System.BookManagementSystem.service.Impl;

import com.book.Management.System.BookManagementSystem.controller.genericCode.DynamicRepositoryService;
import com.book.Management.System.BookManagementSystem.entity.CityMaster;
import com.book.Management.System.BookManagementSystem.entity.UserAddressDetails;
import com.book.Management.System.BookManagementSystem.entity.UserDetails;
import com.book.Management.System.BookManagementSystem.model.UserDetailsVo;
import com.book.Management.System.BookManagementSystem.repository.UserCategoryMasterRepository;
import com.book.Management.System.BookManagementSystem.repository.UserDetailsRepository;
import com.book.Management.System.BookManagementSystem.service.UserdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserdetailsServiceImpl implements UserdetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private UserCategoryMasterRepository userCategoryMasterRepository;

    @Autowired
    private DynamicRepositoryService dynamicRepositoryService;

    @Override
    public UserDetails getUserDetailById(Long id) {
        return userDetailsRepository.findById(id).orElse(null);
    }

    @Override
    public UserDetails saveUserDetails(UserDetailsVo userDetails) {

        return userDetailsRepository.save(convertModelData(userDetails));

    }

    private UserDetails convertModelData(UserDetailsVo userDetailsVo) {
        UserDetails userDetails = new UserDetails();
        try {
            userDetails.setFirstName(userDetailsVo.getFirstName());
            userDetails.setLastName(userDetailsVo.getLastName());
            userDetails.setUserType(userCategoryMasterRepository.findById(userDetailsVo.getCategoryId()).orElseThrow(Exception::new));
            userDetails.setDob(userDetailsVo.getDateOfBirth());//format date
            userDetails.setEmail(userDetailsVo.getEmail());//format date
            userDetails.setPhone(userDetailsVo.getPhone());
            userDetails.setAddress(generateAddress(userDetailsVo));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userDetails;

    }

    private UserAddressDetails generateAddress(UserDetailsVo userDetailsVo) {
        UserAddressDetails addressDetails = new UserAddressDetails();
        JpaRepository cityMasterRepository = dynamicRepositoryService.createRepository(CityMaster.class, Long.class);
        addressDetails.setCity((CityMaster) cityMasterRepository.findById(userDetailsVo.getCityId()).orElse(null));
        return addressDetails;
    }
}
