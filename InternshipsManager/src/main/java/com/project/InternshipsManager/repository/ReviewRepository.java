package com.project.InternshipsManager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.project.InternshipsManager.model.InternEmployee;
import com.project.InternshipsManager.model.Review;

@EnableJpaRepositories
@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer>{
	Optional<List<Review>> findByInternEmployee(InternEmployee internEmployee);
}
