package com.diploma.catalogservice.service;

import com.diploma.catalogservice.dto.ServiceDTO;
import com.diploma.catalogservice.dto.MasterDTO;
import com.diploma.catalogservice.exception.MasterNotFoundException;
import com.diploma.catalogservice.exception.ServiceNotFoundException;
import com.diploma.catalogservice.model.Service;
import com.diploma.catalogservice.model.Master;
import com.diploma.catalogservice.repository.MasterRepository;
import com.diploma.catalogservice.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Slf4j
public class CatalogService {

    private final ServiceRepository serviceRepository;
    private final MasterRepository masterRepository;

    // Service
    public List<ServiceDTO> getAllServices() {
        List<Service> services = serviceRepository.findAll();
        return mapToCatalogDTOList(services);
    }

    public ServiceDTO getServiceById(Long serviceId) {
        Service service = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ServiceNotFoundException("Service not found with ID: " + serviceId));
        return mapToCatalogDTO(service);
    }

    public ServiceDTO createService(ServiceDTO ServiceDTO) {
        Service service = mapToServiceEntity(ServiceDTO);
        Service savedService = serviceRepository.save(service);
        log.info("Created new service with ID: {}", savedService.getId());
        return mapToCatalogDTO(savedService);
    }

    public ServiceDTO updateService(Long serviceId, ServiceDTO ServiceDTO) {
        Service existingService = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ServiceNotFoundException("Service not found with ID: " + serviceId));
        existingService.setName(ServiceDTO.getName());
        existingService.setDescription(ServiceDTO.getDescription());
        existingService.setPrice(ServiceDTO.getPrice());
        Service updatedService = serviceRepository.save(existingService);
        log.info("Updated service with ID: {}", updatedService.getId());
        return mapToCatalogDTO(updatedService);
    }

    public void deleteService(Long serviceId) {
        Service existingService = serviceRepository.findById(serviceId)
                .orElseThrow(() -> new ServiceNotFoundException("Service not found with ID: " + serviceId));
        serviceRepository.delete(existingService);
        log.info("Deleted service with ID: {}", serviceId);
    }

    //Master
    public List<MasterDTO> getAllMasters() {
        List<Master> masters = masterRepository.findAll();
        return mapToMasterDTOList(masters);
    }

    public MasterDTO getMasterById(Long masterId) {
        Master master = masterRepository.findById(masterId)
                .orElseThrow(() -> new MasterNotFoundException("Master not found with ID: " + masterId));
        return mapToMasterDTO(master);
    }

    public MasterDTO createMaster(MasterDTO MasterDTO) {
        Master master = mapToMasterEntity(MasterDTO);
        Master savedMaster = masterRepository.save(master);
        log.info("Created new master with ID: {}", savedMaster.getId());
        return mapToMasterDTO(savedMaster);
    }

    public MasterDTO updateMaster(Long masterId, MasterDTO MasterDTO) {
        Master existingMaster = masterRepository.findById(masterId)
                .orElseThrow(() -> new MasterNotFoundException("Master not found with ID: " + masterId));
        existingMaster.setName(MasterDTO.getName());
//        existingMaster.setSpecialty(MasterDTO.getSpecialty());
        existingMaster.setRating(MasterDTO.getRating());
        Master updatedMaster = masterRepository.save(existingMaster);
        log.info("Updated master with ID: {}", updatedMaster.getId());
        return mapToMasterDTO(updatedMaster);
    }

    public void deleteMaster(Long masterId) {
        Master existingMaster = masterRepository.findById(masterId)
                .orElseThrow(() -> new MasterNotFoundException("Master not found with ID: " + masterId));
        masterRepository.delete(existingMaster);
        log.info("Deleted master with ID: {}", masterId);
    }

    // Mapping methods for Services
    private ServiceDTO mapToCatalogDTO(Service service) {
        return new ServiceDTO(service.getId(), service.getName(), service.getDescription(), service.getPrice());
    }

    private List<ServiceDTO> mapToCatalogDTOList(List<Service> services) {
        return services.stream()
                .map(this::mapToCatalogDTO)
                .collect(Collectors.toList());
    }

    private Service mapToServiceEntity(ServiceDTO serviceDto) {
        return new Service(serviceDto.getId(), serviceDto.getName(), serviceDto.getDescription(), serviceDto.getPrice());
    }

    // Mapping methods for Masters
    private MasterDTO mapToMasterDTO(Master master) {
        return new MasterDTO(master.getId(), master.getName()//, master.getSpecialty()
                , master.getRating());
    }

    private List<MasterDTO> mapToMasterDTOList(List<Master> masters) {
        return masters.stream()
                .map(this::mapToMasterDTO)
                .collect(Collectors.toList());
    }

    private Master mapToMasterEntity(MasterDTO MasterDTO) {
        return new Master(MasterDTO.getId(), MasterDTO.getName()//, MasterDTO.getSpecialty()
                 , MasterDTO.getRating());
    }
}
