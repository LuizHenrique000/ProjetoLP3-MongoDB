package com.lp4.moviebook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.lp4.moviebook.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>  {

}
