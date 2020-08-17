package com.pack.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pack.dao.MovieBookingDao;
import com.pack.entity.Movie;

@Repository
@Component
public class MovieBookingDaoImpl implements MovieBookingDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Long createMovie(Movie movie) {
		try {
			em.persist(movie);
			em.close();

			return movie.getPk();
		} catch (Exception e) {

			return 0l;
		}
	}

	@Override
	public Movie getMovie(Long id) {
		try {
			String hql = "from Movie movie where movie.pk = :pk";
			List result = em.createQuery(hql).setParameter("pk", id).getResultList();

			if (result.size() != 0) {

				return (Movie) result.get(0);
			}

		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public List<Movie> getMovieList() {
		try {
			String hql = "from Movie movie";
			@SuppressWarnings("unchecked")
			List<Movie> result = em.createQuery(hql).getResultList();

			if (result.size() != 0) {

				return result;
			}

		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public Integer deleteMovie(Long id) {
		try {

			Query query = em.createQuery("Delete from Movie movie where movie.pk = :pk");
			int deletedCount = query.setParameter("pk", id).executeUpdate();

			return deletedCount;

		} catch (Exception e) {
			return null;
		}

	}

}
