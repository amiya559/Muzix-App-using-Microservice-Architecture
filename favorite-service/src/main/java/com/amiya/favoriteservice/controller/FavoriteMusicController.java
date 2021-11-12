package com.amiya.favoriteservice.controller;

import com.amiya.favoriteservice.model.FavoriteMusic;
import com.amiya.favoriteservice.service.FavoriteMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/music")
public class FavoriteMusicController {

    @Autowired
    private FavoriteMusicService service;

    @GetMapping("/favoriteMusic")
    public List<FavoriteMusic> getAllFavoriteSongs() {
        return service.getAllFavoriteSongs();
    }

    @GetMapping("/favoriteMusicById/{id}")
    public FavoriteMusic getFavoriteSongById(@PathVariable("id") String isrcId) {
        return service.getFavoriteSongById(isrcId);
    }


}
