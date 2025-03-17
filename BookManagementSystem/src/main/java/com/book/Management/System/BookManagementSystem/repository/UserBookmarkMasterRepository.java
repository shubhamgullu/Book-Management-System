package com.book.Management.System.BookManagementSystem.repository;

import com.book.Management.System.BookManagementSystem.entity.UserBookmarkMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBookmarkMasterRepository extends JpaRepository<UserBookmarkMaster, Long> {
    //findbyname
//    Optional<CityMaster> findByCityNameAndStateCode(String name, Long stateCode);
}
