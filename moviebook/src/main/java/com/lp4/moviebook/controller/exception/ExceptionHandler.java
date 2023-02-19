package com.lp4.moviebook.controller.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> errors.add(error.getDefaultMessage()));
        exception.getBindingResult().getGlobalErrors().forEach(error -> errors.add(error.getDefaultMessage()));
        ResponseErrorDTO apiError = ResponseErrorDTO.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Validation error")
                .errors(errors)
                .timestamp(LocalDateTime.now())
                .build();
        return handleExceptionInternal(exception, apiError, headers, apiError.getStatus(), request);
    }
}