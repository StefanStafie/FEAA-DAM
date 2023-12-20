package com.project.InternshipsManager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.project.InternshipsManager.model.Employee;

@EnableJpaRepositories
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	Optional<Employee> findByFirstName(String name);
	Optional<Employee> findByLastName(String name);
}
