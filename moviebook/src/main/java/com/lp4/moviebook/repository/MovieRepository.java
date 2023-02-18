package com.lp4.moviebook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.lp4.moviebook.model.Movie;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

}
