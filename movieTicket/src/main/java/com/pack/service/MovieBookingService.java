package com.pack.service;

import com.pack.entity.Movie;
import com.pack.model.ResponseMessage;

public interface MovieBookingService {
	
	public ResponseMessage createMovie(Movie movie);
	
	public ResponseMessage getMovie(Long id);
	
	public ResponseMessage deleteMovie(Long id);
	
	public ResponseMessage getMovieList();
	

}
