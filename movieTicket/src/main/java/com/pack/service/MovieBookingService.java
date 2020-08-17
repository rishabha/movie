package com.pack.service;


import com.pack.model.MovieModel;
import com.pack.model.ResponseMessage;

public interface MovieBookingService {
	
	public ResponseMessage createMovie(MovieModel movie);
	
	public ResponseMessage getMovie(Long id);
	
	public ResponseMessage deleteMovie(Long id);
	
	public ResponseMessage getMovieList();
	

}
