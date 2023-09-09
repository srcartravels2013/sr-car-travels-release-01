package com.sr.travels.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoData {

    private GeoInfo info;
    private List<GeoResult> results;
}
