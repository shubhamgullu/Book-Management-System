package com.book.Management.System.BookManagementSystem.controller;


import com.book.Management.System.BookManagementSystem.controller.genericCode.DynamicRepositoryService;
import com.book.Management.System.BookManagementSystem.entity.CountryMaster;
import com.book.Management.System.BookManagementSystem.entity.UserCategoryMaster;
import com.book.Management.System.BookManagementSystem.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping("/api/userDetails")
public class UserCategoryController {

    @Autowired
    private UserCategoryService userDetailsService;

    @Autowired
    private DynamicRepositoryService dynamicRepositoryService;


    @GetMapping("/getUserCategory")
    public List<UserCategoryMaster> getAllUserCategory() {


        return userDetailsService.findAllUserCategory();
    }


    @GetMapping("/getCountryList")
    public List<CountryMaster> getAllCountaryDetails() {

        JpaRepository repository = dynamicRepositoryService.createRepository(CountryMaster.class, Long.class);

        // Call findAll
        List<?> entities = repository.findAll();

        return (List<CountryMaster>) entities;
    }

    @Transactional
    @PostMapping("/insertCountry")
    public void insertCountary(@RequestBody CountryMaster countryMaster) {

        JpaRepository repository = dynamicRepositoryService.createRepository(CountryMaster.class, Long.class);
//        CountryMaster countryMaster1 = new CountryMaster();
//        countryMaster1.setPhoneCode(countryMaster.getPhoneCode());
//        Example<CountryMaster> example = Example.of(countryMaster1);
//         List<CountryMaster> countryMasterList= (List<CountryMaster>) repository.findBy(example,  new Function<FluentQuery.FetchableFluentQuery<CountryMaster>, List<?>>() {
//             @Override
//             public List<?> apply(FluentQuery.FetchableFluentQuery<CountryMaster> query) {
//                 return query.all();
//             }
//         });
////         List<CountryMaster> countryMasterList= repository.findBy(example, query -> query.first());
//        System.out.println("collected");
        repository.save(countryMaster);

//        userDetailsService.insertUserCategoryMaster(categoryName);
    }







    @PostMapping("/insertUserCategory")
    public void insertUserCategory(@RequestParam String categoryName) {
        userDetailsService.insertUserCategoryMaster(categoryName);
    }


}
