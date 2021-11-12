package com.amiya.favoriteservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Favorite_Tracks")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FavoriteMusic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String ISRC;
    private String trackId;
    private String hrefLink;
    private String trackName;
    private String artistId;
    private String artistName;
    private String albumName;
    private String albumId;
    private String previewURL;


}
