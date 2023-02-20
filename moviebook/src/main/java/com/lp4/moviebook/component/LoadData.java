package com.lp4.moviebook.component;

import com.lp4.moviebook.model.Movie;
import com.lp4.moviebook.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class LoadData implements CommandLineRunner {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {
        createMoviesAndSave();
    }

    private void createMoviesAndSave() {
        System.out.println("Creating movies and saving in database!");
        movieRepository.deleteAll();
        List<Movie> movies = Arrays.asList(
                Movie.builder().id("1").numberReference("27205").title("Inception").build(),
                Movie.builder().id("2").numberReference("157336").title("Interstellar").build(),
                Movie.builder().id("3").numberReference("680").title("Pulp Fiction").build(),
                Movie.builder().id("4").numberReference("807").title("Seven").build(),
                Movie.builder().id("5").numberReference("105").title("Back to the Future").build()
        );
        movieRepository.saveAll(movies);
    }

}

