package com.lp4.moviebook.dto;

import javax.validation.constraints.NotBlank;

public record RequestDTO(

        @NotBlank(message = "The user id must not be empty") String idUser,

        @NotBlank(message = "The movie id must not be empty") String idMovie) {
}
