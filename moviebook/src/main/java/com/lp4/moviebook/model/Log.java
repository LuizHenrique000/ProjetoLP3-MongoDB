package com.lp4.moviebook.model;

import java.time.LocalDateTime;

import com.lp4.moviebook.dto.ResponseMovieDTO;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.lp4.moviebook.enums.Operation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
@Builder
public class Log {
	
	@Id
	private String id;
	
	private LocalDateTime date;
	
	private Operation operation;
	
	private String user;
	
	private String movie;

}
