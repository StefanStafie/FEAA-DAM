package com.project.InternshipsManager.model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name="reviews")
public class Review {
	@SequenceGenerator(name= "review_sequence_generator", 
			   sequenceName="review_id_sequence", 
			   allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
	         generator="review_sequence_generator")
	@Column(name="id")
	private Integer id;
	
	@CreationTimestamp
	@Column(name = "data_creare")
	private Date createDate;
	
	@Column(name = "observatii_pozitive")
	private String positiveMessage;
	
	@Column(name = "observatii_negative")
	private String negativeMessage;
	
	@Column(name = "calificativ")
	private Integer mark;
	
	@Column(name = "comentariu")
	private String comment;
	
	@Column(name = "criteriu_evaluare")
	private String criteria;
	
	@ManyToOne
	@JoinColumn(name = "id_stagiar")
	private InternEmployee internEmployee;
	
	public Review() { }

	public Review(Date createDate, String positiveMessage, String negativeMessage, Integer mark, String comment,
			String criteria, InternEmployee internEmployee) {
		super();
		this.createDate = createDate;
		this.positiveMessage = positiveMessage;
		this.negativeMessage = negativeMessage;
		this.mark = mark;
		this.comment = comment;
		this.criteria = criteria;
		this.internEmployee = internEmployee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getPositiveMessage() {
		return positiveMessage;
	}

	public void setPositiveMessage(String positiveMessage) {
		this.positiveMessage = positiveMessage;
	}

	public String getNegativeMessage() {
		return negativeMessage;
	}

	public void setNegativeMessage(String negativeMessage) {
		this.negativeMessage = negativeMessage;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCriteria() {
		return criteria;
	}

	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}

	public InternEmployee getInternEmployee() {
		return internEmployee;
	}

	public void setInternEmployee(InternEmployee internEmployee) {
		this.internEmployee = internEmployee;
	}

	@Override
	public String toString() {
		String internEmployeeString = GeneralUtils.validateNullObject(internEmployee);
		return "Review [id=" + id + ", createDate=" + createDate + ", positiveMessage=" + positiveMessage
				+ ", negativeMessage=" + negativeMessage + ", mark=" + mark + ", comment=" + comment + ", criteria="
				+ criteria + ", internEmployee=" + internEmployeeString + "]";
	}
	

}
