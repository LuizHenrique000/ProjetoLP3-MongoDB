package com.lp4.moviebook.controller;

import java.util.List;

import com.lp4.moviebook.dto.RequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lp4.moviebook.model.User;
import com.lp4.moviebook.service.LogService;
import com.lp4.moviebook.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

	private UserService service;
	
	private LogService logService;

	public UserController(UserService service, LogService logService) {
		this.service = service;
		this.logService = logService;
	}

	@GetMapping("/{id}")
	private ResponseEntity<User> findById(@PathVariable("id") String id) {
		User response = service.findUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping
	private ResponseEntity<List<User>> findAll(){
		List<User> response = service.findAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping("/user")
	private ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User response = service.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PostMapping("/user/movie")
	private ResponseEntity<User> adicionarFilmeNaListaDeAssistidos(@Valid @RequestBody RequestDTO requestDTO) {
		User response = service.addMovieToWatchedList(requestDTO);
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
	@PostMapping("/user/movie/watch-list")
	private ResponseEntity<User> adicionarFilmeNaWatchList(@Valid @RequestBody RequestDTO requestDTO) {
		User response = service.addMovieToWatchList(requestDTO);
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
	@DeleteMapping("/{idUser}/movies/{idMovie}/watch-list")
	private ResponseEntity<Void> deletarFilmePorIdDaWatchList(@PathVariable("idUser") String idUser, @PathVariable("idMovie") String idMovie) {
		service.removeMovieFromWatchList(idUser, idMovie);
		logService.generateDeleteLogOfUser(idUser, idMovie);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		
	}
}