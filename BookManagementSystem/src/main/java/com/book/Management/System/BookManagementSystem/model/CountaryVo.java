package com.book.Management.System.BookManagementSystem.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CountaryVo extends BaseVo{
    private String name;
    private String phoneCode;
}
