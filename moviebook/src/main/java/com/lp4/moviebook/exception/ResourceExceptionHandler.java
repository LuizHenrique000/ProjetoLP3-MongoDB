//package com.lp4.moviebook.exception;
//
//import java.time.Instant;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//
//import com.lp4.moviebook.service.exception.MovieNotFoundException;
//import jakarta.servlet.http.HttpServletRequest;
//
//@ControllerAdvice
//public class ResourceExceptionHandler {
//
//	public ResponseEntity<StandardError> movieNotFound(MovieNotFoundException e, HttpServletRequest request) {
//		StandardError err = new StandardError();
//		err.setTimestamp(Instant.now());
//		err.setStatus(e.getStatusCode());
//		err.setMessage(e.getMessage());
//		err.setPath(request.getRequestURI());
//		return ResponseEntity.status(e.getStatusCode()).body(err);
//	}
//
//