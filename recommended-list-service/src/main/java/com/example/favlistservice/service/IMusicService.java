package com.example.favlistservice.service;

import com.example.favlistservice.entities.Tracks;

import java.util.List;

public interface IMusicService {
    Tracks addTrackToFavList(Tracks album);
    List<Tracks> showFavListTracks();
}

/*
* https://api.napster.com/v2.1/tracks/isrc/TCAFI2188091?apikey=MTcwY2VlZjEtYzc3Yi00MDliLWE5YzQtNWUxMDhjYzFmYzUy
* */
