package com.project.InternshipsManager.dto;

import com.project.InternshipsManager.model.InternEmployee;

public class EquipmentDTO {
	

	private String name;
	private Integer serialNumber;
	private String type;
	private InternEmployee internEmployee;
	
	public EquipmentDTO() { }
	
	public EquipmentDTO(String name, Integer serialNumber, String type, InternEmployee internEmployee) {
		super();
		this.name = name;
		this.serialNumber = serialNumber;
		this.type = type;
		this.internEmployee = internEmployee;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public InternEmployee getInternEmployee() {
		return internEmployee;
	}

	public void setInternEmployee(InternEmployee internEmployee) {
		this.internEmployee = internEmployee;
	}
}
