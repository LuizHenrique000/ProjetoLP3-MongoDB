package com.lp4.moviebook.service;

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
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User createUser(User user) {
		User entity = userRepository.save(user);
		return entity;
	}
	
	public User addMovieInWatchedList(String idUser, String idMovie) {
		User userEntity = findUserById(idUser);
		Movie movieEntity = findMovieById(idMovie);
		List userWatchedMovies = userEntity.getWatchedMovies();
		userWatchedMovies.add(movieEntity);
		userEntity.setWatchedMovies(userWatchedMovies);
		return userRepository.save(userEntity);
	}
	
	public User addMovieInWatchList(String idUser, String idMovie) {
		User userEntity = findUserById(idUser);
		Movie movieEntity = findMovieById(idMovie);
		List watchListMovies = userEntity.getWatchedMovies();
		watchListMovies.add(movieEntity);
		userEntity.setWatchedMovies(watchListMovies);
		return userRepository.save(userEntity);
	}
	
	public void deleteById(String id) {
		userRepository.deleteById(id);
	}
	
	private Movie findMovieById(String idMovie) {
		return movieRepository.findById(idMovie).get();
	}
}
