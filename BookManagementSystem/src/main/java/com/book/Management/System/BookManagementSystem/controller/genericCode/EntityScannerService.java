package com.book.Management.System.BookManagementSystem.controller.genericCode;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Service
public class EntityScannerService {


    private final ObjectMapper objectMapper = new ObjectMapper();

    // Method to scan all entity classes and create a JSON structure with data types
    public Map<String, JsonNode> getEntitiesWithDataTypes() throws IOException, ClassNotFoundException {
        String packageName = "com.book.Management.System.BookManagementSystem.entity"; // Adjust package name
        Map<String, JsonNode> entitiesJson = new HashMap<>();

        String path = packageName.replace('.', '/');
        URL resource = getClass().getClassLoader().getResource(path);

        if (resource == null) {
            throw new IOException("Package not found");
        }

        File directory = new File(resource.getFile());
        if (directory.exists()) {
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    entitiesJson.putAll(getEntitiesWithDataTypes()); // Recursively check sub-packages
                } else if (file.getName().endsWith(".class")) {
                    String className = packageName + "." + file.getName().substring(0, file.getName().length() - 6); // Remove '.class'

                    // Load the class and check if it's annotated with @Entity
                    Class<?> clazz = Class.forName(className);
                    if (clazz.isAnnotationPresent(Entity.class)) {
                        // Create an empty JSON object for this entity with data types
                        JsonNode entityJson = createEntityJsonWithDataTypes(clazz);
                        entitiesJson.put(clazz.getSimpleName(), entityJson);
                    }
                }
            }
        }

        return entitiesJson;
    }

    // Method to create a JSON object for a given entity class with data types
    private JsonNode createEntityJsonWithDataTypes(Class<?> clazz) {
        Map<String, Object> entityMap = new HashMap<>();

        // Loop through all fields of the entity class
        for (Field field : clazz.getDeclaredFields()) {
            // Add each field with its data type as a string
            String fieldName = field.getName();
            String fieldType = field.getType().getSimpleName(); // Get the type of the field (e.g., String, Long, etc.)
            entityMap.put(fieldName, fieldType);
        }

        // Convert the map to a JSON object
        return objectMapper.valueToTree(entityMap);
    }

//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    // Method to scan all entity classes and create JSON structure
//    public Map<String, JsonNode> getEntitiesAsJson() throws IOException, ClassNotFoundException {
//        String packageName = "com.book.Management.System.BookManagementSystem.entity"; // Adjust package name
//        Map<String, JsonNode> entitiesJson = new HashMap<>();
//
//        String path = packageName.replace('.', '/');
//        URL resource = getClass().getClassLoader().getResource(path);
//
//        if (resource == null) {
//            throw new IOException("Package not found");
//        }
//
//        File directory = new File(resource.getFile());
//        if (directory.exists()) {
//            for (File file : directory.listFiles()) {
//                if (file.isDirectory()) {
//                    entitiesJson.putAll(getEntitiesAsJson()); // Recursively check sub-packages
//                } else if (file.getName().endsWith(".class")) {
//                    String className = packageName + "." + file.getName().substring(0, file.getName().length() - 6); // Remove '.class'
//
//                    // Load the class and check if it's annotated with @Entity
//                    Class<?> clazz = Class.forName(className);
//                    if (clazz.isAnnotationPresent(Entity.class)) {
//                        // Create an empty JSON object for this entity
//                        JsonNode entityJson = createEmptyEntityJson(clazz);
//                        entitiesJson.put(clazz.getSimpleName(), entityJson);
//                    }
//                }
//            }
//        }
//
//        return entitiesJson;
//    }
//
//    // Method to create an empty JSON object for a given entity class
//    private JsonNode createEmptyEntityJson(Class<?> clazz) {
//        Map<String, Object> entityMap = new HashMap<>();
//
//        // Loop through all fields of the entity class
//        for (Field field : clazz.getDeclaredFields()) {
//            // Add each field with a null value to the map
//            entityMap.put(field.getName(), null);
//        }
//
//        // Convert the map to a JSON object
//        return objectMapper.valueToTree(entityMap);
//    }
}
