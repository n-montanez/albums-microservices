package com.example.albums_stock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.albums_stock.model.album.Album;
import com.example.albums_stock.repository.AlbumRepository;

@SpringBootApplication
public class AlbumsStockApplication {

	@Bean
	CommandLineRunner commandLineRunner(AlbumRepository albumRepository) {
		return args -> {
			DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			albumRepository.save(
					new Album("Hurry Up Tomorrow", "The Weeknd", format.parse("31-01-2025"), 22));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(AlbumsStockApplication.class, args);
	}

}
