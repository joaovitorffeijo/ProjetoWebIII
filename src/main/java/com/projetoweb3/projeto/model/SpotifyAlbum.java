package com.projetoweb3.projeto.model;

public class SpotifyAlbum {
    private String artistName;
    private String albumName;
    private String releaseDate;

    public SpotifyAlbum(String artistName, String albumName, String releaseDate) {
        this.artistName = artistName;
        this.albumName = albumName;
        this.releaseDate = releaseDate;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return "Artist: " + artistName + "\nAlbum: " + albumName + "\nRelease Date: " + releaseDate + "\n";
    }
}
