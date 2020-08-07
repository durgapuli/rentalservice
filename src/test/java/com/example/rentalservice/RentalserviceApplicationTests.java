package com.example.rentalservice;

//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.rentalservice.models.Rental;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
class RentalserviceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	//... previous tests ...

	@Test
	public void getAllRentalsTest() throws Exception {
		mockMvc.perform(
			get("/rentals")
			.accept(MediaType.APPLICATION_JSON)
			)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$[*]").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$[*].id").isNotEmpty())
		.andExpect(MockMvcResultMatchers.jsonPath("$[0].cost").value("2910.0"));
	}

	@Test
	public void getRentalByIdTest() throws Exception {
		mockMvc.perform(
			get("/rentals/1")
			.accept(MediaType.APPLICATION_JSON)
			)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$[*]").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));
	}

	@Test
	public void shouldCreateNewRental() throws Exception {
		this.mockMvc.perform(
			post("/rentals")
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.content(new ObjectMapper().writeValueAsString(new Rental(789, "2020-06-25", "2020-07-14", 456, 123, 32500, 'P'))))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Created a new rental")));
	}

/* 	@Test
	public void shouldUpdateExistingRental() throws Exception {
		this.mockMvc.perform(
			put("/rentals/1")
			.contentType(MediaType.APPLICATION_JSON_VALUE)
			.content(new ObjectMapper().writeValueAsString(new Rental(22, "2020-06-25", "2020-07-14", 456, 123, 32500, 'A'))))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Updated")));
	} */

	// @Test
	// public void shouldDeleteRental() throws Exception {
	// 	this.mockMvc.perform(
	// 		delete("/rentals/1")
	// 	)
	// 	.andDo(print())
	// 	.andExpect(status().isOk())
	// 	.andExpect(content().string(containsString("Deleted")));
	// }
}