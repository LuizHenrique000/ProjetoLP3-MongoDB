package com.lp4.moviebook.service;

import com.lp4.moviebook.component.RestTemplateResponseErrorHandler;
import com.lp4.moviebook.dto.ResponseMovieDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.lp4.moviebook.model.Movie;
import com.lp4.moviebook.repository.MovieRepository;

@ConfigurationProperties(prefix = "tmdb-external-api")
@Service
public class IntegrationService {

	private RestTemplate restTemplate;

	@Value("${tmdb-external-api}")
	private String uri;
	
	@Value("${tmdb-api-key}")
	private String apiKey;

	public IntegrationService(RestTemplateBuilder restTemplateBuilder, MovieRepository movieRepository) {
		this.restTemplate = restTemplateBuilder
				.errorHandler(new RestTemplateResponseErrorHandler())
				.build();
	}

	public ResponseMovieDTO findById(int id) {
		String url = generateURLIntegration(id);
		return this.restTemplate.getForObject(url, ResponseMovieDTO.class);
	}

	private String generateURLIntegration(int id) {
		return this.uri + "/movie/" + id + "?api_key=" + this.apiKey;
	}

}