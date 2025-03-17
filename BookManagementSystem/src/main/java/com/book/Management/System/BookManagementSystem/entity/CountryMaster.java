package com.book.Management.System.BookManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "country_master",indexes = {
        @Index(name = "countryName",columnList = "country_Name")
})
//@Index(name = "countaryName", columnList = "name")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
// This will ignore any fields that are not mapped in the entity
@Getter
@Setter
public class CountryMaster extends BaseEntity {

    @Column(name = "country_name", nullable = false)
    @JsonProperty("country_Name")
    private String countryName;

    @Column(name = "phone_code", nullable = false)
    @JsonProperty("phoneCode")
    private String phoneCode;


    @Column(name = "status", nullable = false)
    private Boolean status=true;

//    private Long phoneCode;

}
