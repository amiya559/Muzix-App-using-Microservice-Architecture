package com.example.favlistservice.controller;

import com.example.favlistservice.entities.ResponseDto;
import com.example.favlistservice.entities.Tracks;
import com.example.favlistservice.service.MusicService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/songs")
public class MusicController {
    @Value("${spring.datasource.api-key}")
    private String apiKEY;

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @Autowired
    private MusicService service;

    private final String baseURL = "https://api.napster.com/v2.1";
    private final String baseURL2 = "https://api.napster.com/v2.2";

    @GetMapping("/recommendSongs")
    public ResponseEntity<?> listOfAllPopularTracks(){
        String responseEntity = restTemplate.getForObject(baseURL + "/tracks/top" + "?apikey=" + apiKEY, String.class);
        JSONObject obj = new JSONObject(responseEntity);
        JSONArray arr = obj.getJSONArray("tracks");

        List<ResponseDto> listOfTracks = new ArrayList<ResponseDto>();
        for (int i = 0; i < arr.length(); i++) {
            listOfTracks.add(
                    new ResponseDto(
                            arr.getJSONObject(i).getString("isrc"),
                            arr.getJSONObject(i).getString("id"),
                            arr.getJSONObject(i).getString("href"),
                            arr.getJSONObject(i).getString("name"),
                            arr.getJSONObject(i).getString("artistId"),
                            arr.getJSONObject(i).getString("artistName"),
                            arr.getJSONObject(i).getString("albumName"),
                            arr.getJSONObject(i).getString("albumId"),
                            arr.getJSONObject(i).getString("previewURL")
                    )
            );
        }

        return new ResponseEntity<>(listOfTracks, HttpStatus.OK);
    }

    @PostMapping ("/addTrackToFavorite/{isrc}")
    public ResponseEntity<?> addATrack(@PathVariable("isrc") String isrc){
        String responseEntity = restTemplate.getForObject(baseURL2 + "/tracks/isrc/"+ isrc + "?apikey=" + apiKEY, String.class);
        JSONObject obj = new JSONObject(responseEntity);
        JSONArray arr = obj.getJSONArray("tracks");

        Tracks newTrack = new Tracks();
        newTrack.setISRC(arr.getJSONObject(0).getString("isrc"));
        newTrack.setTrackId(arr.getJSONObject(0).getString("id"));
        newTrack.setHrefLink(arr.getJSONObject(0).getString("href"));
        newTrack.setTrackName(arr.getJSONObject(0).getString("name"));
        newTrack.setArtistId(arr.getJSONObject(0).getString("artistId"));
        newTrack.setArtistName(arr.getJSONObject(0).getString("artistName"));
        newTrack.setAlbumName(arr.getJSONObject(0).getString("albumName"));
        newTrack.setAlbumId(arr.getJSONObject(0).getString("albumId"));
        newTrack.setPreviewURL(arr.getJSONObject(0).getString("previewURL"));

        service.addTrackToFavList(newTrack);
        return new ResponseEntity<>(newTrack, HttpStatus.OK);
    }
}