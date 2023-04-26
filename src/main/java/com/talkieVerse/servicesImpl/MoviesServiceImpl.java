package com.talkieVerse.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.talkieVerse.models.MoviesModel;
import com.talkieVerse.repos.MoviesRepo;
import com.talkieVerse.responsewrapper.ResponseWrapper;
import com.talkieVerse.responsewrapper.StatusDescription;
import com.talkieVerse.services.MoviesService;

@Service
public class MoviesServiceImpl implements MoviesService {

	@Autowired
	MoviesRepo moviesRepo;

	@Override
	public ResponseWrapper findAllByCreatedAtWithPagination(Integer pageNumber, Integer pageSize) {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();
		try {
			responseWrapper1.setStatusDescription(statusDescription1);

			PageRequest pageData = PageRequest.of(pageNumber, pageSize);

			Page<MoviesModel> findAllWithPagination = this.moviesRepo.findAll(pageData);

			if (findAllWithPagination.isEmpty()) {
				statusDescription1.setStatusCode(220);
				statusDescription1.setStatusDescription("No Data Found");
				responseWrapper1.setStatusDescription(statusDescription1);
				responseWrapper1.setHttpStatus(HttpStatus.OK);
				return responseWrapper1;
			}

			responseWrapper1.setMovies(findAllWithPagination);
			statusDescription1.setStatusCode(200);
			statusDescription1.setStatusDescription("Success");
			responseWrapper1.setHttpStatus(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			statusDescription1.setStatusCode(500);
			statusDescription1.setStatusDescription("Internal Server Error");
			responseWrapper1.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseWrapper1;
	}

	@Override
	public ResponseWrapper getMovieWithId(Long movieId) {
		ResponseWrapper responseWrapper1 = new ResponseWrapper();
		StatusDescription statusDescription1 = new StatusDescription();
		try {
			
			responseWrapper1.setStatusDescription(statusDescription1);

			Optional<MoviesModel> findById = this.moviesRepo.findById(movieId);

			if (findById.isEmpty()) {
				statusDescription1.setStatusCode(220);
				statusDescription1.setStatusDescription("No Data Found");
				responseWrapper1.setStatusDescription(statusDescription1);
				responseWrapper1.setHttpStatus(HttpStatus.OK);
				return responseWrapper1;
			}

			responseWrapper1.setMovie(findById.get());
			statusDescription1.setStatusCode(200);
			statusDescription1.setStatusDescription("Success");
			responseWrapper1.setHttpStatus(HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			statusDescription1.setStatusCode(500);
			statusDescription1.setStatusDescription("Internal Server Error");
			responseWrapper1.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseWrapper1;
	}

}
