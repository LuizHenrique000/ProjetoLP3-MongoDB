package com.lp4.moviebook.service;

import java.time.LocalDateTime;
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
		User userEntity = getUser(idUser);
		Movie movieEntity = getMovie(idMovie);
		Log log = new Log();
		log.setDate(LocalDateTime.now());
		log.setOperation(Operation.DELETE);
		log.setUser(userEntity);
		log.setMovie(movieEntity);
		logRepository.save(log);
	}
	
	private User getUser(String idUser) {
		return userService.findUserById(idUser);
	}
	
	private Movie getMovie(String idMovie) {
		return movieService.findById(idMovie);
	}
	
}
