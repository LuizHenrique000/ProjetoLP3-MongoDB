package com.lp4.moviebook.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.lp4.moviebook.model.Movie;
import com.lp4.moviebook.repository.MovieRepository;

@Service
public class IntegrationService {

	private RestTemplate restTemplate;
	private MovieRepository movieRepository;

	private String uri = "https://api.themoviedb.org/3";
	
	private String apiKey = "96f9d761da098b39ca71e3484f860ff2";

	public IntegrationService(RestTemplateBuilder restTemplateBuilder, MovieRepository movieRepository) {
		this.restTemplate = restTemplateBuilder.build();
		this.movieRepository = movieRepository;
	}

	public Movie findById(int id) {
		String url = generateURLIntegration(id);
		Movie movie = this.restTemplate.getForObject(url, Movie.class);
		Movie moviePersistido = movieRepository.save(movie);
		return moviePersistido;
	}

	private String generateURLIntegration(int id) {
		return this.uri + "/movie/" + id + "?api_key=" + this.apiKey;
	}

}