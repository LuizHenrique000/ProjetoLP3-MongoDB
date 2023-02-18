package com.lp4.moviebook.service;

import java.time.LocalDateTime;

import com.lp4.moviebook.dto.ResponseMovieDTO;
import org.springframework.stereotype.Service;
import com.lp4.moviebook.enums.Operation;
import com.lp4.moviebook.model.Log;
import com.lp4.moviebook.model.Movie;
import com.lp4.moviebook.model.User;
import com.lp4.moviebook.repository.LogRepository;

@Service
public class LogService {
	
	private LogRepository logRepository;
	
	private UserService userService;
	
	private MovieService movieService;
	
	public LogService(LogRepository logRepository, UserService userService, MovieService movieService) {
		this.logRepository = logRepository;
		this.userService = userService;
		this.movieService = movieService;
	}

	public void generateDeleteLogOfUser(String idUser, String idMovie) {
		User userEntity = userService.findUserById(idUser);
		ResponseMovieDTO movieEntity = movieService.findById(idMovie);
		Log log = new Log();
		log.setDate(LocalDateTime.now());
		log.setOperation(Operation.DELETE);
		log.setUser(userEntity.getName());
		log.setMovie(movieEntity.title());
		logRepository.save(log);
	}
	
}
