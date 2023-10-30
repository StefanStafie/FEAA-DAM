package com.project.InternshipsManager.model;

import com.project.InternshipsManager.model.utils.DepartamentEnum;

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
@Table(name="mentori")
public class Mentor {
	@SequenceGenerator(name= "mentor_sequence_generator", 
			   sequenceName="mentor_id_sequence", 
			   allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	         generator="mentor_sequence_generator")
	@Column(name= "id")
	private Integer mentorId;	
	
	@Column(name = "nume")
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "departament")
	private DepartamentEnum departament;
	
	public Mentor() { }

	public Integer getMentorId() {
		return mentorId;
	}

	public void setMentorId(Integer mentorId) {
		this.mentorId = mentorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DepartamentEnum getDepartament() {
		return departament;
	}

	public void setDepartament(DepartamentEnum departament) {
		this.departament = departament;
	}
	
}
