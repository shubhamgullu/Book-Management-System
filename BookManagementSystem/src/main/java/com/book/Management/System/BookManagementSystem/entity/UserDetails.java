package com.book.Management.System.BookManagementSystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user_details")
public class UserDetails extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "dob", nullable = false)
    private Date dob;

    @Column(name = "status", nullable = false)
    private final Long status = 1L;

    @ManyToOne
    @JoinColumn(name = "user_type", nullable = false)
    private UserCategoryMaster userType;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private Long phone;

    @ManyToOne
    @JoinColumn(name = "address")
    private UserAddressDetails address;
}
