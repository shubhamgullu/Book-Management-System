package com.book.Management.System.BookManagementSystem.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_category_master")
public class UserCategoryMaster extends BaseEntity {

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column(name = "category_details")
    private String categoryDetails;

    @Column(name = "status", nullable = false)
    private final Boolean status = true;

}
