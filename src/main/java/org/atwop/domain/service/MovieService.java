package org.atwop.domain.service;

import org.atwop.domain.dto.SaveMovieResponseDto;
import org.atwop.domain.model.Movie;
import java.util.List;


public interface MovieService {

      List<Movie> getMovies();

      SaveMovieResponseDto saveMovie(Movie movie);
}
