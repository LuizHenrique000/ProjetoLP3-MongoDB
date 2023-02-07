package com.lp4.moviebook.exception;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	private Instant timestamp;
	private HttpStatusCode status;
	private String message;
	private String path;
}
