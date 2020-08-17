package com.pack.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.dao.MovieBookingDao;
import com.pack.entity.Movie;
import com.pack.model.ErrorMessage;
import com.pack.model.MovieModel;
import com.pack.model.ResponseMessage;
import com.pack.model.StatusMessage;
import com.pack.service.MovieBookingService;


@Service
@Transactional
public class MovieBookingServiceImpl implements MovieBookingService {

	@Autowired
	private MovieBookingDao movieBookingDao;

	@Override
	public ResponseMessage createMovie(MovieModel movieModel) {
		ResponseMessage responseMessage = new ResponseMessage();

		try {
			Movie movie=new Movie();
			movie.setRating(movieModel.getRating());
			movie.setTitle(movieModel.getTitle());
			movie.setCategory(movieModel.getCategory());
			movieBookingDao.createMovie(movie);

			responseMessage.setStatus(new StatusMessage("1", "  Movie is created successfully"));
		} catch (Exception e) {
			responseMessage.setError(new ErrorMessage("ERR01", " Movie is not created "));
		}
		return responseMessage;
	}

	@Override
	public ResponseMessage getMovie(Long id) {
		ResponseMessage responseMessage = new ResponseMessage();

		try {
			Movie	movie =movieBookingDao.getMovie(id);
			if(!movie.equals(null)) {
			responseMessage.setData(movie);
			responseMessage.setStatus(new StatusMessage("1", "Movie is find by id"));
			}
		} catch (Exception e) {
			responseMessage.setError(new ErrorMessage("ERR01", " Movie is not  find by id"));
		}
		return responseMessage;
	}

	@Override
	public ResponseMessage getMovieList() {
		ResponseMessage responseMessage = new ResponseMessage();

		try {
		
			List<Movie>	movieList =movieBookingDao.getMovieList();
			if(movieList.size()!=0) {
			responseMessage.setData(movieList);
			responseMessage.setStatus(new StatusMessage("1", "Movie List"));
			}
		} catch (Exception e) {
			responseMessage.setError(new ErrorMessage("ERR01", " Movie List is not found"));
		}
		return responseMessage;
	}

	@Override
	public ResponseMessage deleteMovie(Long id) {
		ResponseMessage responseMessage = new ResponseMessage();

		try {
		int check=	movieBookingDao.deleteMovie(id);
			if(check!=0) {
			
			responseMessage.setStatus(new StatusMessage("1", "Movie is Deleted by id"));
			}
		} catch (Exception e) {
			responseMessage.setError(new ErrorMessage("ERR01", " Movie is Deleted by id"));
		}
		return responseMessage;
	}

}
