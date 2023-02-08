package com.lp4.moviebook.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.lp4.moviebook.model.Movie;
import com.lp4.moviebook.repository.MovieRepository;

@Service
public class MovieService {
	
	private MovieRepository repository;
	
	public MovieService(MovieRepository repository) {
		this.repository = repository;
	}
	
	public List<Movie> findAll() {
		return repository.findAll();
	}
	
	public Movie findById(String id) {
		return repository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie doenst exist"));
	}

}
