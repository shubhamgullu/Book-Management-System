package com.book.Management.System.BookManagementSystem.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reference_master")
@Data
public class ReferenceMaster extends BaseEntity { //table for reference like it's user photo, book photo, book location, or any other nosql data

    @Column(name = "category_name", nullable = false)
    private Long category_type;

    @Column(name = "reference_name")
    private Long referenceDetailId;

}
