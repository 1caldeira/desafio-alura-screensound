package com.desafio.alura.desafioalurascreensound.model;

public enum ArtistType {
    SOLO("solo"),
    DUO("duo"),
    BAND("band");


    private String artistTypeString;

    ArtistType(String artistTypeString) {
        this.artistTypeString = artistTypeString;
    }

    public static ArtistType fromString(String text) {
        for (ArtistType artistType : ArtistType.values()) {
            if (artistType.artistTypeString.equalsIgnoreCase(text)) {
                return artistType;
            }
        }
        throw new IllegalArgumentException("No artist type found using the String given as parameter: "+text);
    }
}