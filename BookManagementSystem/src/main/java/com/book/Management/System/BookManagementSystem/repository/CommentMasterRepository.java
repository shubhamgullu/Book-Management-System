package com.book.Management.System.BookManagementSystem.repository;


import com.book.Management.System.BookManagementSystem.entity.CommentMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMasterRepository extends JpaRepository<CommentMaster, Long> {
}
