package com.book.Management.System.BookManagementSystem.service;

import com.book.Management.System.BookManagementSystem.entity.*;
import com.book.Management.System.BookManagementSystem.repository.*;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.book.Management.System.BookManagementSystem.utils.UtilOperations.convertInputUserCategory;


@Service
public class DataInsertServiceImpl {

    @Autowired
    private CountryMasterRepository countryMasterRepository;

    @Autowired
    private StateMasterRepository stateMasterRepository;

    @Autowired
    private CityMasterRepository cityMasterRepository;
    @Autowired
    private UserAddressDetailsRepository addressDetailsRepository;
    @Autowired
    private UserCategoryMasterRepository userCategoryMasterRepository;

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


        //add addresses
        List<UserAddressDetails> addressDetails = new ArrayList<>();

        int addressLine = faker.number().numberBetween(500, 5000);

        for (int i = 0; i < addressLine; i++) {
            UserAddressDetails userAddressDetails = new UserAddressDetails();
            userAddressDetails.setAddressLine1(faker.address().fullAddress());
            userAddressDetails.setAddressLine2(faker.address().streetAddress());
            userAddressDetails.setCity(cityMasterRepository.findRandomCity());
            userAddressDetails.setPostalCode(Long.parseLong(faker.address().zipCode().replaceAll("[^0-9]", "")));
            userAddressDetails.setCreatedAt(LocalDateTime.now());
            userAddressDetails.setUpdatedAt(LocalDateTime.now());
            userAddressDetails.setCreatedBy(99L);
            userAddressDetails.setUpdatedBy(99L);
            addressDetails.add(userAddressDetails);
        }


        addressDetailsRepository.saveAll(addressDetails);

    }

    public void insertCategory() {
        int randomCategory = 50;

        String[] categoryDetails = new String[]{"Publisher", "reader","distributor","author"};

        List<UserCategoryMaster> userCategoryMasters=new ArrayList<>();
        for(int i=0;i<categoryDetails.length;i++){
            UserCategoryMaster userCategoryMaster = null;

            String categoryNameString =convertInputUserCategory(categoryDetails[i]);
//            String categoryNameString =convertInputUserCategory(faker.book().genre());
            UserCategoryMaster userCategoryMaster1 = userCategoryMasterRepository.findByCategoryName(categoryNameString).orElse(null);

            if(userCategoryMaster1!=null){
                userCategoryMaster=userCategoryMaster1;
            }else{
                userCategoryMaster = new UserCategoryMaster();
                userCategoryMaster.setCategoryName(categoryNameString);
                userCategoryMaster.setCategoryDetails(categoryDetails[i]);
//                userCategoryMaster.setCategoryDetails(faker.book().publisher());
                userCategoryMaster.setCreatedAt(LocalDateTime.now());
                userCategoryMaster.setCreatedBy(99L);
            }
            userCategoryMaster.setUpdatedAt(LocalDateTime.now());
            userCategoryMaster.setUpdatedBy(-99L);
            userCategoryMasters.add(userCategoryMaster);
        }

        userCategoryMasterRepository.saveAll(userCategoryMasters);

    }

    public void insertUserDetails() {




    }
}
