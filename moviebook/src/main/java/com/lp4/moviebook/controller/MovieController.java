package com.lp4.moviebook.controller;

import java.util.List;

import com.lp4.moviebook.dto.ResponseMovieDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lp4.moviebook.model.Movie;
import com.lp4.moviebook.service.IntegrationService;
import com.lp4.moviebook.service.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "*")
public class MovieController {

    private MovieService movieService;
    
    public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping("/{id}")
    public ResponseEntity<ResponseMovieDTO> findById(@PathVariable("id") String id) {
        ResponseMovieDTO response = movieService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
    	List<Movie> response = movieService.findAll();
    	return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}