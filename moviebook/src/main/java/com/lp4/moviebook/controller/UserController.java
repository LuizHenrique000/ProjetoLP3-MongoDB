package com.lp4.moviebook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lp4.moviebook.model.User;
import com.lp4.moviebook.service.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

	private UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	private ResponseEntity<User> findById(@PathVariable("id") String id) {
		User response = service.findUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping
	private ResponseEntity<User> createUser(@RequestBody User user) {
		User response = service.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PutMapping("/{idUser}/{idMovie}")
	private ResponseEntity<User> adicionarFilme(@PathVariable("idUser") String idUser, @PathVariable("idMovie") String idMovie) {
		User response = service.addMovieInWatchedList(idUser, idMovie);
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
}
