package org.atwop.domain.model;

import org.atwop.domain.exception.MovieCreationException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public final class Movie {
    private  String id;
    private final String title;
    private final Float punctuation;
    private final LocalDateTime dateCreated;

    private final List<String> validStatus = Arrays.asList("ACTIVE","INACTIVE");

    private final String status;
    public Movie(String id, String title, Float punctuation, LocalDateTime dateCreated,
                 String status) {
        this.id = id;
        this.title = title;
        this.punctuation = punctuation;
        this.dateCreated = dateCreated;
        this.status = status;
        validate();
    }

    public Movie(String title, Float punctuation) {
        this(UUID.randomUUID().toString(), title, punctuation, LocalDateTime.now(),
                "ACTIVE");
    }

    private void validate() {
        Optional.ofNullable(this.id).orElseThrow(() ->new MovieCreationException("id is invalid"));
        Optional.ofNullable(this.title).orElseThrow(() ->new MovieCreationException("title is invalid"));
        Optional.ofNullable(this.dateCreated).orElseThrow(() ->new MovieCreationException("dateCreated is invalid"));
        Optional.ofNullable(this.status).orElseThrow(() ->new MovieCreationException("status is invalid"));
        if (!validStatus.contains(this.status)) {
            throw new MovieCreationException(String.format("%s is invalid", this.status));
        }

    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Float getPunctuation() {
        return punctuation;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public String getStatus() {
        return status;
    }
}