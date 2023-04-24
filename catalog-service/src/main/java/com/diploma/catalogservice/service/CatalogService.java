package com.diploma.catalogservice.service;

import com.diploma.catalogservice.model.Catalog;
import com.diploma.catalogservice.repository.CatalogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogService {
    private final CatalogRepository catalogRepository;

    public List<Catalog> getAllServices() {
        List<Catalog> catalogs = catalogRepository.findAll();

//        return products.stream().map(this::mapToProductResponse).toList();
        return catalogs.stream().map(catalog -> catalog).toList();
    }
}
