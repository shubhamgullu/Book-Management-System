package com.book.Management.System.BookManagementSystem.Testng.Generic.Code;

import com.book.Management.System.BookManagementSystem.controller.genericCode.DynamicRepositoryService;
import com.book.Management.System.BookManagementSystem.entity.CountryMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/GenericTesting")
public class TestingControllerGeneric {

    public interface MyRepository {
        List<CountryMaster> findByName(String name);
        List<CountryMaster> findByPostalCode(String postalCode);
        //...other methods
    }


    @Autowired
    private DynamicRepositoryFactory repositoryFactory;

    @GetMapping("/getCountryList")
    public List<CountryMaster> getAllCountryMaster() {

        DynamicJpaRepository<CountryMaster, Long> myRepository = repositoryFactory.createRepository(CountryMaster.class, Long.class);

        return  myRepository.findAll();

    }

    @Transactional
    @PostMapping("/insertCountry")
    public void CountryMaster(@RequestBody CountryMaster countryMaster) {


        DynamicJpaRepository<CountryMaster, Long> myRepository = repositoryFactory.createRepository(CountryMaster.class, Long.class);

        List<CountryMaster> countryMasterListFoundByPostalCode = myRepository.findBy("phoneCode",countryMaster.getPhoneCode());

        if(countryMasterListFoundByPostalCode.isEmpty()){
            myRepository.save(countryMaster);
        }

    }



//    public interface CountryMasterRepository extends JpaRepository<CountryMaster, Long>, JpaSpecificationExecutor<CountryMaster> {}
//
//    // In your service or controller:
//    Specification<CountryMaster> specification = (root, query, builder) ->
//            builder.equal(root.get("phoneCode"), countryMaster.getPhoneCode());
//    List<CountryMaster> countryMasterListFoundByPostalCode = countryMasterRepository.findAll(specification);
//


}
