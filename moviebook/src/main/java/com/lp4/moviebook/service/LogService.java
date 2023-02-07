package com.lp4.moviebook.service;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import com.lp4.moviebook.enums.Operation;
import com.lp4.moviebook.model.Log;
import com.lp4.moviebook.model.User;
import com.lp4.moviebook.repository.LogRepository;

@Service
public class LogService {
	
	private LogRepository logRepository;
	
	private UserService userService;
	
	public LogService(LogRepository logRepository, UserService userService) {
		this.logRepository = logRepository;
		this.userService = userService;
		
	}

	public void generateDeleteLogOfUser(String idUser) {
		User entity = getUser(idUser);
		Log log = new Log();
		log.setDate(LocalDateTime.now());
		log.setOperation(Operation.DELETE);
		log.setUser(entity);
		logRepository.save(log);
	}
	
	private User getUser(String idUser) {
		return userService.findUserById(idUser);
	}
	
}
