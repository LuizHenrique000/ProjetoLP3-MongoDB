package com.lp4.moviebook.controller;

import java.util.List;
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
	
	@GetMapping
	private ResponseEntity<List<User>> findAll(){
		List<User> response = service.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping
	private ResponseEntity<User> createUser(@RequestBody User user) {
		User response = service.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@PostMapping("/{idUser}/{idMovie}")
	private ResponseEntity<User> adicionarFilmeNaListaDeAssistidos(@PathVariable("idUser") String idUser, @PathVariable("idMovie") String idMovie) {
		User response = service.addMovieInWatchedList(idUser, idMovie);
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
//	@PutMapping("/{idUser}/{idMovie}")
//	private ResponseEntity<User> adicionarFilmeNaWatchList(@PathVariable("idUser") String idUser, @PathVariable("idMovie") String idMovie) {
//		User response = service.addMovieInWatchList(idUser, idMovie);
//		return ResponseEntity.status(HttpStatus.OK).body(response);
//		
//	}
	
	@DeleteMapping
	private ResponseEntity<Void> deletarFilmePorIdDaWatchList(String id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
