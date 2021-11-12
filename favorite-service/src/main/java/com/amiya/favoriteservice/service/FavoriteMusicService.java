package com.amiya.favoriteservice.service;

import com.amiya.favoriteservice.model.FavoriteMusic;
import com.amiya.favoriteservice.repository.FavoriteMusicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteMusicService {

    @Autowired
    private FavoriteMusicRepo favoriteMusicRepo;

    public List<FavoriteMusic> getAllFavoriteSongs() {
        return favoriteMusicRepo.findAll();
    }

    public FavoriteMusic getFavoriteSongById(String isrcId) {
        return favoriteMusicRepo.findByISRC(isrcId);
    }
}
