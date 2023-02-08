package com.lp4.moviebook.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
		return userRepository.findById(idUser).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Non-existent user, ID: " + idUser));
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User createUser(User user) {
		User entity = userRepository.save(user);
		return entity;
	}

	public User addMovieInWatchedList(String idUser, String idMovie) {
		User userEntity = findUserById(idUser);
		Movie movieEntity = findMovieById(idMovie);
		List<Movie> userWatchedMovies = userEntity.getWatchedMovies();
		userWatchedMovies.add(movieEntity);
		userEntity.setWatchedMovies(userWatchedMovies);
		return userRepository.save(userEntity);
	}

	public User addMovieInWatchList(String idUser, String idMovie) {
		User userEntity = findUserById(idUser);
		Movie movieEntity = findMovieById(idMovie);
		List<Movie> watchListMovies = userEntity.getWatchList();
		watchListMovies.add(movieEntity);
		userEntity.setWatchList(watchListMovies);
		return userRepository.save(userEntity);
	}

	public void deleteMovieInWatchListUserById(String idUser, String idMovie) {
		User userEntity = findUserById(idUser);
		List<Movie> userWatchListMovies = userEntity.getWatchList();
		userWatchListIsEmpty(userWatchListMovies);
		Movie movieEntity = findMovieById(idMovie);
		validateIfMovieExistInUserWatchList(movieEntity, userEntity);
		userWatchListMovies.remove(movieEntity);
		userEntity.setWatchList(userWatchListMovies);
		userRepository.save(userEntity);
	}

	private Movie findMovieById(String idMovie) {
		return movieRepository.findById(idMovie).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"Non-existent movie, ID: " + idMovie));
	}

	private boolean userWatchListIsEmpty(List<Movie> watchList) {
		if (watchList.isEmpty() == true) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Watch list of user is empty");
		} else {
			return false;
		}
	}
	
	private boolean validateIfMovieExistInUserWatchList(Movie movie, User user) {
		List<Movie> userWatchListMovies = user.getWatchList();
		if (userWatchListMovies.contains(movie) == true) {
			return true;
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Watch list doenst have this movie");
		}
	}
}














