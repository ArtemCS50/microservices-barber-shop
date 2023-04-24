package com.diploma.catalogservice.controller;

import com.diploma.catalogservice.model.Catalog;
import com.diploma.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/catalog")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @GetMapping
    public List<Catalog> getAllServices() {
        return catalogService.getAllServices();
    }

}
