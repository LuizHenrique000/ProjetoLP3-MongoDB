package com.lp4.moviebook.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {

	@Id
	private String id;
	
	private String name;
	
	private int age;
	
	private List<Movie> watchedMovies;
	
	private List<Movie> watchList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Movie> getWatchedMovies() {
		return watchedMovies;
	}

	public void setWatchedMovies(List<Movie> watchedMovies) {
		this.watchedMovies = watchedMovies;
	}

	public List<Movie> getWatchList() {
		return watchList;
	}

	public void setWatchList(List<Movie> watchList) {
		this.watchList = watchList;
	}
	
	
}
