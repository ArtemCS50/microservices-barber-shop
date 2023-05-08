package com.diploma.catalogservice.controller;


import com.diploma.catalogservice.dto.ServiceDTO;
import com.diploma.catalogservice.dto.MasterDTO;
import com.diploma.catalogservice.model.Service;
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

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Service createProduct(@RequestBody Service service) {
//       return catalogService.createProduct(service);
//    }

    @GetMapping("/services")
    @ResponseStatus(HttpStatus.OK)
    public List<ServiceDTO> getAllServices() {
        return catalogService.getAllServices();
    }


    @GetMapping("/services/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ServiceDTO getServiceById(@PathVariable("id") Long id) {
        return catalogService.getServiceById(id);
    }

    @PostMapping("/services")
    @ResponseStatus(HttpStatus.CREATED)
    public ServiceDTO createService(@RequestBody ServiceDTO serviceDto) {
        return catalogService.createService(serviceDto);
    }

    @PutMapping("/services/{id}")
    public ServiceDTO updateService(@PathVariable Long id, @RequestBody ServiceDTO serviceDto) {
        return catalogService.updateService(id, serviceDto);
    }

    @DeleteMapping("/services/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteService(@PathVariable Long id) {
        catalogService.deleteService(id);
    }

    @GetMapping("/masters")
    @ResponseStatus(HttpStatus.OK)
    public List<MasterDTO> getAllMasters() {
        return catalogService.getAllMasters();
    }

    @GetMapping("/masters/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MasterDTO getMasterById(@PathVariable("id") Long id) {
        return catalogService.getMasterById(id);
    }
}
