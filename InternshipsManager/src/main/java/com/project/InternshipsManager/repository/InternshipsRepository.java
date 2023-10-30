package com.project.InternshipsManager.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.project.InternshipsManager.model.Internship;

@EnableJpaRepositories
@Repository
public interface InternshipsRepository extends JpaRepository<Internship,Integer>{
	Optional<Internship> findById(Integer id);

}
