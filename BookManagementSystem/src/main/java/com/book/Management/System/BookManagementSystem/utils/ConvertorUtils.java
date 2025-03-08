package com.book.Management.System.BookManagementSystem.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ConvertorUtils {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T convertJsonToPojo(Object jsonMap, Class<T> targetClass) throws Exception {
        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // If the input object is a Map or LinkedHashMap, we can proceed to convert it
        if (jsonMap instanceof Map) {
            // Deserialize the map to the target class type
            T response = objectMapper.convertValue(jsonMap, targetClass);
            return response;
        } else {
            // Handle other types (e.g., raw JSON string) or throw an exception if the type is unsupported
            throw new IllegalArgumentException("Unsupported object type for conversion");
        }
    }
}
