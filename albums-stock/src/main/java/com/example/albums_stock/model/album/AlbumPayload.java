package com.example.albums_stock.model.album;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AlbumPayload {
    @NotNull
    @NotEmpty(message = "Album title cannot be empty")
    private String title;

    @NotNull
    @NotEmpty(message = "Artist name cannot be empty")
    private String artistName;

    @NotNull
    private Date releaseDate;

    @Min(value = 1, message = "Album tracks should be a positive number")
    private Integer tracks;
}
