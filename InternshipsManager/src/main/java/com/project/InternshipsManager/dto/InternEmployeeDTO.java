package com.project.InternshipsManager.dto;

import com.project.InternshipsManager.model.utils.DepartamentEnum;

public class InternEmployeeDTO {
	private String lastName;
	private String firstName;
	private String contact;
	private DepartamentEnum departament;
	private String specialization;
	private String internshipName;
	private String teamName;
	
	public InternEmployeeDTO() {}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public DepartamentEnum getDepartament() {
		return departament;
	}

	public void setDepartament(DepartamentEnum departament) {
		this.departament = departament;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getInternshipName() {
		return internshipName;
	}

	public void setInternshipName(String internshipName) {
		this.internshipName = internshipName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	

}
