package com.lp4.moviebook.component;

import com.lp4.moviebook.model.Movie;
import com.lp4.moviebook.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        Movie inception = Movie.builder()
                .id("1")
                .numberReference("27205")
                .title("Inception")
                .build();

        Movie interstellar = Movie.builder()
                .id("2")
                .numberReference("157336")
                .title("Interstellar")
                .build();

        Movie pulpFiction = Movie.builder()
                .id("3")
                .numberReference("680")
                .title("Pulp Fiction")
                .build();

        Movie seven = Movie.builder()
                .id("4")
                .numberReference("807")
                .title("Seven")
                .build();

        Movie backToTheFuture = Movie.builder()
                .id("5")
                .numberReference("105")
                .title("Back to the Future")
                .build();

        movieRepository.save(inception);
        movieRepository.save(interstellar);
        movieRepository.save(pulpFiction);
        movieRepository.save(seven);
        movieRepository.save(backToTheFuture);
    }
}

