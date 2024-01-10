package com.project.InternshipsManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.project.InternshipsManager.model.InternEmployee;


@EnableJpaRepositories
@Repository
public interface InternEmployeeRepository extends JpaRepository<InternEmployee,Integer>{

	List<InternEmployee> findByInternship_Id(Integer internshipId);
	
}
