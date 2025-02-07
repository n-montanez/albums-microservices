package com.example.albums_stock.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.albums_stock.model.album.Album;

public interface AlbumRepository extends JpaRepository<Album, UUID> {

}
