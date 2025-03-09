package com.book.Management.System.BookManagementSystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users extends BaseEntity {
//    @Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_type", nullable = false)
    private Long userType;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDetails userDetails;

    @Column(name = "password", nullable = false)
    private String password;
}
