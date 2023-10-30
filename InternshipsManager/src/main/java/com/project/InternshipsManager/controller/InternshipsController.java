package com.project.InternshipsManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.InternshipsManager.dto.InternshipDTO;
import com.project.InternshipsManager.model.Internship;
import com.project.InternshipsManager.service.InternshipService;

@RestController
@RequestMapping("/api/internships_manager")
public class InternshipsController {

	private final InternshipService internshipService;
	
	@Autowired
	public InternshipsController(InternshipService internshipService) {
		this.internshipService = internshipService;
	}
	
	@PostMapping("/addInternship")
	public Internship addInternship(@RequestBody InternshipDTO internshipDTO) {
		return this.internshipService.addInternship(internshipDTO);
	}
}
