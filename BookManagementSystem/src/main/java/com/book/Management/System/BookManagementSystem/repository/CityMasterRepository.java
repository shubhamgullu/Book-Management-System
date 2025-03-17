package com.book.Management.System.BookManagementSystem.repository;

import com.book.Management.System.BookManagementSystem.entity.CityMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityMasterRepository extends JpaRepository<CityMaster, Long> {
    //findbyname
    Optional<CityMaster> findByCityNameAndStateCode(String name, Long stateCode);


    @Query(value = "SELECT * FROM city_master cm  ORDER BY RAND() LIMIT 1", nativeQuery = true)
    CityMaster findRandomCity();

}
