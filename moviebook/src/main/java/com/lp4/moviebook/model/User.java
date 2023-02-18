package com.lp4.moviebook.model;

import java.util.ArrayList;
import java.util.List;
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
	@NotNull(message = "{id.not.null}")
	private String id;
	
	@NotNull(message = "{name.not.null}")
	private String name;
	
	@NotNull(message = "{age.not.null}")
	private String age;
	
	private List<ResponseMovieDTO> watchedMovies = new ArrayList<>();
	
	private List<ResponseMovieDTO> watchList = new ArrayList<>();
	
}
