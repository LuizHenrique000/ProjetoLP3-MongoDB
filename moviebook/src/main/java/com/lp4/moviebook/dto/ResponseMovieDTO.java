package com.lp4.moviebook.dto;

import javax.validation.constraints.NotBlank;

public record ResponseMovieDTO(
        @NotBlank(message = "The id must not be empty")
        String id,

        @NotBlank(message = "The title must not be empty")
        String title,

        @NotBlank(message = "The overview must not be empty")
        String overview,

        @NotBlank(message = "The release date must not be empty")
        String release_date) {
}
