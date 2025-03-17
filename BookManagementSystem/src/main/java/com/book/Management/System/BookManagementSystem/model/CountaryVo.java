package com.book.Management.System.BookManagementSystem.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
@Component
@Getter
@Setter
public class CountaryVo extends BaseVo{
    private String name;
    private String phoneCode;
}
