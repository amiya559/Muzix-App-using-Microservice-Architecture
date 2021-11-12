package com.example.favlistservice.controller;

import static org.junit.jupiter.api.Assertions.*;


import com.example.favlistservice.entities.Tracks;
import com.example.favlistservice.service.MusicService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class MusicControllerTest {
    private MockMvc mockMvc;

    @Mock
    private MusicService musicService;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private MusicController musicController;

    private Tracks track;
    private List<Tracks> tracksList;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(musicController).build();

        track = new Tracks(30, "tra.551078604", "tra.551078604", "https://api.napster.com/v2.2/tracks/tra.551078604",
                "Helo", "art.379441239", "Afaces", "Nefasto",
                "alb.551078597", "https://listen.hs.llnwd.net/g3/prvw/3/2/4/9/8/2288989423.mp3");

        tracksList = new ArrayList<>();
        tracksList.add(track);
    }

    @AfterEach
    public void tearDown(){
        track = null;
        tracksList = null;
    }

    @Test
    public void whenExternalApiCalledThenShouldReturnListOfTracks() {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "https://api.napster.com/v2.1/tracks/top?apikey=MTcwY2VlZjEtYzc3Yi00MDliLWE5YzQtNWUxMDhjYzFmYzUy";
        ResponseEntity<String> result = restTemplate.getForEntity(baseUrl, String.class);

        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
        assertTrue(Objects.requireNonNull(result.getBody()).contains("tracks"));
    }

    @Test
    public void whenExternalApiCalledForSingleTrackUSingIDThenShouldReturnTrackWithMatchingID(){
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "https://api.napster.com/v2.2/tracks/isrc/TCAFI2188091?apikey=MTcwY2VlZjEtYzc3Yi00MDliLWE5YzQtNWUxMDhjYzFmYzUy";
        ResponseEntity<String> result = restTemplate.getForEntity(baseUrl, String.class);

        System.out.println(result);

        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
        assertTrue(Objects.requireNonNull(result.getBody()).contains("tracks"));

    }

//    @Test
//    public void whenAddATrackCalledThenShouldAddATrack() throws Exception {
//        String apiKey = null;
//        when(restTemplate.getForObject("https://api.napster.com/v2.2/tracks/isrc/TCAFI2188091?apikey=" + apiKey, String.class)).thenReturn(track);
//    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
























