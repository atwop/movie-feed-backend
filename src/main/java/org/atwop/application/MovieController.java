package org.atwop.application;


import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.atwop.application.dto.SaveMovieRequestDto;
import org.atwop.domain.dto.SaveMovieResponseDto;
import org.atwop.domain.model.Movie;
import org.atwop.domain.service.MovieService;

import java.util.List;

@Path("/movie")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovieController {

    @Inject
    MovieService movieService;

    @GET
    public List<Movie> getAll() {
        return movieService.getMovies();
    }

    @POST
    @Transactional
    public SaveMovieResponseDto saveMovie(SaveMovieRequestDto requestDto) {
        return movieService.saveMovie(new Movie(requestDto.getTitle(), requestDto.getPunctuation()));
    }
}
