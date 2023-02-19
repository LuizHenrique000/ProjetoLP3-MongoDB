package com.lp4.moviebook.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.lp4.moviebook.dto.ResponseMovieDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {

	@Id
	@NotBlank(message = "The id must not be empty")
	private String id;
	
	@NotBlank(message = "The name must not be empty")
	private String name;
	
	@NotBlank(message = "The age must not be empty")
	private String age;
	
	private List<ResponseMovieDTO> watchedMovies = new ArrayList<>();
	
	private List<ResponseMovieDTO> watchList = new ArrayList<>();
	
}
