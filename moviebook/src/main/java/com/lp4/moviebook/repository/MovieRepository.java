package com.lp4.moviebook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.lp4.moviebook.model.Movie;

public interface MovieRepository extends MongoRepository<Movie, String> {

}
