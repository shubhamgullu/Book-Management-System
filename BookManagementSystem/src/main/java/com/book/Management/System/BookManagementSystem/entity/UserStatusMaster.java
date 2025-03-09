package com.book.Management.System.BookManagementSystem.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_status_master")
@Data
public class UserStatusMaster extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDetails user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Books book;

    @Column(name = "last_location", nullable = false)
    private Long lastLocation;
}
