package com.lp4.moviebook.service;

import java.util.List;
import java.util.Optional;

import com.lp4.moviebook.dto.ResponseMovieDTO;
import com.lp4.moviebook.exception.NotFoundException;
import org.springframework.stereotype.Service;

import com.lp4.moviebook.model.Movie;
import com.lp4.moviebook.repository.MovieRepository;

@Service
public class MovieService {
	
	private MovieRepository repository;
	private IntegrationService integrationService;
	
	public MovieService(MovieRepository repository, IntegrationService integrationService) {
		this.repository = repository;
		this.integrationService = integrationService;
	}
	
	public List<Movie> findAll() {
		return repository.findAll();
	}

	public ResponseMovieDTO findById(String id) {
		Optional<Movie> movie = repository.findById(id);
		if (movie.isPresent()) {
			return integrationService.findById(Integer.parseInt(movie.get().getNumberReference()));
		}
		return integrationService.findById(Integer.parseInt(id));
	}

}
