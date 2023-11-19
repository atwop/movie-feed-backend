package org.atwop.infrastructure.repository.panache;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.atwop.domain.dto.SaveMovieResponseDto;
import org.atwop.domain.model.Movie;
import org.atwop.domain.repository.MovieRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
//@ApplicationScoped
public class MoviePersistenceService implements MovieRepository {
    @Override
    public Optional<List<Movie>> findAll() {

        List<MovieEntity> listMovies =  MovieEntity.findAll().list();

        return Optional.of(listMovies.stream().map(me -> new Movie(me.id, me.title, me.punctuation,
                        me.dateCreated, me.status))
                .collect(Collectors.toList()));
    }

    @Transactional
    public SaveMovieResponseDto save(Movie movie) {
        MovieEntity me = new MovieEntity();
        me.id = movie.getId();
        me.title = movie.getTitle();
        me.punctuation = movie.getPunctuation();
        me.dateCreated = movie.getDateCreated();
        me.status = movie.getStatus();
        me.persist();

        return SaveMovieResponseDto.builder()
                .movieId(movie.getId())
                .title(movie.getTitle())
                .build();
    }
}
