package com.book.Management.System.BookManagementSystem.repository;

import com.book.Management.System.BookManagementSystem.entity.LocationMaster;
import com.book.Management.System.BookManagementSystem.entity.ReferenceMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReferenceMasterRepository extends JpaRepository<ReferenceMaster, Long> {
}
