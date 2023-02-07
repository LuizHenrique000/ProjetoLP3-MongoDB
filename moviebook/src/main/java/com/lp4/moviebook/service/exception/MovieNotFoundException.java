package com.lp4.moviebook.service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieNotFoundException {
	
	private String id;
	private String success;
	private String statusCode;
	private String statusMessage;

}
