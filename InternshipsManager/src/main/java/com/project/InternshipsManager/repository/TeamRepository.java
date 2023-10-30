package com.project.InternshipsManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.project.InternshipsManager.model.Team;

@EnableJpaRepositories
@Repository
public interface TeamRepository extends JpaRepository<Team,Integer>{
	Team findByTeamName(String teamName);
}
