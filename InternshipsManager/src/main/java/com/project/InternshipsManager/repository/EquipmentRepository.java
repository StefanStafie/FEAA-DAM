package com.project.InternshipsManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.project.InternshipsManager.model.Equipment;

@EnableJpaRepositories
@Repository
public interface EquipmentRepository extends JpaRepository<Equipment,Integer>{

}
