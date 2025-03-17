package com.book.Management.System.BookManagementSystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.awt.print.Book;

@Entity
@Table(name = "user_bookmark_master")
@Data
public class UserBookmarkMaster extends BaseEntity {


//    @Column(name = "user_id", nullable = false)
    @OneToOne
    @JoinColumn(name = "user_id")
    private UserDetails userId;

//    @Column(name = "book_id", nullable = false)
    @OneToOne
    @JoinColumn(name = "book_id")
    private Books bookId;

//    @Column(name = "location_details", nullable = false)
    @OneToOne
    @JoinColumn(name = "location_details")
    private LocationMaster locationDetails;

    @Column(name = "comment")
    private String comment;
}
