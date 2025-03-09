package com.book.Management.System.BookManagementSystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.security.Permission;

@Entity
@Table(name = "users")
@Data
public class Users extends BaseEntity {

    @Column(name = "user_name", nullable = false)
    private String userName;
//
//    @ManyToOne
//    @JoinColumn(name = "user_group_type", nullable = false)
//    private PermissionMaster groupType;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDetails userDetails;

    @Column(name = "password", nullable = false)
    private String password;
}
