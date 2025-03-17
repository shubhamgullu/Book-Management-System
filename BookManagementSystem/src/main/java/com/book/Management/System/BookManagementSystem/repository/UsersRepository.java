package com.book.Management.System.BookManagementSystem.repository;

import com.book.Management.System.BookManagementSystem.entity.CityMaster;
import com.book.Management.System.BookManagementSystem.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    //findbyname
//    Optional<CityMaster> findByCityNameAndStateCode(String name, Long stateCode);
}
