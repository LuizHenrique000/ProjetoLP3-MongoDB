package com.lp4.moviebook.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.lp4.moviebook.model.Movie;
import com.lp4.moviebook.repository.MovieRepository;

@Service
public class IntegrationService {

	private RestTemplate restTemplate;
	private MovieRepository movieRepository;

	@Value("${tmdb-external-api}")
	private String uri;
	
	@Value("${tmdb-api-key}")
	private String apiKey;

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