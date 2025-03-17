package com.book.Management.System.BookManagementSystem.utils;

import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class UtilOperations {

    public static String convertInputUserCategory(String input){
        if(input!=null)
        {
            return input.toUpperCase(Locale.ROOT).replace(" ", "_").replaceAll("'/","_").toUpperCase();
        }
        return null;
    }
}
