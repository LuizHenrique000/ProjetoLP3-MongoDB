package com.lp4.moviebook.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
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
		List<User> response = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping()
	private ResponseEntity<User> createUser(@RequestBody User user) {
		User response = service.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PostMapping("/{idUser}/movie/{idMovie}")
	private ResponseEntity<User> adicionarFilmeNaListaDeAssistidos(@PathVariable("idUser") String idUser, @PathVariable("idMovie") String idMovie) {
		User response = service.addMovieInWatchedList(idUser, idMovie);
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
	@PostMapping("/user/{idUser}/movie/{idMovie}")
	private ResponseEntity<User> adicionarFilmeNaWatchList(@PathVariable("idUser") String idUser, @PathVariable("idMovie") String idMovie) {
		User response = service.addMovieInWatchList(idUser, idMovie);
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
	@DeleteMapping("/{idUser}/movies/{idMovie}/watch-list")
	private BodyBuilder deletarFilmePorIdDaWatchList(String idMovie, String idUser){
		service.deleteMovieInWatchListUserById(idMovie, idUser);
		logService.generateDeleteLogOfUser(idUser);
		return ResponseEntity.status(HttpStatus.ACCEPTED);
		
	}
}