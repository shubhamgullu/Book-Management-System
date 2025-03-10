package com.book.Management.System.BookManagementSystem.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Books extends BaseEntity {

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(name = "book_details")
    private String bookDetails;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDetails authorId;

    @Column(name = "location")
    private String location;
}
