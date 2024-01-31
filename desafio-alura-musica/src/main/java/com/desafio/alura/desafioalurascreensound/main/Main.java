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
                    3- Show all songs
                    4- Show all songs by artist
                                    
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
                    showSongs();
                    break;
                case 4:
                    searchSongsByArtist();
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
    private void searchSongsByArtist() {
    }

    private void showSongs() {
        System.out.println("From which artist do you wish to find songs?");
        getArtists();
        artistList.forEach(System.out::println);

        
    }

    private void registerSongs() {
        System.out.println("What is the title of the song you wish to register?");
        var songTitle = sc.nextLine();
        System.out.println("Whose song is this?");
        var artistName = sc.nextLine();
        getArtists();
        for (Artist a:artistList) {
            if(a.getName().equalsIgnoreCase(artistName)){
                Song song = new Song(songTitle,a);
                a.getSongList().add(song);
                repository.save(a);
            }else{
                System.out.println("Artist not found!");
            }
        }
        
    }

    private void registerArtists() {
        System.out.println("What's the name of the artist you wish to register?");
        var name = sc.nextLine();
        System.out.println("Is it a band, duo or solo artist?");
        var type = sc.nextLine();
        Artist artist = new Artist(name, ArtistType.fromString(type));
        repository.save(artist);
    }
}
