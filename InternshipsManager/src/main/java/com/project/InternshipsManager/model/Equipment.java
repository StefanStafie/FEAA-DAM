package com.project.InternshipsManager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="echipamente")
public class Equipment {
	@SequenceGenerator(name= "intern_sequence_generator", 
			   sequenceName="intern_id_sequence", 
			   allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	         generator="intern_sequence_generator")
	@Column(name= "id")
	private Integer id;
	
	@Column(name = "nume")
	private String name;
	
	@Column(name = "numar_serie")
	private Integer serialNumber;
	
	@Column(name = "id_angajat")
	private Integer employeeId;
	
	@Column(name = "tip")
	private String type;
	
	public Equipment() { }

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

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
