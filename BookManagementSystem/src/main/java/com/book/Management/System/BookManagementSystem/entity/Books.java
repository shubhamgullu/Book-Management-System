package com.book.Management.System.BookManagementSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Books extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(name = "book_details", nullable = false)
    private String bookDetails;

    @Column(name = "author_id", nullable = false)
    private Long authorId;

    @Column(name = "author", nullable = false)
    private Long author;

    @Column(name = "location", nullable = false)
    private String location;
}
