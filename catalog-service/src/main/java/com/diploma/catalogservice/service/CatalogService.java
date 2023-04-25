package com.diploma.catalogservice.service;

import com.diploma.catalogservice.model.Catalog;
import com.diploma.catalogservice.repository.CatalogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CatalogService {
    private final CatalogRepository catalogRepository;

    public List<Catalog> getAllServices() {
        List<Catalog> catalogs = catalogRepository.findAll();

//        return products.stream().map(this::mapToProductResponse).toList();
        return catalogs.stream().map(catalog -> catalog).toList();
    }


    public Catalog createProduct(Catalog catalog) {

        log.info("Product {} is saved", catalog.getId());
        return   catalogRepository.save(catalog);
    }
}
