package com.diploma.catalogservice.repository;


import com.diploma.catalogservice.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CatalogRepository extends JpaRepository<Catalog, String> {

}
