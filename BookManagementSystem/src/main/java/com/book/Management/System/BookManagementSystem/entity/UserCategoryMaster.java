package com.book.Management.System.BookManagementSystem.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_category_master")
public class UserCategoryMaster extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

//    public String getCategoryName() {
//        return categoryName;
//    }
//
//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
//
//    public Boolean getStatus() {
//        return status;
//    }
//
//    public void setStatus(Boolean status) {
//        this.status = status;
//    }

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @Column(name = "status", nullable = false)
    private final Boolean status = true;
//
//    @Column(name = "category_ui_name", nullable = false)
//    private String categoryUIName;

//    public String getCategoryUIName() {
//        return categoryUIName;
//    }
//
//    public void setCategoryUIName(String categoryUIName) {
//        this.categoryUIName = categoryUIName;
//    }
}
