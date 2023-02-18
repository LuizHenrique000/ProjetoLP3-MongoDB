package com.lp4.moviebook.service;

import java.util.List;
import java.util.Optional;

import com.lp4.moviebook.dto.RequestDTO;
import com.lp4.moviebook.dto.ResponseMovieDTO;
import com.lp4.moviebook.exception.AlreadyExistsException;
import org.springframework.stereotype.Service;

import com.lp4.moviebook.exception.NotFoundException;
import com.lp4.moviebook.model.Movie;
import com.lp4.moviebook.model.User;
import com.lp4.moviebook.repository.MovieRepository;
import com.lp4.moviebook.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	private MovieService movieService;

	public UserService(UserRepository userRepository, MovieService movieService) {
		this.userRepository = userRepository;
		this.movieService = movieService;
	}

	public User findUserById(String id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new NotFoundException("User not found with id: " + id);
		}
		return user.get();
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public User createUser(User user) {
		if (userRepository.existsById(user.getId())) {
			throw new AlreadyExistsException("User already exists with id: " + user.getId());
		}
		return userRepository.save(user);
	}

	public User addMovieToWatchedList(RequestDTO requestDTO) {
		User user = findUserById(requestDTO.idUser());
		List<ResponseMovieDTO> watchedMovies = addMovieToList(requestDTO, findUserById(requestDTO.idUser()).getWatchedMovies());
		user.setWatchedMovies(watchedMovies);
		return userRepository.save(user);
	}

	public User addMovieToWatchList(RequestDTO requestDTO) {
		User user = findUserById(requestDTO.idUser());
		List<ResponseMovieDTO> watchList = addMovieToList(requestDTO, findUserById(requestDTO.idUser()).getWatchList());
		user.setWatchList(watchList);
		return userRepository.save(user);
	}

	public void removeMovieFromWatchList(String userId, String movieId) {
		User user = findUserById(userId);
		ResponseMovieDTO movie = movieService.findById(movieId);
		if (!user.getWatchList().contains(movie)) {
			throw new NotFoundException("Movie not found in user's watch list");
		}
		user.getWatchList().remove(movie);
		userRepository.save(user);
	}

	private List<ResponseMovieDTO> addMovieToList(RequestDTO requestDTO, List<ResponseMovieDTO> movieList) {
		ResponseMovieDTO movie = movieService.findById(requestDTO.idMovie());
		if (!movieList.contains(movie)) {
			movieList.add(movie);
		} else {
			throw new AlreadyExistsException("Movie already exists in user's list");
		}
		return movieList;
	}
}