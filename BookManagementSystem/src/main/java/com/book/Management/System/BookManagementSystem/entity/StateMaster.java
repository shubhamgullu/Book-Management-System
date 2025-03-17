package com.book.Management.System.BookManagementSystem.entity;

import com.book.Management.System.BookManagementSystem.model.BaseVo;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "state_master",indexes = {
        @Index(name = "stateName",columnList = "state_name"),
        @Index(name = "stateCode",columnList = "state_code"),
        @Index(name = "state",columnList = "state_name, state_code",unique = true)
})
public class StateMaster extends BaseEntity {

    @Column(name = "state_name", nullable = false)
    private String stateName;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private CountryMaster country;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "state_code", nullable = false)
    private String stateCode;
}
