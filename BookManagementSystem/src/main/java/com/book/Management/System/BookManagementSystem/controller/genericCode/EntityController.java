package com.book.Management.System.BookManagementSystem.controller.genericCode;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class EntityController {@Autowired
private EntityScannerService entityScannerService;

    @GetMapping("/entities")
    public Map<String, JsonNode> getEntities() throws IOException, ClassNotFoundException {
        return entityScannerService.getEntitiesWithDataTypes();
    }
}
