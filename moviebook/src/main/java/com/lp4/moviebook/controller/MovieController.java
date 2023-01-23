package com.lp4.moviebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lp4.moviebook.model.Movie;
import com.lp4.moviebook.service.IntegrationService;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "*")
public class MovieController {

	@Autowired
    private IntegrationService integrationService;

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable("id") int id) {
        Movie response = integrationService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
    @GetMapping
    public ResponseEntity<List<Movie>> findAll() {
    	List<Movie> response = integrationService.findAll();
    	return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}