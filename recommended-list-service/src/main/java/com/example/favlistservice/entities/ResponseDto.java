package com.example.favlistservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
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
