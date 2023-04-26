package com.talkieVerse.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.talkieVerse.models.MoviesModel;

public interface MoviesRepo extends JpaRepository<MoviesModel, Long> {

	

}