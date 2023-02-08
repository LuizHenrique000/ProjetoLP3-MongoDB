package com.lp4.moviebook.model;

import java.time.LocalDateTime;
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
public class Log {
	
	@Id
	private String id;
	
	private LocalDateTime date;
	
	private Operation operation;
	
	private User user; 
	
	private Movie movie;

}
