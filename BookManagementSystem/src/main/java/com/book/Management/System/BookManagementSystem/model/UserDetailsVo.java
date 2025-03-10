package com.book.Management.System.BookManagementSystem.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserDetailsVo extends BaseVo{

    private String firstName;
    private String LastName;
    private Long phone;
    private String middleName;
    private String email;
    private Date dateOfBirth;
    private Long categoryId;
    private String addressLine1;
    private String AddressLine2;
    private String postalCode;
    private Long cityId;

}
