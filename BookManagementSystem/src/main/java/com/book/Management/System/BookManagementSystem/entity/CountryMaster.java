package com.book.Management.System.BookManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "country_master")
@Data
@JsonIgnoreProperties(ignoreUnknown = true) // This will ignore any fields that are not mapped in the entity
public class CountryMaster extends BaseEntity {

    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    private String name;

    @Column(name = "phone_code", nullable = false)
    @JsonProperty("phoneCode")
    private String phoneCode;
//    private Long phoneCode;

}
