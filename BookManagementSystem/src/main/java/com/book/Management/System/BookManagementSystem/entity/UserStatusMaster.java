package com.book.Management.System.BookManagementSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_status_master")
public class UserStatusMaster extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDetails user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Books book;

    @Column(name = "last_location", nullable = false)
    private Long lastLocation;
}
