package com.project.InternshipsManager.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.InternshipsManager.controller.InternshipsController;
import com.project.InternshipsManager.dto.InternshipDTO;
import com.project.InternshipsManager.service.InternshipService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class InternshipsManagerTests {
	
	@InjectMocks
	private InternshipsController internshipsController;
	
	private MockMvc mockMvc;
	
	@Mock
	private InternshipService internshipService;
	
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(internshipsController).build();
	}
	
	@Test
	public void testAddInternships() throws Exception {
		InternshipDTO internshipDTO = new InternshipDTO("java developer", true, 6, "Paula Pascu", 
									 "AGILEBK1", "2023-11-03", "2024-02-01", "",
									 "Gheorghe Maria,Popescu Andrei");
		
		mockMvc.perform(post("http://localhost:8081/api/internships_manager/addInternship")
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
