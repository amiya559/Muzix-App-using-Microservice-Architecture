package com.example.favlistservice.service;

import static org.junit.jupiter.api.Assertions.*;
import com.example.favlistservice.entities.Tracks;
import com.example.favlistservice.repositories.MusicRepositories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class MusicServiceTest {

    @Mock
    private MusicRepositories musicRepositories;

    @InjectMocks
    private MusicService musicService;
    private Tracks track1;
    private List<Tracks> tracksList;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        track1 = new Tracks(30, "tra.551078604", "tra.551078604", "https://api.napster.com/v2.2/tracks/tra.551078604",
                "Helo", "art.379441239", "Afaces", "Nefasto",
                "alb.551078597", "https://listen.hs.llnwd.net/g3/prvw/3/2/4/9/8/2288989423.mp3");

        tracksList.add(track1);
    }

    public void tearDown(){
        tracksList = null;
        track1 = null;
    }

//    @Test
//    public void whenGivenATrackToAddThenShouldAddATrackToList(){
//        when(musicRepositories.save(any())).thenReturn(track1);
//
//        assertEquals(track1, musicService.addTrackToFavList(track1));
//        verify(musicRepositories, times(1)).save(any());
//    }
}