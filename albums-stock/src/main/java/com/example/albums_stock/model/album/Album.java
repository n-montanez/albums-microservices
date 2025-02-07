package com.example.albums_stock.model.album;

import java.util.Date;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "album")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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

    public Album(String title, String artistName, Date releaseDate, Integer tracks) {
        this.title = title;
        this.artistName = artistName;
        this.releaseDate = releaseDate;
        this.tracks = tracks;
    }

}
