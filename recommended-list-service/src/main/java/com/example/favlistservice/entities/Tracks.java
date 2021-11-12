package com.example.favlistservice.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Favorite_Tracks")
public class Tracks {
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
