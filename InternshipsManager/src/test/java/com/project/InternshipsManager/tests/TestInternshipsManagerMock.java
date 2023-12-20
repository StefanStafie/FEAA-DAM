package com.project.InternshipsManager.tests;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.InternshipsManager.controller.InternshipsController;
import com.project.InternshipsManager.dto.InternshipDTO;
import com.project.InternshipsManager.model.utils.DepartamentEnum;
import com.project.InternshipsManager.model.utils.StateEnum;
import com.project.InternshipsManager.repository.EmployeeRepository;
import com.project.InternshipsManager.repository.InternshipsRepository;
import com.project.InternshipsManager.service.InternshipService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TestInternshipsManagerMock {
	
	@Autowired
	private InternshipsController internshipsController;
	
	@Autowired
	private InternshipsRepository internshipsRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private MockMvc mockMvc;
	
	@Test
	public void testAddInternships() throws Exception {
		InternshipService internshipService = new InternshipService(internshipsRepository, employeeRepository);
		
		InternshipDTO internshipDTO = new InternshipDTO( "Junior Java Backend developer Internship",true,20, 6, 
									 					Date.valueOf("2023-11-03"),  
									 					Date.valueOf("2024-02-01"), 
									 					StateEnum.IN_PROGRESS, DepartamentEnum.BACKEND_DEVELOPMENT,
									 					"Popescu Ion");
		
		internshipsController.setInternshipService(internshipService);
		
		mockMvc = MockMvcBuilders.standaloneSetup(internshipsController).build();
		
		
		mockMvc.perform(post("/api/internships/addInternship")
					    .content(asJsonString(internshipDTO))
					    .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk());
		
	}
	
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}