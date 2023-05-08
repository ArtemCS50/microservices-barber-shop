package com.diploma.catalogservice.repository;


import com.diploma.catalogservice.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CatalogRepository extends JpaRepository<Service, String> {

}
