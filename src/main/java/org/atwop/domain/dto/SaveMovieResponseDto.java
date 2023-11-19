package org.atwop.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SaveMovieResponseDto {
    private String movieId;
    private String title;
}
