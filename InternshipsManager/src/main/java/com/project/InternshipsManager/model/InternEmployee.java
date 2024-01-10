package com.project.InternshipsManager.model;

import java.util.List;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="stagiari")
public class InternEmployee {
	@SequenceGenerator(name= "intern_sequence_generator", 
			   sequenceName="intern_id_sequence", 
			   allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	         generator="intern_sequence_generator")
	@Column(name= "id")
	private Integer id;	
	
	@Column(name = "nume")
	private String lastName;
	
	@Column(name = "prenume")
	private String firstName;
	
	@Column(name= "contact")
	private String contact;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "departament")
	private DepartamentEnum departament;
	
	@Column(name = "specializare")
	private String specialization;
	
	@ManyToOne
	@JoinColumn(name = "id_internship")
	private Internship internship;
	
	@OneToMany(mappedBy = "internEmployee")
	private List<Equipment> equipments;
	
	@OneToMany(mappedBy = "internEmployee")
	private List<Review> reviews;
	
	@ManyToOne
	@JoinColumn(name = "id_echipa")
	private Team team;
	
	public InternEmployee() { }

	public InternEmployee(String lastName, String firstName, String contact, DepartamentEnum departament,
			String specialization, Internship internship, Team team) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.contact = contact;
		this.departament = departament;
		this.specialization = specialization;
		this.internship = internship;
		this.team = team;
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

	public Internship getInternship() {
		return internship;
	}

	public void setInternship(Internship internship) {
		this.internship = internship;
	}

	public List<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public String toString() {
		String internshipAsString = GeneralUtils.validateNullObject(internship);
		String equipmentsAsString = GeneralUtils.validateEmptyListOfObject(equipments);
		String reviewsAsString = GeneralUtils.validateEmptyListOfObject(reviews);
		String teamAsString = GeneralUtils.validateNullObject(team);
		return "InternEmployee [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", contact="
				+ contact + ", departament=" + departament + ", specialization=" + specialization + ", internship="
				+ internshipAsString + ", equipments=" + equipmentsAsString + ", reviews=" + reviewsAsString + ", team=" + teamAsString + "]";
	}
	
	public String partialtoString() {
		return "InternEmployee [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", contact="
				+ contact + ", departament=" + departament + ", specialization=" + specialization  + "]";
	}
	
	
}
