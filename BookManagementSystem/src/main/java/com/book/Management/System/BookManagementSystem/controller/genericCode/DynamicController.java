package com.book.Management.System.BookManagementSystem.controller.genericCode;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dynamic")
public class DynamicController {


    @Autowired
    private DynamicRepositoryService dynamicRepositoryService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    // Endpoint to find all entities dynamically
    @GetMapping("/findAll/{entity}")
    public ResponseEntity<List<?>> findAll(@PathVariable String entity) {
        try {
            // Get the entity class dynamically
            Class<?> entityClass = Class.forName("com.book.Management.System.BookManagementSystem.entity." + entity);
//            Class<?> entityClass = Class.forName("com.yourpackage.model." + entity);

            // Create the repository dynamically
            JpaRepository repository = dynamicRepositoryService.createRepository(entityClass, Long.class);

            // Call findAll
            List<?> entities = repository.findAll();

            return ResponseEntity.ok(entities);
        } catch (ClassNotFoundException e) {
            return ResponseEntity.badRequest().body(Collections.singletonList("Entity class not found"));
        }
    }

    // Endpoint to save a new entity dynamically
    @PostMapping("/save/{entity}")
    @Transactional
    public ResponseEntity<?> saveEntity(@PathVariable String entity, @RequestBody Object entityObject) {
        try {
            // Get the entity class dynamically
            Class<?> entityClass = Class.forName("com.book.Management.System.BookManagementSystem.entity." + entity);
//            Class<?> entityClass = Class.forName("com.yourpackage.model." + entity);

            // Create the repository dynamically
            JpaRepository repository = dynamicRepositoryService.createRepository(entityClass, Long.class);

            // Save the entity
            //mapper
            ;
            Object entityInstance = objectMapper.convertValue(entityObject, entityClass);

            Object savedEntity = repository.save(entityInstance);
//            Object savedEntity = repository.save(convertJsonToPojo(entityObject,entityClass));
//            Object savedEntity = repository.save(objectMapper.readValue((JsonParser) entityObject, entityClass));

            return ResponseEntity.ok(savedEntity);
        } catch (ClassNotFoundException e) {
            return ResponseEntity.badRequest().body("Entity class not found");
        }
//        catch (StreamReadException e) {
//            throw new RuntimeException(e);
//        }
//        catch (DatabindException e) {
//            throw new RuntimeException(e);
//        }
//        catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static <T> T convertJsonToPojo(Object jsonMap, Class<T> targetClass) throws Exception {
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
//
//    private static <T> T convertJsonToPojo(Map<String, Object> jsonMap, Class<T> targetClass) throws Exception {
//        // Create ObjectMapper instance
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        // Deserialize the map to the target class type
//        T response = objectMapper.convertValue(jsonMap, targetClass);
//
//        // Return the converted object
//        return response;
//    }
}
