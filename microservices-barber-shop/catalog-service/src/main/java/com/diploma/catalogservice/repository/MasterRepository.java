package com.diploma.catalogservice.repository;

import com.diploma.catalogservice.model.Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterRepository extends JpaRepository<Master, Long> {
}
