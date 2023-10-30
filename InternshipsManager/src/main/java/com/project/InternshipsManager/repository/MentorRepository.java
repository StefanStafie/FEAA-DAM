package com.project.InternshipsManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.project.InternshipsManager.model.Mentor;


@EnableJpaRepositories
@Repository
public interface MentorRepository extends JpaRepository<Mentor,Integer>{
	Mentor findByName(String name);
}
