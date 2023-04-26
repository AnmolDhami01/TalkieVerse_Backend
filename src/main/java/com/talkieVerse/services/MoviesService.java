package com.talkieVerse.services;

import com.talkieVerse.responsewrapper.ResponseWrapper;

public interface MoviesService {

	ResponseWrapper findAllByCreatedAtWithPagination(Integer pageNumber, Integer pageSize);

	ResponseWrapper getMovieWithId(Long movieId);

}
