package com.lp4.moviebook;

import com.lp4.moviebook.model.Movie;
import com.lp4.moviebook.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MoviebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviebookApplication.class, args);
	}

}