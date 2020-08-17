package com.pack.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.entity.Movie;
import com.pack.model.MovieModel;
import com.pack.model.ResponseMessage;
import com.pack.service.MovieBookingService;

import io.swagger.annotations.ApiOperation;



@ComponentScan({ "com.pack.service", "com.pack.dao" })
@CrossOrigin(origins = "*", allowCredentials = "false", allowedHeaders = "*")
@RestController
@RequestMapping("movie/")
public class MovieBookingController {
	
	@Autowired
	private MovieBookingService movieBookingService;

	
	@ApiOperation(value = "Create Movie API")
	@PostMapping(value="create",produces = "application/json",consumes = "application/json")
	public ResponseMessage create(@RequestBody MovieModel movie ) {
		return movieBookingService.createMovie(movie);
	}
	
	
	@ApiOperation(value = "Get Movie By ID API")
	@GetMapping(value = "getMovie/{id}", produces = "application/json")
	public ResponseMessage getMovie(@PathVariable("id") Long id) {
		return movieBookingService.getMovie(id);
	}

	
	
	@ApiOperation(value = "Get Movie List API")
	@GetMapping(value = "getMovieList", produces = "application/json")
	public ResponseMessage getMovieList() {
		return movieBookingService.getMovieList();
	}
	
	@ApiOperation(value = "Delete Movie By ID API")
	@DeleteMapping(value = "deleteMovie/{id}", produces = "application/json")
	public ResponseMessage deleteMovie(@PathVariable("id") Long id) {
		return movieBookingService.deleteMovie(id);
	}
	
	
}
