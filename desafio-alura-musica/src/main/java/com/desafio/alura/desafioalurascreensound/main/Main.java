package com.desafio.alura.desafioalurascreensound.main;

import com.desafio.alura.desafioalurascreensound.model.Artist;
import com.desafio.alura.desafioalurascreensound.model.ArtistType;
import com.desafio.alura.desafioalurascreensound.model.Song;
import com.desafio.alura.desafioalurascreensound.service.ArtistRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    Scanner sc = new Scanner(System.in);
    private ArtistRepository repository;
    private List<Artist> artistList = new ArrayList<>();

    public Main(ArtistRepository repository) {
        this.repository = repository;
    }

    public void showMenu() {
        var option = -1;

        while (option!= 0) {
            var menu = """
                    *** Screen Sound Músicas ***                    
                                        
                    1- Register artists
                    2- Register songs
                    3- Show all songs by artist
                    4- Show all songs
                                    
                    0 - Sair
                    """;

            System.out.println(menu);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    registerArtists();
                    break;
                case 2:
                    registerSongs();
                    break;
                case 3:
                    showAllSongsByArtist();
                    break;
                case 4:
                    showAllSongs();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    private void getArtists(){
        artistList = repository.findAll();
    }

    private Artist getArtist(String name){
        return repository.findByName(name);
    }

    private void registerArtists() {
        System.out.println("What's the name of the artist you wish to register?");
        var name = sc.nextLine();
        System.out.println("Is it a band, duo or solo artist?");
        var type = sc.nextLine();
        Artist artist = new Artist(name, ArtistType.fromString(type));
        repository.save(artist);
    }

    private void registerSongs() {
        System.out.println("What is the title of the song you wish to register?");
        var songTitle = sc.nextLine();
        System.out.println("Whose song is this?");
        var artistName = sc.nextLine();
        Artist artist = repository.findArtistByNameContainsIgnoreCase(artistName);
        if(artist != null) {
            Song song = new Song(songTitle, artist);
            artist.getSongList().add(song);
            repository.save(artist);
        }else{
            System.out.println("Artist not found!");
        }
    }

    private void showAllSongsByArtist() {
        System.out.println("From which artist do you wish to find songs?");
        getArtists();
        artistList.forEach(System.out::println);
        var artistSearch = sc.nextLine();
        List<Song> artistSongList = repository.findSongsByArtist(artistSearch);
        artistSongList.forEach(System.out::println);
        }

    private void showAllSongs() {
        getArtists();
        for (Artist a:artistList) {
            a.getSongList().forEach(System.out::println);
        }
    }
}
