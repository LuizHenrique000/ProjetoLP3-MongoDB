package com.lp4.moviebook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lp4.moviebook.exception.NotFoundException;
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

	public User findUserById(String id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new NotFoundException("User not found with id: " + id);
		}
		return user.get();
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User addMovieToWatchedList(String userId, String movieId) {
		User user = findUserById(userId);
		Movie movie = findMovieById(movieId);
		user.getWatchedMovies().add(movie);
		return userRepository.save(user);
	}

	public User addMovieToWatchList(String userId, String movieId) {
		User user = findUserById(userId);
		Movie movie = findMovieById(movieId);
		user.getWatchList().add(movie);
		return userRepository.save(user);
	}

	public User removeMovieFromWatchList(String userId, String movieId) {
		User user = findUserById(userId);
		Movie movie = findMovieById(movieId);
		if (!user.getWatchList().contains(movie)) {
			throw new NotFoundException("Movie not found in user's watch list");
		}
		user.getWatchList().remove(movie);
		return userRepository.save(user);
	}

	private Movie findMovieById(String id) {
		Optional<Movie> movie = movieRepository.findById(id);
		if (!movie.isPresent()) {
			throw new NotFoundException("Movie not found with id: " + id);
		}
		return movie.get();
	}
}