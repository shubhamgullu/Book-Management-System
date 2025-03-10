package com.book.Management.System.BookManagementSystem.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "city_master")
@Data
public class CityMaster extends BaseEntity {

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "state_code", nullable = false)
    private StateMaster stateCode;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "zip_code", nullable = false)
    private Long zipCode;

}
