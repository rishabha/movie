package com.pack.dao;


import java.util.List;

import com.pack.entity.Movie;

public interface MovieBookingDao {

	public Long createMovie(Movie movie);
	
	public Movie getMovie(Long id);
	
	
	public List<Movie> getMovieList();
	
	public Integer deleteMovie(Long id);
	
}
