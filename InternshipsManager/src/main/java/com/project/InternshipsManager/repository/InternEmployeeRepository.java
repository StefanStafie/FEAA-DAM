package com.project.InternshipsManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.project.InternshipsManager.model.InternEmployee;


@EnableJpaRepositories
@Repository
public interface InternEmployeeRepository extends JpaRepository<InternEmployee,Integer>{
	InternEmployee findByName(String name);
}
