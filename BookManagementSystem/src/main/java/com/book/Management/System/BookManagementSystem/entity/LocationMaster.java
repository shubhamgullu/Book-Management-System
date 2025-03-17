package com.book.Management.System.BookManagementSystem.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "location_master")
@Data
public class LocationMaster extends BaseEntity {

    @Column(name = "category", nullable = false)
    private Long category_type;

    @Column(name = "location", nullable = false)
    private Long location;

    @OneToOne
    @JoinColumn(name = "reference_detail_id")
    private ReferenceMaster referenceDetailId;

}
