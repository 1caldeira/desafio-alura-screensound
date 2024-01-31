package com.desafio.alura.desafioalurascreensound.service;

import com.desafio.alura.desafioalurascreensound.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {

    List<Artist> findAll();
}
