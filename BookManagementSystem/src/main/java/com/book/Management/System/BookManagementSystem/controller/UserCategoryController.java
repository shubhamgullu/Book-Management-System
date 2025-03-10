package com.book.Management.System.BookManagementSystem.controller;


import com.book.Management.System.BookManagementSystem.controller.genericCode.DynamicRepositoryService;
import com.book.Management.System.BookManagementSystem.entity.CityMaster;
import com.book.Management.System.BookManagementSystem.entity.CountryMaster;
import com.book.Management.System.BookManagementSystem.entity.StateMaster;
import com.book.Management.System.BookManagementSystem.entity.UserCategoryMaster;
import com.book.Management.System.BookManagementSystem.model.CityVo;
import com.book.Management.System.BookManagementSystem.model.CountaryVo;
import com.book.Management.System.BookManagementSystem.model.StateVo;
import com.book.Management.System.BookManagementSystem.repository.UserCountaryMaster;
import com.book.Management.System.BookManagementSystem.service.UserCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static javafx.scene.input.KeyCode.T;

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
        List<?> entities = repository.findAll();
        return (List<CountryMaster>) entities;
    }

    @Transactional
    @PostMapping("/insertCountry")
    public CountryMaster insertCountary(@RequestBody CountaryVo countaryVo) {
        JpaRepository repository = dynamicRepositoryService.createRepository(CountryMaster.class, Long.class);
        CountryMaster countryMaster = new CountryMaster();
        countryMaster.setName(countaryVo.getName());
        countryMaster.setPhoneCode(countaryVo.getPhoneCode());
        countryMaster.setStatus(true);
        countryMaster= (CountryMaster) repository.save(countryMaster);
        return countryMaster;
    }

    @GetMapping("/getCountryRyById/{id}")
    public CountryMaster getCountryDetailsById(@PathVariable Long id) {
        JpaRepository repository = dynamicRepositoryService.createRepository(CountryMaster.class, Long.class);
        Optional entities = repository.findById(id);
        if(entities.isPresent()){
            return (CountryMaster) entities.get();
        }
        return null;
    }

    @GetMapping("/getStateById/{id}")
    public StateMaster getStateById(@PathVariable Long id) {
        JpaRepository repository = dynamicRepositoryService.createRepository(StateMaster.class, Long.class);
        Optional entities = repository.findById(id);
        if(entities.isPresent()){
            return (StateMaster) entities.get();
        }
        return null;
    }


    @GetMapping("/getStateList")
    public List<StateMaster> getAllStateDetails() {
        JpaRepository repository = dynamicRepositoryService.createRepository(StateMaster.class, Long.class);
        List<?> entities = repository.findAll();
        return (List<StateMaster>) entities;
    }

    @Transactional
    @PostMapping("/insertStates")
    public StateMaster insertState(@RequestBody StateVo stateVo) {

        JpaRepository repository = dynamicRepositoryService.createRepository(StateMaster.class, Long.class);
        StateMaster stateMaster = new StateMaster();
        stateMaster.setStateName(stateVo.getStateName());
        CountryMaster countaryMaster = getCountryDetailsById(stateVo.getCountaryVo().getId());
        if(countaryMaster==null){
            countaryMaster=insertCountary(stateVo.getCountaryVo());
        }
        stateMaster.setCountry(countaryMaster);
//        stateMaster.setCountry(dynamicRepositoryService.createRepository(CountryMaster.class, Long.class).findById(stateVo.getCountaryVo().getId()).orElse(null));
        stateMaster.setStateCode(stateVo.getStateCode());
        stateMaster.setUpdatedAt(LocalDateTime.now());
        stateMaster.setStatus(true);
        stateMaster.setUpdatedAt(LocalDateTime.now());
        stateMaster= (StateMaster) repository.save(stateMaster);
        return stateMaster;
    }

    @GetMapping("/getCityList")
    public List<CityMaster> getAllCity() {
        JpaRepository repository = dynamicRepositoryService.createRepository(CityMaster.class, Long.class);
        List<?> entities = repository.findAll();
        return (List<CityMaster>) entities;
    }

    @Transactional
    @PostMapping("/insertCity")
    public CityMaster insertCity(@RequestBody CityVo cityVo) {

        JpaRepository repository = dynamicRepositoryService.createRepository(CityMaster.class, Long.class);
        CityMaster cityMaster = new CityMaster();
        cityMaster.setCityName(cityVo.getCityName());
        StateMaster stateMaster = getStateById(cityVo.getStateVo().getId());
        if(stateMaster==null){
          stateMaster=  insertState(cityVo.getStateVo());
        }
        cityMaster.setStateCode(stateMaster);
//        cityMaster .setStateCode(dynamicRepositoryService.createRepository(StateMaster.class, Long.class).findById(cityVo.getStateVo().getId()).orElse(null));
        cityMaster.setZipCode(cityVo.getZipCode());
        cityMaster .setUpdatedAt(LocalDateTime.now());
        cityMaster.setStatus(true);
        cityMaster = (CityMaster) repository.save(cityMaster);
        return cityMaster;
    }



    @PostMapping("/insertUserCategory")
    public void insertUserCategory(@RequestParam String categoryName) {
        userDetailsService.insertUserCategoryMaster(categoryName);
    }


}
