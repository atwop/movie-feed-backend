package org.atwop.domain.repository;

import org.atwop.domain.dto.SaveMovieResponseDto;
import org.atwop.domain.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    Optional<List<Movie>> findAll();

    SaveMovieResponseDto save(Movie movie);
}
