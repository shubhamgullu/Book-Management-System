package com.book.Management.System.BookManagementSystem.service;

import com.book.Management.System.BookManagementSystem.entity.CityMaster;
import com.book.Management.System.BookManagementSystem.entity.CountryMaster;
import com.book.Management.System.BookManagementSystem.entity.StateMaster;
import com.book.Management.System.BookManagementSystem.repository.CityMasterRepository;
import com.book.Management.System.BookManagementSystem.repository.CountryMasterRepository;
import com.book.Management.System.BookManagementSystem.repository.StateMasterRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;


@Service
public class DataInsertServiceImpl {

    @Autowired
    private CountryMasterRepository countryMasterRepository;

    @Autowired
    private StateMasterRepository stateMasterRepository;

    @Autowired
    private CityMasterRepository cityMasterRepository;

//    private final Faker faker = new Faker(new Locale("en-IND"));
    private final Faker faker = new Faker();
    private final Random random = new Random();


    //add countary
    public void insertCountry() {

        //insert 50 country

        List<CountryMaster> countries = new ArrayList<>();


        for(int i=0;i<10;i++){
            CountryMaster countryMaster = new CountryMaster();
            countryMaster.setCountryName(faker.country().name());
            countryMaster.setPhoneCode(faker.country().currencyCode());
            countryMaster.setStatus(true);
            countryMaster.setCreatedAt(LocalDateTime.now());
            countryMaster.setUpdatedAt(LocalDateTime.now());
            countryMaster.setCreatedBy(99L);
            countryMaster.setUpdatedBy(99L);
            countries.add(countryMaster);
        }

        countryMasterRepository.saveAll(countries);

        //add multiple states in table
        List<StateMaster> states = new ArrayList<>();

        for (CountryMaster countryMaster:countries){
            int stateCount= faker.number().numberBetween(0, 50);
            for (int i = 0; i < stateCount; i++) {
                StateMaster state = new StateMaster();
                state.setStateName(faker.address().state());
                state.setStateCode(faker.address().stateAbbr());
                state.setCountry(countryMaster);
                state.setStatus(true);
                state.setCreatedAt(LocalDateTime.now());
                state.setUpdatedAt(LocalDateTime.now());
                state.setCreatedBy(99L);
                state.setUpdatedBy(99L);
                states.add(state);
            }
        }

        stateMasterRepository.saveAll(states);


        //add Cities

        List<CityMaster> cities = new ArrayList<>();
        int cityCount =faker.number().numberBetween(50, 500);
        for (int i = 0; i < cityCount; i++) {
            StateMaster state = states.get(random.nextInt(states.size())); // Random state

            CityMaster city = new CityMaster();
            city.setCityName(faker.address().city());
            city.setStateCode(state);
            city.setZipCode(Long.parseLong(faker.address().zipCode().replaceAll("[^0-9]", ""))); // Only digits
            city.setStatus(true);
            city.setCreatedAt(LocalDateTime.now());
            city.setUpdatedAt(LocalDateTime.now());
            city.setCreatedBy(99L);
            city.setUpdatedBy(99L);
            cities.add(city);
        }
        cityMasterRepository.saveAll(cities);




    }
}
