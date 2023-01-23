package com.lp4.moviebook.model;

import java.util.ArrayList;
import java.util.List;
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
	private String id;
	
	private String name;
	
	private int age;
	
	private List<Movie> watchedMovies = new ArrayList<>();
	
	private List<Movie> watchList = new ArrayList<>();
	
}
