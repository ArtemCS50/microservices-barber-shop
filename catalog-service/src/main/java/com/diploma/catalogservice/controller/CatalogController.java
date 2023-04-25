package com.diploma.catalogservice.controller;


import com.diploma.catalogservice.model.Catalog;
import com.diploma.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Catalog createProduct(@RequestBody Catalog catalog) {
       return catalogService.createProduct(catalog);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Catalog> getAllServices() {
        return catalogService.getAllServices();
    }

}
