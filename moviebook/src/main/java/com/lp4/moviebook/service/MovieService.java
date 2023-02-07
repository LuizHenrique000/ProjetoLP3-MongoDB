package com.lp4.moviebook.service;

import java.util.List;
import org.springframework.stereotype.Service;
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

}
