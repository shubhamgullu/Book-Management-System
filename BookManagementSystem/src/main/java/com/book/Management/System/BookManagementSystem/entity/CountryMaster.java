package com.book.Management.System.BookManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "country_master",indexes = {
        @Index(name = "countryName",columnList = "countryName")
})
//@Index(name = "countaryName", columnList = "name")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
// This will ignore any fields that are not mapped in the entity
public class CountryMaster extends BaseEntity {

    @Column(name = "countryName", nullable = false)
    @JsonProperty("countryName")
    private String countryName;

    @Column(name = "phone_code", nullable = false)
    @JsonProperty("phoneCode")
    private String phoneCode;


    @Column(name = "status", nullable = false)
    private Boolean status;

//    private Long phoneCode;

}
