package com.project.InternshipsManager.model;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import com.project.InternshipsManager.model.utils.StateEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="activitati")
public class Task {
	@SequenceGenerator(name= "task_sequence_generator", 
			   sequenceName="task_id_sequence", 
			   allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	         generator="task_sequence_generator")
	@Column(name="id")
	private Integer id;	
	
	@Column(name = "nume")
	private String name;
	
	@Column(name = "descriere")
	private String description;
	
	@CreationTimestamp
	@Column(name = "data_creare")
	private LocalDateTime createDate;
	
	@Column(name = "termen_finalizare")
	private LocalDateTime finisDate;
	
	@Column(name = "id_internship")
	private Integer intershipId;
	
	@Column(name = "ore_estimate")
	private Integer estimatedHours;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "stare")
	private StateEnum state;
	
	@Column(name = "observatii")
	private String remarks;
	
	public Task() { }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getFinisDate() {
		return finisDate;
	}

	public void setFinisDate(LocalDateTime finisDate) {
		this.finisDate = finisDate;
	}

	public Integer getIntershipId() {
		return intershipId;
	}

	public void setIntershipId(Integer intershipId) {
		this.intershipId = intershipId;
	}

	public Integer getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(Integer estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public StateEnum getState() {
		return state;
	}

	public void setState(StateEnum state) {
		this.state = state;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
