package com.book.Management.System.BookManagementSystem.repository;

import com.book.Management.System.BookManagementSystem.entity.CityMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityMasterRepository extends JpaRepository<CityMaster, Long> {
}
