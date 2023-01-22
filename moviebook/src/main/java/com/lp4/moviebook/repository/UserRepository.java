package com.lp4.moviebook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lp4.moviebook.model.User;

public interface UserRepository extends MongoRepository<User, String>  {

}
