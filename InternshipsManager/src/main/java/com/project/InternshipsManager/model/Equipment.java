package com.project.InternshipsManager.model;

import com.project.InternshipsManager.model.utils.GeneralUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="asignare_echipamente_stagiari")
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

	
	@Column(name = "tip")
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "id_stagiar")
	private InternEmployee internEmployee;
	
	
	public Equipment() { }

	public Equipment(String name, Integer serialNumber, String type, InternEmployee internEmployee) {
		super();
		this.name = name;
		this.serialNumber = serialNumber;
		this.type = type;
		this.internEmployee = internEmployee;
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		String internEmployeeString = GeneralUtils.validateNullObject(internEmployee);
		return "Equipment [id=" + id + ", name=" + name + ", serialNumber=" + serialNumber + ", type=" + type
				+ ", internEmployee=" + internEmployeeString + "]";
	}
	
}
