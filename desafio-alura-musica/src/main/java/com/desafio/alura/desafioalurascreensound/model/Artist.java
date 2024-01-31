package com.desafio.alura.desafioalurascreensound.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name="artists")
public class Artist {
    @Column(unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private ArtistType type;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Song> songList;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Artist() {
    }

    public Artist(String name, ArtistType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArtistType getType() {
        return type;
    }

    public void setType(ArtistType type) {
        this.type = type;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
