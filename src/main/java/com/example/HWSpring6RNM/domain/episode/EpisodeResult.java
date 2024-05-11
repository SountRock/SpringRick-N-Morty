package com.example.HWSpring6RNM.domain.episode;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EpisodeResult {
    int id;
    String name;
    String air_date;
    String episode;
    String url;
    Date created;
}
