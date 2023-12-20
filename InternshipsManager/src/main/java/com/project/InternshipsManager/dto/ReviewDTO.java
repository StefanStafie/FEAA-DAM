package com.project.InternshipsManager.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.InternshipsManager.model.InternEmployee;



public class ReviewDTO {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
	private Date createDate;
	private String positiveMessage;
	private String negativeMessage;
	private Integer mark;
	private String comment;
	private String criteria;
	private InternEmployee internEmployee;
	
	public ReviewDTO() { }

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
}
