package com.amiya.favoriteservice.repository;

import com.amiya.favoriteservice.model.FavoriteMusic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteMusicRepo extends JpaRepository<FavoriteMusic, Integer> {
    FavoriteMusic findByISRC(String isrcId);
}
