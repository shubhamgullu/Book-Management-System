package com.book.Management.System.BookManagementSystem.entity;


import javax.persistence.*;

@Entity
@Table(name = "city_master")
public class CityMaster extends BaseEntity {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "countary_id", nullable = false)
    private CountryMaster country;

    @Column(name = "status", nullable = false)
    private Long status;

    @Column(name = "zip_code", nullable = false)
    private Long zipCode;

}
