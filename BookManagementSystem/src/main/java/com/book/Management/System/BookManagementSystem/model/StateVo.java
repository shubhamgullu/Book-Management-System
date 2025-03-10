package com.book.Management.System.BookManagementSystem.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class StateVo extends BaseVo {
    private CountaryVo CountaryVo;
    private String stateName;
    private String stateCode;
}
