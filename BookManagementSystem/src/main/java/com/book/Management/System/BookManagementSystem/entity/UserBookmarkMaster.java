package com.book.Management.System.BookManagementSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_bookmark_master")
public class UserBookmarkMaster extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "book_id", nullable = false)
    private Long bookId;

    @Column(name = "location_details", nullable = false)
    private Long locationDetails;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Column(name = "needtoaddoperation", nullable = false)
    private String needToAddOperation;
}
