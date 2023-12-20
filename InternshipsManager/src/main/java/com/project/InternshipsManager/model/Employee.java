package com.project.InternshipsManager.model;

import com.project.InternshipsManager.model.utils.DepartamentEnum;
import com.project.InternshipsManager.model.utils.GeneralUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="angajati")
public class Employee {
	@SequenceGenerator(name= "employee_sequence_generator", 
			   sequenceName="employee_id_sequence", 
			   allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	         generator="employee_sequence_generator")
	@Column(name= "id")
	private Integer id;
	
	@Column(name = "nume")
	private String lastName;
	
	@Column(name = "prenume")
	private String firstName;
	
	@Column(name = "aptitudini")
	private String skills;
	
	@Column(name = "functie")
	private String position;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "departament")
	private DepartamentEnum departament;
	
	@Column(name = "contact")
	private String contact;
	
	@ManyToOne
	@JoinColumn(name = "id_echipa")
	private Team team;
	
	public Employee() {}

	public Employee(String lastName, String firstName, String skills, String position, DepartamentEnum departament,
			String contact) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.skills = skills;
		this.position = position;
		this.departament = departament;
		this.contact = contact;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public DepartamentEnum getDepartament() {
		return departament;
	}

	public void setDepartament(DepartamentEnum departament) {
		this.departament = departament;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		String teamString = GeneralUtils.validateNullObject(team);
		return "Employee [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", skills=" + skills
				+ ", position=" + position + ", departament=" + departament + ", contact=" + contact + ", team=" + teamString
				+ "]";
	}
	
	
}
