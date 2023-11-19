package org.atwop.infrastructure.config.bean;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.atwop.domain.repository.MovieRepository;
import org.atwop.domain.service.DomainMovieService;
import org.atwop.domain.service.MovieService;
import org.atwop.infrastructure.repository.panache.MoviePersistenceService;

@ApplicationScoped
public class BeanCreation {
    @Produces
    @ApplicationScoped
    public MovieRepository getMovieRepository() {
        return new MoviePersistenceService();
    }

    @Produces
    @ApplicationScoped
    public MovieService getMovieService() {
        return new DomainMovieService(getMovieRepository());
    }
}
