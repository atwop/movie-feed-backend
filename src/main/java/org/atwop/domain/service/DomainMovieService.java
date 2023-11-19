package org.atwop.domain.service;
import org.atwop.domain.dto.SaveMovieResponseDto;
import org.atwop.domain.model.Movie;
import org.atwop.domain.repository.MovieRepository;
import java.util.List;
public class DomainMovieService implements MovieService {

    private final MovieRepository movieRepository;

    public DomainMovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public List<Movie> getMovies() {
        return movieRepository.findAll().orElse(List.of());
    }

    @Override
    public SaveMovieResponseDto saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
