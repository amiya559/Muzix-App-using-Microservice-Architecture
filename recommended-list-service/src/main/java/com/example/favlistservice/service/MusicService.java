package com.example.favlistservice.service;

import com.example.favlistservice.entities.Tracks;
import com.example.favlistservice.repositories.MusicRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService{

    @Autowired
    MusicRepositories repositories;

    @Override
    public Tracks addTrackToFavList(Tracks track) {
        return repositories.save(track);
    }

    @Override
    public List<Tracks> showFavListTracks() {
        return repositories.findAll();
    }
}
