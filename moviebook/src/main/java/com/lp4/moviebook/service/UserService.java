package com.lp4.moviebook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lp4.moviebook.model.Movie;
import com.lp4.moviebook.model.User;
import com.lp4.moviebook.repository.MovieRepository;
import com.lp4.moviebook.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	private MovieRepository movieRepository;

	public UserService(UserRepository userRepository, MovieRepository movieRepository) {
		this.userRepository = userRepository;
		this.movieRepository = movieRepository;
	}
	
	public User findUserById(String idUser) {
		return userRepository.findById(idUser).get();
	}
	
	public User createUser(User user) {
		User entity = userRepository.save(user);
		return entity;
	}
	
	public User addMovieInWatchedList(String idUser, String idMovie) {
		User userEntity = findUserById(idUser);
		Movie movieEntity = findMovieById(idMovie);
		List watchedMovies = new ArrayList<Movie>();
		watchedMovies.add(movieEntity);
		userEntity.setWatchedMovies(watchedMovies);
		return userRepository.save(userEntity);
	}
	
	private Movie findMovieById(String idMovie) {
		return movieRepository.findById(idMovie).get();
	}
}
