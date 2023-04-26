package com.talkieVerse.responsewrapper;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.talkieVerse.models.MoviesModel;



@SuppressWarnings("deprecation")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ResponseWrapper implements Serializable {

	StatusDescription statusDescription;
	@JsonIgnore
	HttpStatus httpStatus;
	Page<MoviesModel> Movies;
	MoviesModel Movie;

	public Page<MoviesModel> getMovies() {
		return Movies;
	}

	public void setMovies(Page<MoviesModel> movies) {
		Movies = movies;
	}

	public MoviesModel getMovie() {
		return Movie;
	}

	public void setMovie(MoviesModel movie) {
		Movie = movie;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public StatusDescription getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(StatusDescription statusDescription) {
		this.statusDescription = statusDescription;
	}

}
