package com.book.Management.System.BookManagementSystem.entity;

import com.book.Management.System.BookManagementSystem.model.BaseVo;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "state_master")
public class StateMaster extends BaseEntity {

    @Column(name = "state_name", nullable = false)
    private String stateName;

    @ManyToOne
    @JoinColumn(name = "countary_id", nullable = false)
    private CountryMaster country;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "state_code", nullable = false)
    private String stateCode;
}
