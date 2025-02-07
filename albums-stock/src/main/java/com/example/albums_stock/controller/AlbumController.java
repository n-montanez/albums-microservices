package com.example.albums_stock.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.albums_stock.model.album.Album;
import com.example.albums_stock.model.album.AlbumPayload;
import com.example.albums_stock.service.AlbumService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/album")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping({ "", "/" })
    public ResponseEntity<List<Album>> getAllAlbums() {
        return new ResponseEntity<>(albumService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable UUID id) {
        Album foundAlbum = albumService.getById(id);
        if (foundAlbum == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(foundAlbum, HttpStatus.OK);
    }

    @PostMapping({ "", "/" })
    public ResponseEntity<Album> createAlbum(@RequestBody @Valid AlbumPayload payload) {
        return new ResponseEntity<>(albumService.create(payload), HttpStatus.CREATED);
    }

}
