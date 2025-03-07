package com.book.Management.System.BookManagementSystem.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_address_details")
public class UserAddressDetails extends BaseEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column(name = "address_line_1", nullable = false)
    private String addressLine1;

    @Column(name = "address_line_2", nullable = false)
    private String addressLine2;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private CityMaster city;

    @Column(name = "postal_code", nullable = false)
    private Long postalCode;
}
