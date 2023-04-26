package com.talkieVerse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.talkieVerse.responsewrapper.ResponseWrapper;
import com.talkieVerse.services.MoviesService;

@RestController
@RequestMapping("movies/v1/")
@CrossOrigin(value = "*")
public class MoviesController {

	@Autowired
	MoviesService moviesService;

	@GetMapping("getAllMoviesPagineted")
	public ResponseEntity<ResponseWrapper> getAllMovies(
			@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		responseWrapper = this.moviesService.findAllByCreatedAtWithPagination(pageNumber, pageSize);

		return new ResponseEntity<>(responseWrapper, responseWrapper.getHttpStatus());
	}

	@GetMapping("getMovieById")
	public ResponseEntity<ResponseWrapper> getMoviesById(@RequestParam(value = "id", required = true) Long movieId) {

		ResponseWrapper responseWrapper = new ResponseWrapper();

		responseWrapper = this.moviesService.getMovieWithId(movieId);

		return new ResponseEntity<>(responseWrapper, responseWrapper.getHttpStatus());
	}

}
