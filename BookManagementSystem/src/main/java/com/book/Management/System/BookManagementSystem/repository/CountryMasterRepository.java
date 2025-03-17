package com.book.Management.System.BookManagementSystem.repository;

import com.book.Management.System.BookManagementSystem.entity.CityMaster;
import com.book.Management.System.BookManagementSystem.entity.CountryMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryMasterRepository extends JpaRepository<CountryMaster, Long> {
    //findbyname
//    Optional<CityMaster> findByCityNameAndStateCode(String name, Long stateCode);
}
