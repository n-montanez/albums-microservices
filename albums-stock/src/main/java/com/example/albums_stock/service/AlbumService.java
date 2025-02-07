package com.example.albums_stock.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.albums_stock.model.album.Album;
import com.example.albums_stock.model.album.AlbumPayload;
import com.example.albums_stock.repository.AlbumRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumRepository albumRepository;

    public List<Album> getAll() {
        return albumRepository.findAll();
    }

    public Album getById(UUID id) {
        return albumRepository.findById(id).orElse(null);
    }

    public Album create(AlbumPayload payload) {
        return albumRepository.save(
                new Album(UUID.randomUUID(),
                        payload.getTitle(),
                        payload.getArtistName(),
                        payload.getReleaseDate(),
                        payload.getTracks()));
    }
}
