package com.book.Management.System.BookManagementSystem.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_bookmark_master")
@Data
public class UserBookmarkMaster extends BaseEntity {


    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Column(name = "location_details", nullable = false)
    private Long locationDetails;

    @Column(name = "comment")
    private String comment;

//    @Column(name = "needtoadd_operation", nullable = false)
//    private String needToAddOperation;
}
