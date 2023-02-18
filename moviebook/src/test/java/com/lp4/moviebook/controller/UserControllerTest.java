package com.lp4.moviebook.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import com.lp4.moviebook.dto.ResponseMovieDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.lp4.moviebook.model.Movie;
import com.lp4.moviebook.model.User;
import com.lp4.moviebook.service.UserService;

import io.restassured.module.mockmvc.response.MockMvcResponse;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	
	@InjectMocks
	private UserController userController;
	
	@Mock
	private UserService userService;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.userController);
	}
	
	@Test
	public void shouldReturnSuccessWhenPostingAUser() {
		List<ResponseMovieDTO> watchList = List.of();
		List<ResponseMovieDTO> watchedList = List.of();
		User user = new User("1", "Luiz", "18", watchedList, watchList);
		when(this.userService.createUser(user)).thenReturn(user);
		
		MockMvcResponse response = given()
			.contentType("application/json")
			.body(user)
		.when()
			.post("api/v1/users/user");
		
		assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
		assertEquals("1", response.path("id"));
		assertEquals("Luiz", response.path("name"));
		assertEquals("18", response.path("age"));
	}
}