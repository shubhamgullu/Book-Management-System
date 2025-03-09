package com.book.Management.System.BookManagementSystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "location_master")
public class LocationMaster extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    //for save details

    @Column(name = "category", nullable = false)
    private Long category;

    @Column(name = "location", nullable = false)
    private Long location;

    @Column(name = "reference_detail_id", nullable = false)
    private Long referenceDetailId;

}
