package com.desafio.alura.desafioalurascreensound.service;

import com.desafio.alura.desafioalurascreensound.model.Artist;
import com.desafio.alura.desafioalurascreensound.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    List<Artist> findAll();
    Artist findArtistByNameContainsIgnoreCase(String name);
    @Query("SELECT s FROM Artist a JOIN a.songList s WHERE a.name ILIKE %:artist%")
    List<Song> findSongsByArtist(String artist);

    Artist findByName(String name);
}
