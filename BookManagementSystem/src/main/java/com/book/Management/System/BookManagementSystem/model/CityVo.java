package com.book.Management.System.BookManagementSystem.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CityVo extends BaseVo{

    private String cityName;
    private StateVo stateVo;
    private Long zipCode;
}
